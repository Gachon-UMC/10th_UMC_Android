package com.example.umcweek01

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.umcweek01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.happyStamp.setOnClickListener {
            resetTextColors()
            binding.happyText.setTextColor(Color.parseColor("#F4B400"))
        }

        binding.excitedStamp.setOnClickListener {
            resetTextColors()
            binding.excitedText.setTextColor(Color.parseColor("#4285F4"))
        }

        binding.normalStamp.setOnClickListener {
            resetTextColors()
            binding.normalText.setTextColor(Color.parseColor("#7E57C2"))
        }

        binding.anxiousStamp.setOnClickListener {
            resetTextColors()
            binding.anxiousText.setTextColor(Color.parseColor("#34A853"))
        }

        binding.angryStamp.setOnClickListener {
            resetTextColors()
            binding.angryText.setTextColor(Color.parseColor("#EA4335"))
        }
    }

    private fun resetTextColors() {
        binding.happyText.setTextColor(Color.BLACK)
        binding.excitedText.setTextColor(Color.BLACK)
        binding.normalText.setTextColor(Color.BLACK)
        binding.anxiousText.setTextColor(Color.BLACK)
        binding.angryText.setTextColor(Color.BLACK)
    }
}