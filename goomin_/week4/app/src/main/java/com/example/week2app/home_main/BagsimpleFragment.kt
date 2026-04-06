package com.example.week2app.home_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.week2app.MainActivity
import com.example.week2app.R
import com.example.week2app.databinding.FragmentBagsimpleBinding

class BagsimpleFragment : Fragment(R.layout.fragment_bagsimple) {

    private var _binding: FragmentBagsimpleBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBagsimpleBinding.bind(view)

        binding.goToListButton.setOnClickListener {
            val activity = requireActivity() as MainActivity
            activity.binding.mainBnv.selectedItemId = R.id.listmagnifyingglassFragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}