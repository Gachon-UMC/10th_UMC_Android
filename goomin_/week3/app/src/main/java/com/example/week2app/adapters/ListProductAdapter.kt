package com.example.week2app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.week2app.recycle_listmagnifyingglass.ProductItem
import com.example.week2app.databinding.ItemListProductBinding
import com.example.week2app.R


class ListProductAdapter(
    private val items: List<ProductItem>
) : RecyclerView.Adapter<ListProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemListProductBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.binding.productImage.setImageResource(item.imageRes)
        holder.binding.productName.text = item.name
        holder.binding.productDes.text = item.desc
        holder.binding.productcolorcount.text = item.colorcount
        holder.binding.productCost.text = item.price

        // 클릭 이벤트 추가
        holder.binding.root.setOnClickListener { view ->
            // 이동할 Fragment 생성
            val fragment = com.example.week2app.product_detail.ProductDetailFragment()

            // FragmentManager 가져오기
            val activity = view.context as androidx.fragment.app.FragmentActivity

            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragmentContainer, fragment)  // main_fragmentContainer 사용
                .addToBackStack(null)                            // 뒤로가기 가능
                .commit()
        }

        // ❤️ 위시 하트 상태
        if (item.isWish) {
            holder.binding.wishHeart.setImageResource(R.drawable.ic_heart_on)
        } else {
            holder.binding.wishHeart.setImageResource(R.drawable.ic_heart_off)
        }

        // ❤️ 클릭 토글
        holder.binding.wishHeart.setOnClickListener {
            item.isWish = !item.isWish
            notifyItemChanged(position)
        }
    }
}