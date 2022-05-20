package com.example.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview2.*
import kotlinx.android.synthetic.main.activity_webview3.*

class webview2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview2)

        WV2.settings.javaScriptEnabled = true
        WV2.webViewClient = WebViewClient()
        WV2.loadUrl("https://www.yhaindia.org/")
    }
}