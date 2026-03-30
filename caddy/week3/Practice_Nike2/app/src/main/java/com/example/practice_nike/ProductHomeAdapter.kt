package com.example.practice_nike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductHomeAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductHomeAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // 홈 화면 전용 레이아웃 연결!
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_home, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.name
        holder.desc.text = product.description
        holder.price.text = product.price
        holder.image.setImageResource(product.imageResId)
    }

    override fun getItemCount(): Int = productList.size

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val name: TextView = itemView.findViewById(R.id.item_name)
        val desc: TextView = itemView.findViewById(R.id.item_desc)
        val price: TextView = itemView.findViewById(R.id.item_price)
    }
}