package com.example.week2app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.week2app.databinding.ActivityMainBinding
import com.example.week2app.home_main.BagsimpleFragment
import com.example.week2app.home_main.ListmagnifyingglassFragment
import com.example.week2app.recycle_wishlist.WishlistFragment
import com.example.week2app.recycle_home_new.HomeFragment
import com.example.week2app.home_main.UserFragment

class MainActivity : AppCompatActivity() {

//    BagsimpleFragment.kt에서 사용할 수 있게 수정함, private -> lateinit
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 초기 Fragment, HomeFragment로 설정함
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragmentContainer, HomeFragment())
            .commit()

        // BottomNavigationView 클릭 시 Fragment 교체
        binding.mainBnv.setOnItemSelectedListener { item ->
            val fragment = when (item.itemId) {
                R.id.homeFragment -> HomeFragment()
                R.id.listmagnifyingglassFragment -> ListmagnifyingglassFragment()
                R.id.whshlistFragment  -> WishlistFragment()
                R.id.bagsimpleFragment -> BagsimpleFragment()
                R.id.userFragment -> UserFragment()
                else -> null
            }

            fragment?.let {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragmentContainer, it)
                    .commit()
            }
            true
        }
    }
}
