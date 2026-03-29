package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. XML에 만들어둔 위젯(이미지, 텍스트)들을 코틀린으로 불러오기
        val img1 = findViewById<ImageView>(R.id.iv_stamp_1)
        val text1 = findViewById<TextView>(R.id.tv_emotion_1)

        val img2 = findViewById<ImageView>(R.id.iv_stamp_2)
        val text2 = findViewById<TextView>(R.id.tv_emotion_2)

        val img3 = findViewById<ImageView>(R.id.iv_stamp_3)
        val text3 = findViewById<TextView>(R.id.tv_emotion_3)

        val img4 = findViewById<ImageView>(R.id.iv_stamp_4)
        val text4 = findViewById<TextView>(R.id.tv_emotion_4)

        val img5 = findViewById<ImageView>(R.id.iv_stamp_5)
        val text5 = findViewById<TextView>(R.id.tv_emotion_5)

        img1.setOnClickListener {
            text1.setTextColor(Color.parseColor("#FFB300"))
        }

        img2.setOnClickListener {
            text2.setTextColor(Color.parseColor("#42A5F5"))
        }

        img3.setOnClickListener {
            text3.setTextColor(Color.parseColor("#AB47BC"))
        }

        img4.setOnClickListener {
            text4.setTextColor(Color.parseColor("#66BB6A"))
        }

        img5.setOnClickListener {
            text5.setTextColor(Color.parseColor("#EF5350"))
        }
    }
}