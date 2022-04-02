package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {

    private lateinit var emailid: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var login1: CardView
    private lateinit var signup: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        emailid = findViewById(R.id.emailid)
        password = findViewById(R.id.password)
        login1 = findViewById(R.id.login1)
        signup = findViewById(R.id.signup)
        auth = FirebaseAuth.getInstance()

        login1.setOnClickListener {
            val userinput = emailid.text.toString()
            val passinput = password.text.toString()

            checkcredential(userinput, passinput)
        }
        signup.setOnClickListener {
            val intent = Intent(this, com.example.travelguideapp.signup::class.java)
            startActivity(intent)
        }

        val txt1 = findViewById(R.id.txt1) as TextView
        txt1.setOnClickListener{
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