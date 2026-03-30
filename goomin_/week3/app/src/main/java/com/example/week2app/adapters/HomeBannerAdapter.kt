package com.example.week2app.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.week2app.recycle_home_new.BannerItem
import com.example.week2app.databinding.ItemNewProductBinding
import com.example.week2app.R



class HomeBannerAdapter(
    private val items: List<BannerItem>
) : RecyclerView.Adapter<HomeBannerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemNewProductBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        Log.d("HomeBannerAdapter", "position=$position, name=${item.name}, imageRes=${item.imageRes}")


        holder.binding.productImage.setImageResource(item.imageRes)
        holder.binding.productName.text = item.name
        holder.binding.productCost.text = item.cost

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

    }

    override fun getItemCount(): Int = items.size
}