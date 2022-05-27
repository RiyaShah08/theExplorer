package com.example.travelguideapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.gms.maps.GoogleMap

class discover_des1 : AppCompatActivity() {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_des1)

        val card1 = findViewById(R.id.bs4) as CardView
        card1.setOnClickListener {
            val intent = Intent(this, googlemap::class.java)
            startActivity(intent)
        }

        val image_dis = findViewById(R.id.bs4) as CardView
        image_dis.setOnClickListener {
//            val gmmIntentUri = Uri.parse("geo:40.4319,116.5704?q=" + Uri.encode("nothing"))
//            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
//            mapIntent.setPackage("com.google.android.gms.maps.SupportMapFragment")
//            startActivity(mapIntent)

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("geo:40.4319,116.5704"),
            )
            startActivity(intent)
        }


        val backbut = findViewById(R.id.back4) as ImageView
        backbut.setOnClickListener {
            val intent = Intent(this, discover_beauty::class.java)
            startActivity(intent)
        }

        var bookmark = findViewById(R.id.bookmark_dc) as CheckBox
        bookmark.setOnCheckedChangeListener { checkBox, isChecked ->

            if (isChecked) {
                showToast("Item added to wishlist");
            } else {
                showToast("Item removed from wishlist");
            }
        }
    }

    private fun showToast(s: String) {

    }
}