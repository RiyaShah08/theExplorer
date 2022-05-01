package com.example.travelguideapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_contact_us.*
import java.lang.Exception

class contact_us : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_us)

        sendmessage.setOnClickListener{
            val email = email.text.toString().trim()
            val message = message.text.toString().trim()

            sendEmail(email, message)
        }
    }

    private fun sendEmail(email: String, message: String) {
        val mIntent = Intent(Intent.ACTION_SEND)
        mIntent.data = Uri.parse("mailto:")
        mIntent.type = "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))

        mIntent.putExtra(Intent.EXTRA_SUBJECT, message)

        try{
            startActivity(Intent.createChooser(mIntent, "choose email"))
        }
        catch (e: Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}