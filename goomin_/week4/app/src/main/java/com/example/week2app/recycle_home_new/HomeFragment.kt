package com.example.week2app.recycle_home_new

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.week2app.R
import com.example.week2app.adapters.HomeBannerAdapter
import com.example.week2app.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    //    private var _test: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bannerItems = listOf(
            BannerItem(0,R.drawable.ic_air_jordan, "Air Jordan XXXVI", "US$185"),
            BannerItem(1,R.drawable.ic_air_force, "Nike Air Force 1 '07", "US$115")
        )

        val bannerAdapter = HomeBannerAdapter(bannerItems)
        binding.homeBannerRecyclerView.apply {
            adapter = bannerAdapter
//            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }

        lifecycleScope.launch {
            val savedItems = getBannerItemsFromDataStore(requireContext()).first()

            if (savedItems.isEmpty()) {
                saveBannerItemsToDataStore(requireContext(), bannerItems)
            }

            getBannerItemsFromDataStore(requireContext()).collect { items ->
//                Log.d("HomeFragment", "DataStore items = $items") // 데이터 확인용 로그
                binding.homeBannerRecyclerView.adapter = HomeBannerAdapter(items)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}