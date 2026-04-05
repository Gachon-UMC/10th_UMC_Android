package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.FragmentShopBinding

class ShopFragment : Fragment(R.layout.fragment_shop) {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ProductAdapter
    private lateinit var productList: List<ProductData>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShopBinding.bind(view)

        productList = listOf(
            ProductData(R.drawable.ic_socks1, "Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)", "5 Colours", "US$10", false, true, "전체"),
            ProductData(R.drawable.ic_socks2, "Nike Elite Crew", "Basketball Socks", "7 Colours", "US$16", false, false, "전체"),
            ProductData(R.drawable.ic_airporce, "Nike Air Force 1 '07", "Women's Shoes", "5 Colours", "US$115", true, false, "sale"),
            ProductData(R.drawable.ic_airporce2, "Jordan ENike Air Force 1 '07sentials", "Men's Shoes", "2 Colours", "US$115", true, false, "Tops & T-Shirts")
        )

        adapter = ProductAdapter(productList)

        binding.rvProduct.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProduct.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
