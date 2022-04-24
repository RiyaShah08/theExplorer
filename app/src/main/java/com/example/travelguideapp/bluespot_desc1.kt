package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView

class bluespot_desc1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluespot_desc1)

        val card2 = findViewById(R.id.card2) as CardView
        card2.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }
    }
}