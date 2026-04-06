package com.example.week2app.recycle_listmagnifyingglass

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.listDataStore: DataStore<Preferences>
        by preferencesDataStore(name = "list_store")

val listKey = stringPreferencesKey("list_items")

private val gson = Gson()

suspend fun saveProductItemsToDataStore(
    context: Context,
    items: List<ProductItem>
) {
    val json = gson.toJson(items)

    context.listDataStore.edit {
        it[listKey] = json
    }
}

fun getProductItemsFromDataStore(
    context: Context
): Flow<List<ProductItem>> {
    return context.listDataStore.data.map { preferences ->
        val json = preferences[listKey] ?: ""

        if (json.isEmpty()) {
            emptyList()
        } else {
            val type = object : TypeToken<List<ProductItem>>() {}.type
            gson.fromJson(json, type)
        }
    }
}