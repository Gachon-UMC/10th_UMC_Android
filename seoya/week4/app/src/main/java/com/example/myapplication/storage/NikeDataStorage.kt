package com.example.myapplication.storage

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.myapplication.home.HomeData
import com.example.myapplication.product.ProductData
import com.example.myapplication.wish.WishlistData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private const val DATASTORE_NAME = "nike_store"
private const val CURRENT_DATA_VERSION = 2
private val Context.dataStore by preferencesDataStore(name = DATASTORE_NAME)

class NikeDataStore(private val context: Context) {

    private val gson = Gson()

    companion object {
        private val IS_SEEDED = booleanPreferencesKey("is_seeded")
        private val DATA_VERSION = intPreferencesKey("data_version")
        private val LATEST_PRODUCTS_JSON = stringPreferencesKey("latest_products_json")
        private val SHOP_PRODUCTS_JSON = stringPreferencesKey("shop_products_json")
    }

    suspend fun seedInitialDataIfNeeded(
        latestItems: List<HomeData>,
        shopItems: List<ProductData>
    ) {
        context.dataStore.edit { prefs ->
            val seeded = prefs[IS_SEEDED] ?: false
            val version = prefs[DATA_VERSION] ?: 0
            val latestJson = prefs[LATEST_PRODUCTS_JSON]
            val shopJson = prefs[SHOP_PRODUCTS_JSON]
            val shouldResetData = !seeded || version < CURRENT_DATA_VERSION

            if (shouldResetData || latestJson.isNullOrBlank()) {
                prefs[LATEST_PRODUCTS_JSON] = gson.toJson(latestItems)
            }

            if (shouldResetData || shopJson.isNullOrBlank()) {
                prefs[SHOP_PRODUCTS_JSON] = gson.toJson(shopItems)
            }

            prefs[IS_SEEDED] = true
            prefs[DATA_VERSION] = CURRENT_DATA_VERSION
        }
    }

    fun getLatestProducts(): Flow<List<HomeData>> {
        return context.dataStore.data.map { prefs ->
            val json = prefs[LATEST_PRODUCTS_JSON] ?: "[]"
            val type = object : TypeToken<List<HomeData>>() {}.type
            gson.fromJson(json, type) ?: emptyList()
        }
    }

    fun getShopProducts(): Flow<List<ProductData>> {
        return context.dataStore.data.map { prefs ->
            val json = prefs[SHOP_PRODUCTS_JSON] ?: "[]"
            jsonToProductList(json)
        }
    }

    fun getWishlistProducts(): Flow<List<WishlistData>> {
        return getShopProducts().map { items ->
            items
                .filter { it.isLiked }
                .map { it.toWishlistData() }
        }
    }

    fun getCartProducts(): Flow<List<WishlistData>> {
        return getShopProducts().map { items ->
            items
                .filter { it.isInCart }
                .map { it.toWishlistData() }
        }
    }

    suspend fun toggleWishlist(productId: String) {
        context.dataStore.edit { prefs ->
            val currentItems = jsonToProductList(prefs[SHOP_PRODUCTS_JSON] ?: "[]")
            val updatedItems = currentItems.map { product ->
                if (product.id == productId) {
                    product.copy(isLiked = !product.isLiked)
                } else {
                    product
                }
            }
            prefs[SHOP_PRODUCTS_JSON] = gson.toJson(updatedItems)
        }
    }

    suspend fun toggleCart(productId: String): Boolean {
        var addedToCart = false

        context.dataStore.edit { prefs ->
            val currentItems = jsonToProductList(prefs[SHOP_PRODUCTS_JSON] ?: "[]")
            val updatedItems = currentItems.map { product ->
                if (product.id == productId) {
                    val updatedProduct = product.copy(isInCart = !product.isInCart)
                    addedToCart = updatedProduct.isInCart
                    updatedProduct
                } else {
                    product
                }
            }
            prefs[SHOP_PRODUCTS_JSON] = gson.toJson(updatedItems)
        }

        return addedToCart
    }

    private fun jsonToProductList(json: String): List<ProductData> {
        val type = object : TypeToken<List<ProductData>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }

    private fun ProductData.toWishlistData(): WishlistData {
        return WishlistData(
            imageResId = imageResId,
            name = title,
            subTitle = subTitle,
            colorText = colorText,
            price = price
        )
    }
}
