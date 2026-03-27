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

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //위에서 정의한 버튼을 클릭했을 때의 행동 정의
        binding.icHappy.setOnClickListener {
            blackColors()
            binding.happyView.setTextColor(Color.YELLOW)
        }

        binding.icExcied.setOnClickListener {
            blackColors()
            binding.excidView.setTextColor(Color.CYAN)
        }

        binding.icSoso.setOnClickListener {
            blackColors()
            binding.sosoView.setTextColor(Color.parseColor("#800080"))
        }

        binding.icAnxiety.setOnClickListener {
            blackColors()
            binding.anxietyView.setTextColor(Color.GREEN)

        }

        binding.icAngry.setOnClickListener {
            blackColors()
            binding.angryView.setTextColor(Color.RED)
        }


    }
    private fun blackColors() {
        binding.happyView.setTextColor(Color.BLACK)
        binding.excidView.setTextColor(Color.BLACK)
        binding.sosoView.setTextColor(Color.BLACK)
        binding.anxietyView.setTextColor(Color.BLACK)
        binding.angryView.setTextColor(Color.BLACK)
    }

}