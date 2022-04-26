package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class bluespot_desc2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluespot_desc2)

        val txt3 = findViewById(R.id.back3) as ImageView
        txt3.setOnClickListener {
            val intent = Intent(this, bluespot_main::class.java)
            startActivity(intent)
        }

        val blue1 = findViewById(R.id.bs3) as TextView
        blue1.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }
    }
}