package com.example.week2app.recycle_wishlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week2app.adapters.ListProductAdapter
import com.example.week2app.databinding.FragmentWishlistBinding
import com.example.week2app.recycle_listmagnifyingglass.ProductItem
import com.example.week2app.recycle_listmagnifyingglass.getProductItemsFromDataStore
import com.example.week2app.recycle_listmagnifyingglass.saveProductItemsToDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ListProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // RecyclerView 초기 세팅
        binding.wishlistRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        lifecycleScope.launch {
            val allItems: List<ProductItem> = getProductItemsFromDataStore(requireContext()).first()

            //리스트 위시 아이템 복사본으로 받아옴
            val wishItems = allItems
                .filter { it.isWish }
                .toMutableList()

            adapter = ListProductAdapter(wishItems) { item ->

                lifecycleScope.launch {

                    val allItems =
                        getProductItemsFromDataStore(requireContext()).first().toMutableList()

                    allItems.find { it.id == item.id }?.isWish = item.isWish

                    saveProductItemsToDataStore(requireContext(), allItems)
                }
            }

            binding.wishlistRecyclerView.adapter = adapter

            // DataStore 변경 감지
            getProductItemsFromDataStore(requireContext()).collect { items ->

                val filtered = items
                    .filter { it.isWish }

                adapter.updateItems(filtered)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}