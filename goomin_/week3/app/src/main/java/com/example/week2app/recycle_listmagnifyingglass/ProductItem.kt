package com.example.week2app.recycle_listmagnifyingglass

data class ProductItem(
    val imageRes: Int,
    val name: String,
    val desc: String,
    val colorcount: String,
    val price: String,
    var isWish: Boolean = false
)