package com.example.week2app.recycle_home_new

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

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "banner_store")

val bannerKey = stringPreferencesKey("banner_items")

private val gson = Gson()

suspend fun saveBannerItemsToDataStore(
    context: Context,
    items: List<BannerItem>
) {
    val json = gson.toJson(items)

    context.dataStore.edit {
        it[bannerKey] = json
    }
}

fun getBannerItemsFromDataStore(
    context: Context
): Flow<List<BannerItem>> {
    return context.dataStore.data.map { preferences ->
        val json = preferences[bannerKey] ?: ""

        if (json.isEmpty()) {
            emptyList()
        } else {
            val type = object : TypeToken<List<BannerItem>>() {}.type
            gson.fromJson(json, type)
        }
    }
}