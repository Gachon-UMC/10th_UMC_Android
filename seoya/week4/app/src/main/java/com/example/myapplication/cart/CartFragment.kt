package com.example.myapplication.cart

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.storage.NikeDataStore
import com.example.myapplication.wish.WishlistAdapter
import kotlinx.coroutines.launch

class CartFragment : Fragment(R.layout.fragment_cart) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val emptyLayout = view.findViewById<LinearLayout>(R.id.layout_empty_cart)
        val cartRecyclerView = view.findViewById<RecyclerView>(R.id.rv_cart)
        val btnOrder = view.findViewById<Button>(R.id.btn_order)
        val adapter = WishlistAdapter(mutableListOf())

        cartRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        cartRecyclerView.adapter = adapter

        val nikeDataStore = NikeDataStore(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            nikeDataStore.getCartProducts().collect { cartItems ->
                adapter.updateList(cartItems)
                val hasItems = cartItems.isNotEmpty()
                emptyLayout.visibility = if (hasItems) View.GONE else View.VISIBLE
                cartRecyclerView.visibility = if (hasItems) View.VISIBLE else View.GONE
            }
        }

        btnOrder.setOnClickListener {
            (activity as? MainActivity)?.moveToShopTab()
        }
    }
}
