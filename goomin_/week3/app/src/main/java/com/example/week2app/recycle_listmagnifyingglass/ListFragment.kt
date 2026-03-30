package com.example.week2app.recycle_listmagnifyingglass

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.week2app.R
import com.example.week2app.adapters.ListProductAdapter
import com.example.week2app.databinding.FragmentListmagnifyingglassBinding


class ListFragment : Fragment() {

    private var _binding: FragmentListmagnifyingglassBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListmagnifyingglassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val productItems = listOf(
            ProductItem(
                R.drawable.ic_socks1,
                "Nike Everyday Plus Cushioned",
                "Training Ankle Socks (6 Pairs)",
                "5 color",
                "US\$10",
                true
            ),
            ProductItem(
                R.drawable.ic_socks2,
                "Nike Elite Crew",
                "Basketball Socks",
                "7 Colours",
                "US\$16",
                false
            ),
            ProductItem(
                R.drawable.ic_air_jordan,
                "Nike Air Force 1 '07",
                "Women's Shoes",
                "5 Colours",
                "US\$115",
                false
            ),
            ProductItem(
                R.drawable.ic_air_force,
                "Jordan ENike Air Force 1 '07ssentials",
                "Men's Shoes",
                "2 Colours",
                "US\$115",
                false
            ),
            ProductItem(
                R.drawable.ic_air_jordan,
                "Nike Air Force 1 '07",
                "Women's Shoes",
                "5 Colours",
                "US\$115",
                false
            ),
            ProductItem(
                R.drawable.ic_air_force,
                "Jordan ENike Air Force 1 '07ssentials",
                "Men's Shoes",
                "2 Colours",
                "US\$115",
                false
            )
            )

        Log.d("LIST_TEST", "product size = ${productItems.size}")

        val adapter = ListProductAdapter(productItems)

        binding.listRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }

        Log.d("LIST_TEST", "adapter 연결 완료")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}