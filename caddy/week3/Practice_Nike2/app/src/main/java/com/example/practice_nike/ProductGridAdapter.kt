package com.example.practice_nike

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductGridAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductGridAdapter.ProductViewHolder>() {

    // 1. 아이템 디자인(XML)을 가져와서 뷰로 만듭니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_grid, parent, false)
        return ProductViewHolder(view)
    }

    // 2. 뷰에 실제 데이터(이름, 가격 등)를 연결합니다.
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.name.text = product.name
        holder.desc.text = product.description
        holder.price.text = product.price
        holder.image.setImageResource(product.imageResId) // 임시 이미지 세팅
    }

    // 3. 전체 데이터의 개수를 알려줍니다.
    override fun getItemCount(): Int {
        return productList.size
    }

    // 뷰 안의 요소들(TextView, ImageView 등)을 찾아두는 클래스
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.item_image)
        val name: TextView = itemView.findViewById(R.id.item_name)
        val desc: TextView = itemView.findViewById(R.id.item_desc)
        val price: TextView = itemView.findViewById(R.id.item_price)
    }
}