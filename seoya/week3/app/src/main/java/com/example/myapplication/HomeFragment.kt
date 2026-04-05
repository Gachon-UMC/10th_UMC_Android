package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeRecyclerView = view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.home_recyclerview)

        val homeDataList = mutableListOf(
            HomeData(R.drawable.ic_shoe1, "Air Jordan XXXVI", "US$185"),
            HomeData(R.drawable.ic_shoe2, "Nike Air Force 1'07", "US$115"),
        )

        val adapter = HomeDataAdapter(
            homeDataList,
            onVisitClicked = { home ->
                Toast.makeText(requireContext(), "${home.name} 클릭됨", Toast.LENGTH_SHORT).show()
            }
        )

        homeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        homeRecyclerView.adapter = adapter
    }
}