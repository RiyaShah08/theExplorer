package com.example.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class forgotpass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpass)

        val button = findViewById(R.id.button) as TextView
        val emailreset = findViewById(R.id.emailreset) as TextInputEditText

        button.setOnClickListener{
            val email: String = emailreset.text.toString().trim { it <= ' ' }
            if(email.isEmpty()){
                Toast.makeText(this@forgotpass, "Please enter your email address", Toast.LENGTH_SHORT).show()
            }
            else{
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener{task ->
                        if(task.isSuccessful){
                            Toast.makeText(this@forgotpass,"Email sent successfully to reset your password!", Toast.LENGTH_LONG).show()
                            finish()
                        }
                        else{
                            Toast.makeText(this@forgotpass, task.exception!!.message.toString(),
                            Toast.LENGTH_LONG).show()
                        }
                    }
            }
        }
    }
}
