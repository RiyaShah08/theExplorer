package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.LinearLayout

class nearby_more : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nearby_more)

        val back_near = findViewById(R.id.near_back) as ImageView
        back_near.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val demo1 = findViewById(R.id.demo1) as LinearLayout
        demo1.setOnClickListener {
            val intent = Intent(this, googlemap::class.java)
            startActivity(intent)
        }
    }
}