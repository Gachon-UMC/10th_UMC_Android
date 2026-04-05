package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemProductBinding

class ProductAdapter(
    private var productList: List<ProductData>
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: ProductData) {
            binding.ivProduct.setImageResource(product.imageResId)
            binding.tvTitle.text = product.title
            binding.tvSubTitle.text = product.subTitle
            binding.tvColors.text = product.colorText
            binding.tvPrice.text = product.price

            binding.tvBestSeller.visibility =
                if (product.isBestSeller) View.VISIBLE else View.GONE

            if (product.isLiked) {
                binding.ivLike.setImageResource(R.drawable.ic_heart_full)
            } else {
                binding.ivLike.setImageResource(R.drawable.ic_heart_outline)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    fun updateList(newList: List<ProductData>) {
        productList = newList
        notifyDataSetChanged()
    }
}