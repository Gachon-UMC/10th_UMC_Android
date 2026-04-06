package com.example.week2app.recycle_wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week2app.R
import com.example.week2app.product_detail.ProductDetailFragment
import androidx.fragment.app.FragmentActivity

class WishlistAdapter(private val items: List<WishData>) :
    RecyclerView.Adapter<WishlistAdapter.WishViewHolder>() {

    class WishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productCost: TextView = itemView.findViewById(R.id.productCost)
        val productDesc: TextView? = itemView.findViewById(R.id.productDes)
        val productColorCount: TextView? = itemView.findViewById(R.id.productcolorcount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_wishlist, parent, false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val item = items[position]
        holder.productImage.setImageResource(item.productImage)
        holder.productName.text = item.productName
        holder.productCost.text = item.productCost
        holder.productDesc?.text = item.productDesc ?: ""
        holder.productColorCount?.text = item.productColorCount ?: ""

        // 클릭 이벤트 추가 (아이템 전체)
        holder.itemView.setOnClickListener { view ->
            val fragment = ProductDetailFragment()

            // context를 FragmentActivity로 캐스팅
            val activity = view.context as FragmentActivity
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = items.size
}