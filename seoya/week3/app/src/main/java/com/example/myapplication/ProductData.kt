package com.example.myapplication

data class ProductData(
    val imageResId: Int,
    val title: String,
    val subTitle: String,
    val colorText: String,
    val price: String,
    val isBestSeller: Boolean,
    val isLiked: Boolean,
    val category: String
)
