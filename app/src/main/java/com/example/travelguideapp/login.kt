package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var emailid = findViewById<TextInputEditText>(R.id.emailid)
        var password = findViewById<TextInputEditText>(R.id.password)
        var login1 = findViewById<CardView>(R.id.login1)
        var register = findViewById<TextView>(R.id.signup)
        auth = FirebaseAuth.getInstance()

        login1.setOnClickListener {
            val userinput = emailid.text.toString()
            val passinput = password.text.toString()

            checkcredential(userinput, passinput)
        }

        register.setOnClickListener {
            var intent = Intent(this, signup_activity::class.java)
            startActivity(intent)
        }

        val txt1 = findViewById(R.id.txt1) as TextView
        txt1.setOnClickListener {
            val intent = Intent(this, forgotpass::class.java)
            startActivity(intent)
        }
    }

    private fun checkcredential(userinput: String, passinput: String) {
        if (userinput.isNotEmpty() && passinput.isNotEmpty()) {
            auth.signInWithEmailAndPassword(userinput, passinput).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, Home::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Wrong credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}


