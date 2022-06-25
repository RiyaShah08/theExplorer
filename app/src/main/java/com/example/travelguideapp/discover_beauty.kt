package com.example.travelguideapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import com.example.travelguideapp.webview
import kotlinx.android.synthetic.main.activity_discover_beauty.*
import kotlinx.android.synthetic.main.activity_webview.*

class discover_beauty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover_beauty)

        card.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/yKYvUea")
            startActivity(openURL)
        }

//        imageView17.setOnClickListener {
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://cutt.ly/rKYvELz")
//            startActivity(openURL)
//        }
//
//        imageView18.setOnClickListener {
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("")
//            startActivity(openURL)
//        }
//
//        imageView19.setOnClickListener {
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://bit.ly/3yiijb2")
//            startActivity(openURL)
//        }
//
//        imageview20.setOnClickListener {
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://bit.ly/3yiijb2")
//            startActivity(openURL)
//        }
//
//        imageview21.setOnClickListener {
//            val openURL = Intent(android.content.Intent.ACTION_VIEW)
//            openURL.data = Uri.parse("https://bit.ly/3yiijb2")
//            startActivity(openURL)
//        }

        db1.setOnClickListener {
            val intent = Intent(this, discover_des1::class.java)
            startActivity(intent)
        }

        db2.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/SKYcrUF")
            startActivity(openURL)
        }

        db3.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/NKYcur4")
            startActivity(openURL)
        }

        db4.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/6KYci7l")
            startActivity(openURL)
        }

        db5.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/vKYcjlJ")
            startActivity(openURL)
        }

        db6.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/ZKYclFn")
            startActivity(openURL)
        }

        db7.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/vKYcvgW")
            startActivity(openURL)
        }

        //________________________________________________**___________________________________________________
        db8.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/hKYvkFj")
            startActivity(openURL)
        }

        db9.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/IKYvxXg")
            startActivity(openURL)
        }

        db10.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/WKYvbLZ")
            startActivity(openURL)
        }

        db11.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/OKYvm2D")
            startActivity(openURL)
        }

        db12.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/rKYvELz")
            startActivity(openURL)
        }

        db13.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/yKYvUea")
            startActivity(openURL)
        }

        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }


        //______________________________________________________**___________________________________________________
        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }

        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }

        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }

        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }

        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }

        db14.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYvIN2")
            startActivity(openURL)
        }




        val back_dc = findViewById(R.id.back_dc) as ImageView
        back_dc.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}