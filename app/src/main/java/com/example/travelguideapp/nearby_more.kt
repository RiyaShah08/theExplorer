package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.LinearLayout

class nearby_more : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nearby_more)


        val demo1 = findViewById(R.id.demo1) as LinearLayout
        demo1.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }
    }
}