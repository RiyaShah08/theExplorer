package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class bluespot_desc1 : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluespot_desc1)

        val card1 = findViewById(R.id.card1) as CardView
        card1.setOnClickListener {

            // Get the SupportMapFragment and request notification when the map is ready to be used.
            val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
            mapFragment?.getMapAsync(this)
        }
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val location = LatLng(23.7024, 72.5426)
        googleMap.addMarker(MarkerOptions().position(location).title("My Location"))

    }
}