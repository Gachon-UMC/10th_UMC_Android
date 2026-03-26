package com.example.mingooapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mingooapp.databinding.ActivityMainBinding
import android.graphics.Color
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //위에서 정의한 버튼을 클릭했을 때의 행동 정의
        binding.imageView1.setOnClickListener {
            binding.textView4.setTextColor(Color.YELLOW)
        }

        binding.imageView2.setOnClickListener {
            binding.textView5.setTextColor(Color.CYAN)
        }

        binding.imageView3.setOnClickListener {
            binding.textView6.setTextColor(Color.parseColor("#800080"))
        }

        binding.imageView4.setOnClickListener {
            binding.textView7.setTextColor(Color.GREEN)
        }

        binding.imageView5.setOnClickListener {
            binding.textView8.setTextColor(Color.RED)
        }


    }
}