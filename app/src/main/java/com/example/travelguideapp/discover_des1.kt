package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView

class discover_des1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_des1)

        val card1 = findViewById(R.id.bs4) as CardView
        card1.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }

    }
}