package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView

class discover_des1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_des1)

        val card1 = findViewById(R.id.bs4) as CardView
        card1.setOnClickListener {
            val intent = Intent(this, googlemap::class.java)
            startActivity(intent)
        }

        val backbut = findViewById(R.id.back4) as ImageView
        backbut.setOnClickListener {
            val intent = Intent(this, discover_beauty::class.java)
            startActivity(intent)
        }

        var bookmark = findViewById(R.id.bookmark_dc) as CheckBox
        bookmark.setOnCheckedChangeListener{ checkBox, isChecked->

            if(isChecked){
                showToast("Item added to wishlist");
            }
            else{
                showToast("Item removed from wishlist");
            }
        }

    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}