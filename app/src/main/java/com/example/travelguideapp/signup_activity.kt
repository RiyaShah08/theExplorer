package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import java.util.regex.Pattern

class signup_activity : AppCompatActivity() {
    private lateinit var username: TextInputEditText
    private lateinit var email_id: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var Signup_button: CardView
    private lateinit var signin1: TextView
    private lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 89
    private lateinit var googleSignInClient: GoogleSignInClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id_auth))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

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
            if (inputPassword.length == 0 || inputEmail.length == 0 || username.length == 0) {
                Toast.makeText(
                    this@signup_activity,
                    "Required Field must be not empty",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else if (username.length <= 1) {
                Toast.makeText(
                    this@signup_activity,
                    "Username must be greater than 2 character",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else if (android.util.Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches() == false) {
                Toast.makeText(this@signup_activity, "Wrong email address", Toast.LENGTH_LONG)
                    .show()
            } else if (inputPassword.length <= 5) {
                Toast.makeText(
                    this@signup_activity,
                    "password length must be greater than 6",
                    Toast.LENGTH_LONG
                )
                    .show()
            } else {
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
                    this@signup_activity, "$inputEmail is already registered", Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.i("Error", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.i("firebase", "signInWithCredential: success")
                    val user = auth.currentUser

                    startActivity(Intent(this, Home::class.java))
                    Log.i("firebase", "firebaseAuthWithGoogle: ${user?.displayName}")
                } else {
                    Log.i("firebase", "signInWithCredential: failure", task.exception)
                }
            }
    }

    fun loginwithgoogle1(view: android.view.View) {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
}
