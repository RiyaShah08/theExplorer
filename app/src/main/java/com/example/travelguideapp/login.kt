package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.gms.auth.api.credentials.IdToken
import com.google.android.material.textfield.TextInputEditText
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class login : AppCompatActivity() {

    private val RC_SIGN_IN = 89
    private lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id_auth))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

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

    fun loginwithgoogle(view: android.view.View) {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent,RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try{
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account.idToken!!)
            }catch (e: ApiException){
                Log.i( "Error", "Google sign in failed", e)
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String){
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if(task.isSuccessful)
                {
                    Log.i("firebase", "signInWithCredential: success")
                    val user = auth.currentUser

                    startActivity(Intent(this, Home::class.java))
                    Log.i("firebase", "firebaseAuthWithGoogle: ${user?.displayName}")
                }else{
                    Log.i("firebase", "signInWithCredential: failure", task.exception)
                }
            }
    }
}