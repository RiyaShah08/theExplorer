package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView

class bluespot_desc3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluespot_desc3)

        var bookmark = findViewById(R.id.bookmark3) as CheckBox
        bookmark.setOnCheckedChangeListener{ checkBox, isChecked->

            if(isChecked){
                showToast("Item added to wishlist");
            }
            else{
                showToast("Item removed from wishlist");
            }
        }

        val txt4 = findViewById(R.id.back4) as ImageView
        txt4.setOnClickListener {
            val intent = Intent(this, bluespot_main::class.java)
            startActivity(intent)
        }

        val blue1 = findViewById(R.id.bs4) as CardView
        blue1.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}