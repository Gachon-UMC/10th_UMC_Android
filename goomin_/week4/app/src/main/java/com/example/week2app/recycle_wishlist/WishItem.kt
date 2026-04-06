package com.example.week2app.recycle_wishlist

data class WishData(
    val productid: Int,
    val productImage: Int,
    val productName: String,
    val productDesc: String? = null,
    val productColorCount: String? = null,
    val productCost: String
)