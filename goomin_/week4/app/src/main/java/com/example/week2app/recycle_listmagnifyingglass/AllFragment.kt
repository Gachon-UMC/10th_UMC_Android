package com.example.week2app.recycle_listmagnifyingglass

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week2app.R
import com.example.week2app.adapters.ListProductAdapter
import com.example.week2app.databinding.FragmentListAllBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class AllFragment : Fragment() {

    private var _binding: FragmentListAllBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: ListProductAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListAllBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productItems = listOf(
            ProductItem(0,R.drawable.ic_socks1, "Nike Everyday Plus Cushioned", "Training Ankle Socks (6 Pairs)", "5 color", "US\$10", false),
            ProductItem(1,R.drawable.ic_socks2, "Nike Elite Crew", "Basketball Socks", "7 Colours", "US\$16", false),
            ProductItem(2,R.drawable.ic_air_jordan, "Nike Air Force 1 '07", "Women's Shoes", "5 Colours", "US\$115", false),
            ProductItem(3,R.drawable.ic_air_force, "Jordan ENike Air Force 1 '07ssentials", "Men's Shoes", "2 Colours", "US\$115", false),
            ProductItem(4,R.drawable.ic_air_jordan, "Nike Air Force 1 '07", "Women's Shoes", "5 Colours", "US\$115", false),
            ProductItem(5,R.drawable.ic_air_force, "Jordan ENike Air Force 1 '07ssentials", "Men's Shoes", "2 Colours", "US\$115", false)
        )

//        binding.tabAll.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.listRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        lifecycleScope.launch {

            var savedItems = getProductItemsFromDataStore(requireContext()).first()

            if (savedItems.isEmpty()) {
                saveProductItemsToDataStore(requireContext(), productItems)
                savedItems = productItems
            }

            adapter = ListProductAdapter(
                savedItems.toMutableList()
            ) { item ->

                lifecycleScope.launch {

                    val allItems =
                        getProductItemsFromDataStore(requireContext()).first().toMutableList()

                    allItems.find { it.id == item.id }?.isWish = item.isWish

                    saveProductItemsToDataStore(requireContext(), allItems)
                }
            }

            binding.listRecyclerView.adapter = adapter

            getProductItemsFromDataStore(requireContext()).collect { items ->
                adapter.updateItems(items)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

annotation class ListFragment