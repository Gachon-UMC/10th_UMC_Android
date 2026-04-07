package com.example.practice_nike

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PurchaseFragment : Fragment(R.layout.fragment_purchase) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. 임시 데이터(더미 데이터)
        val dummyList = listOf(
            Product("Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)\n%Colors", "US$10", R.drawable.socks1),
            Product("Nike Elite Crew", "Basketball Socks\n7Colors", "US$125", R.drawable.socks2),
            Product("Nike Air Force 1 '07", "Women's Shoes\n5Colors", "US$115", R.drawable.shoes1),
            Product("Nike Elite Crew", "Basketball Socks", "US$16", R.drawable.shoes2)
        )

        // 2. 리사이클러뷰 찾아서 세팅하기
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_purchase)

        // 미션 힌트였던 GridLayoutManager 사용! (2열 설정)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        // 만들어둔 어댑터 연결
        recyclerView.adapter = ProductGridAdapter(dummyList)
    }
}