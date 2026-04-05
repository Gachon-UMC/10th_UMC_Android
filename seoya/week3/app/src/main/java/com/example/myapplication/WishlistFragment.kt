package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment(R.layout.fragment_wishlist) {

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentWishlistBinding.bind(view)

        val wishlistItems = listOf(
            WishlistData(
                R.drawable.ic_socks1,
                "Air Jordan 1 Mid",
                "",
                "",
                "US$125"
            ),
            WishlistData(
                R.drawable.ic_shoe1,
                "Nike Everyday Plus Cushioned",
                "Training Ankle Socks (6 Pairs)",
                "5 Colours",
                "US$10"
            )
        )

        val adapter = WishlistAdapter(wishlistItems)
        binding.rvWishlist.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvWishlist.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
