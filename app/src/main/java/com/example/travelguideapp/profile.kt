package com.example.travelguideapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val email = findViewById(R.id.emailid_change) as TextView
        val change = findViewById(R.id.changepass) as TextView

        val profile = findViewById(R.id.profile_main) as ImageView
        profile.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        change.setOnClickListener{
            val email: String = email.text.toString().trim { it <= ' ' }
            if(email.isEmpty()){
                Toast.makeText(this@profile, "Please enter your email address", Toast.LENGTH_SHORT).show()
            }
            else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{task ->
                        if(task.isSuccessful){
                            Toast.makeText(this@profile,"Email sent successfully to reset your password!", Toast.LENGTH_LONG).show()
                            finish()
                        }
                        else{
                            Toast.makeText(this@profile, task.exception!!.message.toString(),
                                Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}