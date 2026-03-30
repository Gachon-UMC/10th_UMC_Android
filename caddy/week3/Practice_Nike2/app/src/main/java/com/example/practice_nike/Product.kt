package com.example.practice_nike

// 상품 정보를 담는 데이터 클래스입니다.
data class Product(
    val name: String,
    val description: String,
    val price: String,
    val imageResId: Int // 임시로 사용할 이미지 리소스 ID
)