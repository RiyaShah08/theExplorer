package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.google.android.material.card.MaterialCardView

class bluespot_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluespot_main)

        val materialCardView1 = findViewById(R.id.materialCardView1) as MaterialCardView
        materialCardView1.setOnClickListener {
            val intent = Intent(this, bluespot_desc1::class.java)
            startActivity(intent)
        }

        val back = findViewById(R.id.back) as ImageView
        back.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}