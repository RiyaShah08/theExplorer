package com.example.travelguideapp

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_profile.*
import android.graphics.drawable.ColorDrawable
import android.widget.*
import androidx.cardview.widget.CardView

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
        supportActionBar?.setTitle(Html.fromHtml("<font color=\"white\">"+ getString(R.string.app_name) + "</font>"))

        val colorDrawable = ColorDrawable(Color.parseColor("#23545C"))
        supportActionBar?.setBackgroundDrawable(colorDrawable)

        val navView = findViewById<NavigationView>(R.id.navView)
        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> {val intent = Intent(this, Home::class.java)
                    startActivity(intent)}
                R.id.profile -> {val intent = Intent(this, com.example.travelguideapp.profile::class.java)
                    startActivity(intent)}
                R.id.location -> {val intent = Intent(this, googlemap::class.java)
                    startActivity(intent)}
                R.id.Bluespot -> {val intent = Intent(this, recycle_blue::class.java)
                    startActivity(intent)}
                R.id.addpost -> {
                    val openURL = Intent(android.content.Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://forms.gle/B82n5Ka73HEdVSBB7")
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

        fab.setOnClickListener{
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://forms.gle/B82n5Ka73HEdVSBB7")
            startActivity(openURL)
        }

        val SEARCH = findViewById(R.id.location) as CardView
        SEARCH.setOnClickListener {
            val intent = Intent(this, googlemap::class.java)
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

        val ap1 = findViewById(R.id.add1) as ImageView
        ap1.setOnClickListener {
            val intent = Intent(this, webview::class.java)
            startActivity(intent)
        }

        val ap2 = findViewById(R.id.add2) as ImageView
        ap2.setOnClickListener {
            val intent = Intent(this, webview1::class.java)
            startActivity(intent)
        }

        val ap3 = findViewById(R.id.add3) as ImageView
        ap3.setOnClickListener {
            val intent = Intent(this, webview2::class.java)
            startActivity(intent)
        }

        val ap4 = findViewById(R.id.add4) as ImageView
        ap4.setOnClickListener {
            val intent = Intent(this, webview3::class.java)
            startActivity(intent)
        }

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnNavigationItemSelectedListener(OnNavigationItemSelectedListener)

//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
//        bottomNavigationView.background = null
//        bottomNavigationView.menu.getItem(2).isEnabled = false

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
            R.id.post_nav -> {
                val intent = Intent(this, discover_beauty::class.java)
                startActivity(intent)
            }
            R.id.placeholder -> {
//                val openURL = Intent(android.content.Intent.ACTION_VIEW)
//                openURL.data = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSeM6xeTLM95yyz_BZ0zb8rfMAjgPsJFJojC2WTEX2jqnc14OQ/viewform?usp=sf_link")
//                startActivity(openURL)
            }
            R.id.loc -> {
                val intent = Intent(this, googlemap::class.java)
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

private fun ActionBar?.setIcon(fromHtml: Spanned?) {
    TODO("Not yet implemented")
}

private fun DrawerLayout.setBackgroundColor(s: String) {

}

private fun ActionBar?.setBackgroundDrawable(fromHtml: Spanned?) {
}
