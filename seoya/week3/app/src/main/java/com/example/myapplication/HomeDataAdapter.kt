package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemHomeBinding


class HomeDataAdapter(
    private val homeList: MutableList<HomeData>,
    private val onVisitClicked: (HomeData) -> Unit
) : RecyclerView.Adapter<HomeDataAdapter.HomeViewHolder>() {

    inner class HomeViewHolder(val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(home: HomeData) {
            binding.txtName.text = home.name
            binding.txtPrice.text = home.price
            binding.imgProduct.setImageResource(home.imageResId)

            binding.root.setOnClickListener {
                onVisitClicked(home)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(homeList[position])
    }

    override fun getItemCount(): Int = homeList.size
}
