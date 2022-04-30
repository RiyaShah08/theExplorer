package com.example.travelguideapp

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.Debug.getLocation
import android.widget.Toast
import androidx.core.app.ActivityCompat


class Home : AppCompatActivity() {

    val permission = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    val permissioncode = 78

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        askPermission();

//        val isAlertWindowPermissionGranted: Boolean = TedPermissionUtil.isGranted(Manifest.permission.SYSTEM_ALERT_WINDOW)
//        Log.d("ted", "isAlertWindowPermissionGranted: $isAlertWindowPermissionGranted")
//
//        getLocation();

        val card = findViewById(R.id.card) as ImageView
        card.setOnClickListener {
            val intent = Intent(this, discover_beauty::class.java)
            startActivity(intent)
        }

        val card1 = findViewById(R.id.image2) as ImageView
        card1.setOnClickListener {
            val intent = Intent(this, discover_beauty::class.java)
            startActivity(intent)
        }

        val view = findViewById(R.id.nav_menu) as ImageView
        view.setOnClickListener {
            val intent = Intent(this, navigation::class.java)
            startActivity(intent)
        }

        val nearby = findViewById(R.id.imageView20) as ImageView
        nearby.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }

        val bluespot = findViewById(R.id.image1) as ImageView
        bluespot.setOnClickListener {
            val intent = Intent(this, bluespot_main::class.java)
            startActivity(intent)
        }
    }

    private fun askPermission() {
        ActivityCompat.requestPermissions(this, permission, permissioncode)
    }

//    private fun getLocation()
//    {
//        val permissionlistener: PermissionListener = object : PermissionListener() {
//            fun onPermissionGranted() {
//                Toast.makeText(this@Home, "Permission Granted", Toast.LENGTH_SHORT).show()
//            }
//
//            fun onPermissionDenied(deniedPermissions: List<String?>) {
//                Toast.makeText(this@Home, "Permission Denied\n$deniedPermissions", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}
