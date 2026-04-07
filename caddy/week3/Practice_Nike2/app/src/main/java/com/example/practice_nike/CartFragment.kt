package com.example.practice_nike

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOrder = view.findViewById<Button>(R.id.btn_order)
        btnOrder.setOnClickListener {
            // MainActivity로 형변환 후 네비게이션 이동 함수 호출
            val mainActivity = activity as? MainActivity
            mainActivity?.navigateToPurchaseTab()
        }
    }
}