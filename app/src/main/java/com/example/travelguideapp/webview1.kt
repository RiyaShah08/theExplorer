package com.example.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.travelguideapp.webview
import com.example.travelguideapp.webview1
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.activity_webview1.*

class webview1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview1)

        WV1.settings.javaScriptEnabled = true
        WV1.webViewClient = WebViewClient()
        WV1.loadUrl("https://trekon.in/")
    }
}