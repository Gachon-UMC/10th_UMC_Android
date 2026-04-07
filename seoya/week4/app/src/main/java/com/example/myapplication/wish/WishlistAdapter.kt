package com.example.myapplication.wish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemWishlistBinding

class WishlistAdapter(
    private val wishlistList: MutableList<WishlistData>
) : RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {

    inner class WishlistViewHolder(private val binding: ItemWishlistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WishlistData) {
            binding.ivWishlistProduct.setImageResource(item.imageResId)
            binding.tvWishlistName.text = item.name
            binding.tvWishlistPrice.text = item.price

            if (item.subTitle.isBlank()) {
                binding.tvWishlistSubTitle.visibility = View.GONE
            } else {
                binding.tvWishlistSubTitle.visibility = View.VISIBLE
                binding.tvWishlistSubTitle.text = item.subTitle
            }

            if (item.colorText.isBlank()) {
                binding.tvWishlistColors.visibility = View.GONE
            } else {
                binding.tvWishlistColors.visibility = View.VISIBLE
                binding.tvWishlistColors.text = item.colorText
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val binding = ItemWishlistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return WishlistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        holder.bind(wishlistList[position])
    }

    override fun getItemCount(): Int = wishlistList.size

    fun updateList(newList: List<WishlistData>) {
        wishlistList.clear()
        wishlistList.addAll(newList)
        notifyDataSetChanged()
    }
}
