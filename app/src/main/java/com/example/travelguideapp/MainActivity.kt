package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val handler = Handler()
        val runnable = Runnable {
            val i = Intent(this@MainActivity, login::class.java)
            startActivity(i)
        }
        handler.postDelayed(runnable, 1000)
    }
}