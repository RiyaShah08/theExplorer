package com.example.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class map_activity : AppCompatActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        // Get the SupportMapFragment and request notification when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
//        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)

    }
    //
    override fun onMapReady(googleMap: GoogleMap) {
        fun var1(googleMap: GoogleMap) {
            val location = LatLng(23.7024, 72.5426)
            googleMap.addMarker(MarkerOptions().position(location).title("My Location"))
        }

    }
}