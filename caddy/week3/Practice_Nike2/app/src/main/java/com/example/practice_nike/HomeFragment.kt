package com.example.practice_nike

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. 홈 화면용 더미 데이터
        val dummyList = listOf(
            Product("Air Jordan XXXVI", "Men's Basketball Shoes", "US$185", R.drawable.home_shoes1),
            Product("Air Jordan 1 Low", "Women's Shoes", "US$115", R.drawable.home_shoes1),
            Product("Nike Air Max 270", "Men's Shoes", "US$160", R.drawable.home_logo)
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_home)

        // 2. 핵심! LinearLayoutManager를 HORIZONTAL(가로)로 설정합니다.
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // 3. 어댑터 연결
        recyclerView.adapter = ProductHomeAdapter(dummyList)
    }
}