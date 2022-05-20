package com.example.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview1.*
import kotlinx.android.synthetic.main.activity_webview3.*

class webview3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview3)

        WV3.settings.javaScriptEnabled = true
        WV3.webViewClient = WebViewClient()
        WV3.loadUrl("https://thrillblazers.in/")
    }
}