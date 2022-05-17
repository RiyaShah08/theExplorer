package com.example.travelguideapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.MenuItem
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.Debug.getLocation
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.travelguideapp.profile
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_profile.*


class Home : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val drawerlayout = findViewById<DrawerLayout>(R.id.drawerlayout)
        toggle = ActionBarDrawerToggle(this,drawerlayout,R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(Html.fromHtml("<font color=\"green\">"+ getString(R.string.app_name) + "</font>"))

        val navView = findViewById<NavigationView>(R.id.navView)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {val intent = Intent(this, Home::class.java)
                    startActivity(intent)}
                R.id.profile -> {val intent = Intent(this, com.example.travelguideapp.profile::class.java)
                    startActivity(intent)}
                R.id.location -> {val intent = Intent(this, map_activity::class.java)
                    startActivity(intent)}
                R.id.Bluespot -> {val intent = Intent(this, recycle_blue::class.java)
                    startActivity(intent)}
                R.id.addpost -> {
                    val openURL = Intent(android.content.Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSeM6xeTLM95yyz_BZ0zb8rfMAjgPsJFJojC2WTEX2jqnc14OQ/viewform?usp=sf_link")
                    startActivity(openURL)}
//                R.id.Feedback -> {val intent = Intent(this, ::class.java)
//                    startActivity(intent)}
                R.id.contact -> {val intent = Intent(this, contact_us::class.java)
                    startActivity(intent)}
                R.id.aboutus -> {val intent = Intent(this, about_us::class.java)
                    startActivity(intent)}
                R.id.Logout -> {val intent = Intent(this, login::class.java)
                    startActivity(intent)}
            }
            true
        }

        val SEARCH = findViewById(R.id.location) as CardView
        SEARCH.setOnClickListener {
            val intent = Intent(this, map_activity::class.java)
            startActivity(intent)
        }

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

//        val view = findViewById(R.id.nav_menu) as ImageView
//        view.setOnClickListener {
//            val intent = Intent(this, navigation::class.java)
//            startActivity(intent)
//        }

        val nearby = findViewById(R.id.imageView20) as ImageView
        nearby.setOnClickListener {
            val intent = Intent(this, nearby_more::class.java)
            startActivity(intent)
        }

        val bluespot = findViewById(R.id.image1) as ImageView
        bluespot.setOnClickListener {
            val intent = Intent(this, recycle_blue::class.java)
            startActivity(intent)
        }
        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_bar)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)


//        title = "KotlinApp"
//        if (ContextCompat.checkSelfPermission(
//                this@Home,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) !== PackageManager.PERMISSION_GRANTED
//        ) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(
//                    this@Home, Manifest.permission.ACCESS_FINE_LOCATION
//                )
//            ) {
//                ActivityCompat.requestPermissions(
//                    this@Home,
//                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
//                )
//            } else {
//                ActivityCompat.requestPermissions(
//                    this@Home,
//                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
//                )
//            }
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int, permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            1 -> {
//                if (grantResults.isNotEmpty() && grantResults[0] ==
//                    PackageManager.PERMISSION_GRANTED
//                ) {
//                    if ((ContextCompat.checkSelfPermission(
//                            this@Home, Manifest.permission.ACCESS_FINE_LOCATION
//                        ) === PackageManager.PERMISSION_GRANTED)
//                    ) {
//                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
//                    }
//                } else {
//                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
//                }
//                return
//            }
//        }
    }
    val OnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.main_nav -> {
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
            R.id.loc -> {
                val intent = Intent(this, map_activity::class.java)
                startActivity(intent)
            }
            R.id.post_nav -> {
                val intent = Intent(this, discover_beauty::class.java)
                startActivity(intent)
            }
            R.id.user_profile -> {
                val intent = Intent(this, com.example.travelguideapp.profile::class.java)
                startActivity(intent)
            }
        }
        return@OnNavigationItemSelectedListener true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
