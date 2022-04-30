package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val card = findViewById(R.id.card) as ImageView
        card.setOnClickListener {
            val intent = Intent(this, discover_beauty::class.java)
            startActivity(intent)
        }

        val card1 = findViewById(R.id.image2) as ImageView
        card1.setOnClickListener {
            val intent = Intent(this, discover_beauty::class.java)
            startActivity(intent)
        }

        val view = findViewById(R.id.nav_menu) as ImageView
        view.setOnClickListener {
            val intent = Intent(this, navigation::class.java)
            startActivity(intent)
        }

        val nearby = findViewById(R.id.imageView20) as ImageView
        nearby.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }

        val bluespot = findViewById(R.id.image1) as ImageView
        bluespot.setOnClickListener {
            val intent = Intent(this, bluespot_main::class.java)
            startActivity(intent)
        }
    }
}