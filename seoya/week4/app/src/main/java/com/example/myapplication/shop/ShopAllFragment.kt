package com.example.myapplication.shop

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.product.ProductAdapter
import com.example.myapplication.storage.NikeDataStore
import kotlinx.coroutines.launch

class ShopAllFragment : Fragment(R.layout.fragment_shop_all) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rvProduct)
        val nikeDataStore = NikeDataStore(requireContext())

        val adapter = ProductAdapter(
            emptyList(),
            onLikeClicked = { product ->
                viewLifecycleOwner.lifecycleScope.launch {
                    nikeDataStore.toggleWishlist(product.id)
                }
            },
            onCartClicked = { product ->
                viewLifecycleOwner.lifecycleScope.launch {
                    val addedToCart = nikeDataStore.toggleCart(product.id)
                    val message = if (addedToCart) {
                        "${product.title} 장바구니에 담김"
                    } else {
                        "${product.title} 장바구니에서 제거됨"
                    }
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
                }
            }
        )

        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            nikeDataStore.getShopProducts().collect { list ->
                adapter.updateList(list)
            }
        }
    }
}
