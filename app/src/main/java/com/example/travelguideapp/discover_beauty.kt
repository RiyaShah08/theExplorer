package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.TextView

class discover_beauty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_beauty)


        val demo = findViewById(R.id.demo) as TextView
        demo.setOnClickListener {
            val intent = Intent(this, discover_des1::class.java)
            startActivity(intent)
        }
    }
}