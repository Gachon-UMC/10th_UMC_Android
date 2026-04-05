package com.example.myapplication.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.storage.NikeDataStore
import com.example.myapplication.storage.NikeDummyData
import kotlinx.coroutines.launch

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeRecyclerView = view.findViewById<RecyclerView>(R.id.home_recyclerview)

        val adapter = HomeDataAdapter(
            mutableListOf(),
            onVisitClicked = { home ->
                Toast.makeText(requireContext(), "${home.name} 클릭됨", Toast.LENGTH_SHORT).show()
            }
        )

        homeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        homeRecyclerView.adapter = adapter

        val nikeDataStore = NikeDataStore(requireContext())

        viewLifecycleOwner.lifecycleScope.launch {
            nikeDataStore.seedInitialDataIfNeeded(
                NikeDummyData.latestProducts,
                NikeDummyData.shopProducts
            )

            nikeDataStore.getLatestProducts().collect { list ->
                adapter.updateList(list)
            }
        }
    }
}
