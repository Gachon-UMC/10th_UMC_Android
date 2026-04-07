package com.example.myapplication.product

data class ProductData(
    val id: String,
    val imageResId: Int,
    val title: String,
    val subTitle: String,
    val colorText: String,
    val price: String,
    val isBestSeller: Boolean,
    val isLiked: Boolean,
    val isInCart: Boolean,
    val category: String
)
