package com.example.week2app.home_main

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.week2app.R
import com.example.week2app.databinding.FragmentListmagnifyingglassBinding
import com.example.week2app.recycle_listmagnifyingglass.AllFragment
import com.example.week2app.recycle_listmagnifyingglass.SaleFragment
import com.example.week2app.recycle_listmagnifyingglass.TopsFragment

class ListmagnifyingglassFragment :
    Fragment(R.layout.fragment_listmagnifyingglass) {

    private var _binding: FragmentListmagnifyingglassBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentListmagnifyingglassBinding.bind(view)

        binding.tabAll.setOnClickListener {
            selectTab(binding.tabAll)
            replaceFragment(AllFragment())
        }

        binding.tabTops.setOnClickListener {
            selectTab(binding.tabTops)
            replaceFragment(TopsFragment())
        }

        binding.tabSale.setOnClickListener {
            selectTab(binding.tabSale)
            replaceFragment(SaleFragment())
        }

        binding.tabAll.post {
            selectTab(binding.tabAll)
        }

        replaceFragment(AllFragment())
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager.beginTransaction()
            .replace(R.id.listFragmentContainer, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun selectTab(tab: TextView) {

        binding.tabAll.setTextColor(Color.GRAY)
        binding.tabTops.setTextColor(Color.GRAY)
        binding.tabSale.setTextColor(Color.GRAY)

        tab.setTextColor(Color.BLACK)

        binding.tabIndicator.animate()
            .x(tab.x)
            .setDuration(150)

        // width를 선택된 탭 크기로 변경
        val params = binding.tabIndicator.layoutParams
        params.width = tab.width
        binding.tabIndicator.layoutParams = params
    }
}