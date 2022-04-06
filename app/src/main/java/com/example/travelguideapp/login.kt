package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.example.travelguideapp.databinding.ActivityMainBinding
import com.google.android.gms.auth.GoogleAuthException
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

class login : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var emailid: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var login1: CardView
    private lateinit var register: TextView
    private lateinit var login_google: CardView
    lateinit var auth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    private companion object{
        private const val RC_SIGN_IN = 100
        private const val TAG = "Google_sign_in_tag"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailid = findViewById(R.id.emailid)
        password = findViewById(R.id.password)
        login1 = findViewById(R.id.login1)
        register = findViewById(R.id.signup)
        login_google = findViewById(R.id.loginwithgoogle)
        auth = FirebaseAuth.getInstance()

        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN)
            .requestIdToken(R.string.default_web)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        auth = FirebaseAuth.getInstance()
        checkUser()

        login_google.setOnClickListener {
            Log.d(TAG,"Oncreate: begin Gogle SignIn")
            val intent = googleSignInClient.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
        }

        private fun FirebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {
            Log.d(TAG, "begin firebase with google account")

            val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
            FirebaseAuth.SignInWithCredential(credential)
        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == RC_SIGN_IN) {
                Log.d(TAG, "onActivityResult: google signin result")
                val accounttask = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = accounttask.getResult(ApiException::class.java)
                    FirebaseAuthWithGoogleAccount(account)
                }

                catch (e: Exception){
                    Log.d(TAG, "onActivityResult: ${e.message}")
                }
            }
        }

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

    private fun checkUser() {
        TODO("Not yet implemented")
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

