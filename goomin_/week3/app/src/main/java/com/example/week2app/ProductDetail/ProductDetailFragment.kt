package com.example.week2app.product_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.week2app.R

class ProductDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 1️⃣ 먼저 View inflate
        val view = inflater.inflate(R.layout.product_detail, container, false)

        // 2️⃣ 뒤로가기 버튼 클릭 이벤트
        val backButton = view.findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            parentFragmentManager.popBackStack() // 이전 화면으로 돌아가기
        }

        // 3️⃣ 최종적으로 view 반환
        return view
    }
}