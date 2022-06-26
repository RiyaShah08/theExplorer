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

        imageView17.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/qKUpnC8")
            startActivity(openURL)
        }

        imageView18.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/iKUpXSC")
            startActivity(openURL)
        }

        imageView19.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/jKUpMYe")
            startActivity(openURL)
        }

        imageview20.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/lKUp5MA")
            startActivity(openURL)
        }

        imageview21.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/4KUaeAs")
            startActivity(openURL)
        }

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
        db15.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/uKYbOQC")
            startActivity(openURL)
        }

        db16.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/mKYbA8m")
            startActivity(openURL)
        }

        db17.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/bKYbJ8u")
            startActivity(openURL)
        }

        db18.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/XKYbXQT")
            startActivity(openURL)
        }

        db19.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/5KYbBZ4")
            startActivity(openURL)
        }

        db20.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYb1Gq")
            startActivity(openURL)
        }

        db21.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/PKYb9Lt")
            startActivity(openURL)
        }

        //__________________________________________________**______________________________________________
        db22.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/0KYnCc5")
            startActivity(openURL)
        }

        db23.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/uKYnBMS")
            startActivity(openURL)
        }

        db24.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/wKYnMR0")
            startActivity(openURL)
        }

        db25.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/pKYn18o")
            startActivity(openURL)
        }

        db26.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/rKYn9hx")
            startActivity(openURL)
        }

        db27.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/rKYn8vo")
            startActivity(openURL)
        }

        db28.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/pKYn5Du")
            startActivity(openURL)
        }

        //_____________________________________________**__________________________________________
        db29.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/8KYEVB3")
            startActivity(openURL)
        }

        db30.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/PKYE1fe")
            startActivity(openURL)
        }

        db31.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/zKYE8TL")
            startActivity(openURL)
        }

        db32.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/EKYE7My")
            startActivity(openURL)
        }

        db33.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/OKYRqhG")
            startActivity(openURL)
        }

        db34.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/WKYRthB")
            startActivity(openURL)
        }

        db35.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/6KYRuFu")
            startActivity(openURL)
        }

        //_______________________________________________________**__________________________________________________________
        db36.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/sKYRkWl")
            startActivity(openURL)
        }

        db37.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/jKYRzUg")
            startActivity(openURL)
        }

        db38.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/QKYRcQJ")
            startActivity(openURL)
        }

        db39.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/vKYRbxX")
            startActivity(openURL)
        }

        db40.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/jKYRWlH")
            startActivity(openURL)
        }

        db41.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/iKYRRp7")
            startActivity(openURL)
        }

        db42.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/DKYRY8T")
            startActivity(openURL)
        }

        //______________________________________________***____________________________________________________
        db43.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/CKYTzog")
            startActivity(openURL)
        }

        db44.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/xKYTcL4")
            startActivity(openURL)
        }

        db45.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/rKYTnPc")
            startActivity(openURL)
        }

        db46.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/WKYT1mi")
            startActivity(openURL)
        }

        db47.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse( "https://cutt.ly/fKYT2QB")
            startActivity(openURL)
        }

        db48.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/SKYT3E7")
            startActivity(openURL)
        }

        db49.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://cutt.ly/hKYT7Dn")
            startActivity(openURL)
        }

        //____________________________________________**____________________________________________
        db50.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://goo.gl/maps/7tAqWi9KQTtAVSWSA")
            startActivity(openURL)
        }

        db51.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://goo.gl/maps/hkHhhnCFqScmuSHs6")
            startActivity(openURL)
        }

        db52.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://goo.gl/maps/A4SQxp3Xvvf9UpkG9")
            startActivity(openURL)
        }

        db53.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://goo.gl/maps/sVDwvRUDhKXu5YUZ8")
            startActivity(openURL)
        }

        db54.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://goo.gl/maps/MhBUdhPsqR9GCUew7")
            startActivity(openURL)
        }

        db55.setOnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://goo.gl/maps/WNdr9hLd8b6ykhe39")
            startActivity(openURL)
        }


        val back_dc = findViewById(R.id.back_dc) as ImageView
        back_dc.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}