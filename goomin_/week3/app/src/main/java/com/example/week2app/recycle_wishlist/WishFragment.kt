package com.example.week2app.recycle_wishlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week2app.databinding.FragmentWishlistBinding
import com.example.week2app.R


class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: WishlistAdapter
    private val wishlistItems = mutableListOf<WishData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. RecyclerView 세팅
        adapter = WishlistAdapter(wishlistItems)
        binding.wishlistRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.wishlistRecyclerView.adapter = adapter

        // 2. 더미 데이터 추가
        wishlistItems.addAll(
            listOf(
                WishData(
                    productImage = R.drawable.ic_air_jordan,
                    productName = "Air Jordan XXXVI",
                    productCost = "US$185"
                ),
                WishData(
                    productImage = R.drawable.ic_socks1,
                    productName = "Nike Everyday Plus Cushioned",
                    productDesc = "Training Ankle Socks (6 Pairs)",
                    productColorCount = "5 color",
                    productCost = "US$10"
                )
            )
        )
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}