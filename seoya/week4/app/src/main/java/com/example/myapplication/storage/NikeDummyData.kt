package com.example.myapplication.storage

import com.example.myapplication.R
import com.example.myapplication.home.HomeData
import com.example.myapplication.product.ProductData

object NikeDummyData {
    val latestProducts = listOf(
        HomeData(R.drawable.ic_shoe1, "Air Jordan XXXVI", "US$185"),
        HomeData(R.drawable.ic_shoe2, "Nike Air Force 1'07", "US$115")
    )

    val shopProducts = listOf(
        ProductData(
            "socks_everyday_plus",
            R.drawable.ic_socks1,
            "Nike Everyday Plus Cushioned",
            "Training Ankle Socks (6 Pairs)",
            "5 Colours",
            "US$10",
            false,
            true,
            false,
            "전체"
        ),
        ProductData(
            "socks_elite_crew",
            R.drawable.ic_socks2,
            "Nike Elite Crew",
            "Basketball Socks",
            "7 Colours",
            "US$16",
            false,
            false,
            false,
            "전체"
        ),
        ProductData(
            "air_force_women_07",
            R.drawable.ic_airporce,
            "Nike Air Force 1 '07",
            "Women's Shoes",
            "5 Colours",
            "US$115",
            true,
            false,
            false,
            "sale"
        ),
        ProductData(
            "air_force_men_essentials",
            R.drawable.ic_airporce2,
            "Jordan ENike Air Force 1 '07sentials",
            "Men's Shoes",
            "2 Colours",
            "US$115",
            true,
            false,
            false,
            "Tops & T-Shirts"
        )
    )
}
