package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Pattern

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
            val username = username.text.toString()
            val inputEmail = email_id.text.toString()
            val inputPassword = password.text.toString()
            if(inputPassword.length == 0 || inputEmail.length == 0 || username.length == 0){
                Toast.makeText(this@signup_activity, "Required Field must be not empty", Toast.LENGTH_LONG)
                    .show()
            }
            else if(username.length <= 1){
                Toast.makeText(this@signup_activity, "Username must be greater than 2 character", Toast.LENGTH_LONG)
                    .show()
            }
            else if(android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches() == false){
                Toast.makeText(this@signup_activity, "Wrong email address", Toast.LENGTH_LONG)
                    .show()
            }
            else if(inputPassword.length <= 5){
                Toast.makeText(this@signup_activity, "password length must be greater than 6", Toast.LENGTH_LONG)
                    .show()
            }

            else{
                registerUserInFirebase(inputEmail, inputPassword)
            }

        }

        signin1.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }
    }

    private fun registerUserInFirebase(inputEmail: String, inputPassword: String) {
        auth.createUserWithEmailAndPassword(inputEmail, inputPassword).addOnCompleteListener {

            if (it.isSuccessful) {
                Toast.makeText(this@signup_activity, "Register Successfully", Toast.LENGTH_LONG)
                    .show()
                val intent = Intent(this, login::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@signup_activity, "$inputEmail is already registered", Toast.LENGTH_LONG).show()
            }
        }
    }
}

