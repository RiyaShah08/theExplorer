package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User

class signup : AppCompatActivity() {
    private lateinit var name: TextInputEditText
    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var register: ImageButton
    private lateinit var signin: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        register = findViewById(R.id.signup1)
        auth = FirebaseAuth.getInstance()

        register.setOnClickListener {
            val inputEmail = username.text.toString()
            val inputPassword = password.text.toString()
            registerUserInFirebase(inputEmail, inputPassword)
        }

        signin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        val signup1 = findViewById(R.id.signup1) as CardView
        signup1.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

    }

    private fun registerUserInFirebase(inputEmail: String, inputPassword: String) {
        auth.createUserWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener {
            if (it.isSuccessful) {
                val username = name.text.toString()
                Toast.makeText(this, "Register Successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
//                finish()
            } else {
                Toast.makeText(this, "$inputEmail is already registered", Toast.LENGTH_LONG).show()
            }
        }
    }
}