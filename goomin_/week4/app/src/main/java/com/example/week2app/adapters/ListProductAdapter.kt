package com.example.week2app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week2app.recycle_listmagnifyingglass.ProductItem
import com.example.week2app.databinding.ItemListProductBinding
import com.example.week2app.R

class ListProductAdapter(
    private val items: MutableList<ProductItem>,
    private val saveCallback: (ProductItem) -> Unit
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
        holder.binding.productCost.text = item.cost

        holder.binding.wishHeart.setImageResource(
            if (item.isWish) R.drawable.ic_heart_on else R.drawable.ic_heart_off
        )

        // 클릭 이벤트 추가
        holder.binding.root.setOnClickListener { view ->
            val fragment = com.example.week2app.product_detail.ProductDetailFragment()
            val activity = view.context as androidx.fragment.app.FragmentActivity
            activity.supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        // ❤️ 하트 클릭 토글 + DataStore 저장
        holder.binding.wishHeart.setOnClickListener {
            item.isWish = !item.isWish
            notifyItemChanged(position)
            saveCallback(item)
        }
    }

    // Adapter 외부에서 리스트 갱신
    fun updateItems(newItems: List<ProductItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}