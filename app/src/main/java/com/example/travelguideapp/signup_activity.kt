package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class signup_activity : AppCompatActivity() {
    private lateinit var username: TextInputEditText
    private lateinit var email_id: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var Signup_button: CardView
    private lateinit var signin1: TextView
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        email_id = findViewById(R.id.email_id)
        signin1 = findViewById(R.id.sign_in)
        Signup_button = findViewById(R.id.Signup_button)
        auth = FirebaseAuth.getInstance()

        Signup_button.setOnClickListener {
            val inputEmail = username.text.toString()
            val inputPassword = password.text.toString()
            registerUserInFirebase(inputEmail, inputPassword)
        }

        signin1.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }

    private fun registerUserInFirebase(inputEmail: String, inputPassword: String) {
        auth.createUserWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener {
            if (it.isSuccessful) {

                val UserName = username.text.toString()
                //appDatainFirestore(it.result?.user?.uid ,inputEmail, inputPassword)
                Toast.makeText(this@signup_activity, "Register Successfully", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@signup_activity, "$inputEmail is already registered", Toast.LENGTH_LONG).show()
            }
        }
    }
}