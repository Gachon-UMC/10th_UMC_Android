package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOrder = view.findViewById<Button>(R.id.btn_order)

        btnOrder.setOnClickListener {
            (activity as? MainActivity)?.moveToShopTab()
        }
    }
}