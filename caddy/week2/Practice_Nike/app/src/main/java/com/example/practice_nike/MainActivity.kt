package com.example.practice_nike

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // activity_main.xml (FrameLayout과 BottomNavigationView가 있는 레이아웃) 연결
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottom_nav)

        // 앱이 처음 켜졌을 때 기본으로 보여줄 화면(홈) 설정
        replaceFragment(HomeFragment())

        // 하단 탭 클릭 이벤트 처리
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_purchase -> replaceFragment(PurchaseFragment())
                R.id.nav_wishlist -> replaceFragment(WishlistFragment())
                R.id.nav_cart -> replaceFragment(CartFragment())
                R.id.nav_profile -> replaceFragment(ProfileFragment())
            }
            true
        }
    }

    // 선택된 프래그먼트로 화면을 교체하는 함수
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .commit()
    }

    // 장바구니 프래그먼트에서 '주문하기' 버튼을 눌렀을 때 호출될 함수
    fun navigateToPurchaseTab() {
        bottomNav.selectedItemId = R.id.nav_purchase
    }
}