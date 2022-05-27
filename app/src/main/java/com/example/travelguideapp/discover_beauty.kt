package com.example.travelguideapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_discover_beauty.*

class discover_beauty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_beauty)

        val demo = findViewById(R.id.db1) as ImageView
        demo.setOnClickListener {
            val intent = Intent(this, discover_des1::class.java)
            startActivity(intent)
        }

        card.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:21.8380, 73.7191"),
            )
            startActivity(intent)
        }

        imageView17.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:20° 54′ 48.38, 72° 49′ 9.25"),
            )
            startActivity(intent)
        }

        imageView18.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:26.9239, 75.8267"),
            )
            startActivity(intent)
        }

        val back_dc = findViewById(R.id.back_dc) as ImageView
        back_dc.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}