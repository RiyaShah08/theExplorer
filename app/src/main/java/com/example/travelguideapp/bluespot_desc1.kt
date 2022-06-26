package com.example.travelguideapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_bluespot_desc1.*

class bluespot_desc1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluespot_desc1)

        var bookmark = findViewById(R.id.bookmark1) as CheckBox
        bookmark.setOnCheckedChangeListener{ checkBox, isChecked->

            if(isChecked){
                showToast("Item added to wishlist");
            }
            else{
                showToast("Item removed from wishlist");
            }
        }


        val txt2 = findViewById(R.id.back2) as ImageView
        txt2.setOnClickListener {
            val intent = Intent(this, recycle_blue::class.java)
            startActivity(intent)
        }

        bs2.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse( "https://cutt.ly/fKYT2QB")
            startActivity(openURL)
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }
}