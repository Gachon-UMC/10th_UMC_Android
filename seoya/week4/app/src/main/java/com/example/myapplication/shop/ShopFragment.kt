package com.example.myapplication.shop

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentShopBinding

class ShopFragment : Fragment(R.layout.fragment_shop) {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    private enum class ShopTab {
        ALL,
        TOPS,
        SALE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentShopBinding.bind(view)

        binding.tvAll.setOnClickListener { selectTab(ShopTab.ALL) }
        binding.tvTops.setOnClickListener { selectTab(ShopTab.TOPS) }
        binding.tvSale.setOnClickListener { selectTab(ShopTab.SALE) }

        if (savedInstanceState == null) {
            selectTab(ShopTab.ALL)
        } else {
            binding.root.post {
                updateIndicator(selectedTextView())
            }
        }
    }

    private fun selectTab(tab: ShopTab) {
        updateTabStyles(tab)
        showTabFragment(tab)
        binding.root.post {
            updateIndicator(selectedTextView(tab))
        }
    }

    private fun updateTabStyles(tab: ShopTab) {
        val selectedColor = Color.BLACK
        val unselectedColor = Color.parseColor("#888888")

        binding.tvAll.setTextColor(if (tab == ShopTab.ALL) selectedColor else unselectedColor)
        binding.tvTops.setTextColor(if (tab == ShopTab.TOPS) selectedColor else unselectedColor)
        binding.tvSale.setTextColor(if (tab == ShopTab.SALE) selectedColor else unselectedColor)

        binding.tvAll.setTypeface(null, if (tab == ShopTab.ALL) android.graphics.Typeface.BOLD else android.graphics.Typeface.NORMAL)
        binding.tvTops.setTypeface(null, if (tab == ShopTab.TOPS) android.graphics.Typeface.BOLD else android.graphics.Typeface.NORMAL)
        binding.tvSale.setTypeface(null, if (tab == ShopTab.SALE) android.graphics.Typeface.BOLD else android.graphics.Typeface.NORMAL)
    }

    private fun showTabFragment(tab: ShopTab) {
        val fragment = when (tab) {
            ShopTab.ALL -> ShopAllFragment()
            ShopTab.TOPS -> ShopTopsFragment()
            ShopTab.SALE -> ShopSaleFragment()
        }

        childFragmentManager.beginTransaction()
            .replace(R.id.shop_tab_container, fragment)
            .commit()
    }

    private fun updateIndicator(target: TextView) {
        val indicator = binding.viewIndicator
        val newWidth = target.width
        indicator.layoutParams = indicator.layoutParams.apply {
            width = newWidth
        }
        indicator.requestLayout()
        indicator.animate()
            .x(binding.layoutTabContainer.x + target.x)
            .setDuration(180)
            .start()
    }

    private fun selectedTextView(): TextView {
        return when {
            binding.tvTops.currentTextColor == Color.BLACK -> binding.tvTops
            binding.tvSale.currentTextColor == Color.BLACK -> binding.tvSale
            else -> binding.tvAll
        }
    }

    private fun selectedTextView(tab: ShopTab): TextView {
        return when (tab) {
            ShopTab.ALL -> binding.tvAll
            ShopTab.TOPS -> binding.tvTops
            ShopTab.SALE -> binding.tvSale
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
