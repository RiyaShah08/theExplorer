package com.example.travelguideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.NonNull;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import android.widget.Toast
import android.widget.TextView


class recycle_blue : AppCompatActivity() {
    // creating a variable for
    // our Firebase Database.
    var firebaseDatabase: FirebaseDatabase? = null

    // creating a variable for our
    // Database Reference for Firebase.
    var databaseReference: DatabaseReference? = null

    // variable for Text view.
    private var retrieveTV: TextView? = null
    private var retrieveTV1: TextView? = null
    private var retrieveTV2: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_blue)

        // below line is used to get the instance
        // of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get
        // reference for our database.
        databaseReference = firebaseDatabase!!.getReference("user1")

        // initializing our object class variable.

        retrieveTV2 = findViewById(R.id.imge1)
        retrieveTV = findViewById(R.id.textView)
        retrieveTV1 = findViewById(R.id.textView3)

        // calling method
        // for getting data.
        getdata()
    }

    private fun getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                val value = snapshot.getValue(String::class.java)

                // after getting the value we are setting
                // our value to our text view in below line.
                retrieveTV!!.text = value
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@recycle_blue, "Required Field must be not empty", Toast.LENGTH_LONG).show()
            }
        })
    }
}
