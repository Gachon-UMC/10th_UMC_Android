package com.example.practice_nike

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WishlistFragment : Fragment(R.layout.fragment_wishlist) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. 위시리스트용 임시 데이터 만들기
        val dummyList = listOf(
            Product("Nike Air Force 1 '07", "Women's Shoes", "US$115", R.drawable.shoes1),
            Product("Nike Everyday Plus", "Training Socks (6 Pairs)", "US$10", R.drawable.home_shoes1),
        )

        // 2. 리사이클러뷰 찾기
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_wishlist)

        // 3. 구매하기 화면과 동일하게 2열 그리드 설정
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // 4. 구매하기에서 만들었던 GridAdapter를 재사용!
        recyclerView.adapter = ProductGridAdapter(dummyList)
    }
}