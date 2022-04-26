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

        val materialCardView = findViewById(R.id.materialCardView) as MaterialCardView
        materialCardView.setOnClickListener {
            val intent = Intent(this, bluespot_desc::class.java)
            startActivity(intent)
        }

        val materialCardView1 = findViewById(R.id.materialCardView1) as MaterialCardView
        materialCardView1.setOnClickListener {
            val intent = Intent(this, bluespot_desc1::class.java)
            startActivity(intent)
        }

        val materialCardView13 = findViewById(R.id.materialCardView13) as MaterialCardView
        materialCardView13.setOnClickListener {
            val intent = Intent(this, bluespot_desc3::class.java)
            startActivity(intent)
        }

        val materialCardView5 = findViewById(R.id.materialCardView5) as MaterialCardView
        materialCardView5.setOnClickListener {
            val intent = Intent(this, bluespot_desc3::class.java)
            startActivity(intent)
        }

        val back = findViewById(R.id.back) as ImageView
        back.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}