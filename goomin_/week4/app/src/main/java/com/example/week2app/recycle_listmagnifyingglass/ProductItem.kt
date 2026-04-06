package com.example.week2app.recycle_listmagnifyingglass

data class ProductItem(
    val id: Int,
    val imageRes: Int,
    val name: String,
    val desc: String,
    val colorcount: String,
    val cost: String,
    var isWish: Boolean
)