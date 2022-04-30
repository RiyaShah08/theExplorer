package com.example.travelguideapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.widget.Toast
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycle_blue.*


private const val REQUEST_CODE_IMAGE_PICK = 0

class recycle_blue : AppCompatActivity() {
    // creating a variable for our Firebase Database.
    var firebaseDatabase: FirebaseDatabase? = null
    var curFile: Uri? = null

    val imageRef = Firebase.storage.reference

    // creating a variable for our Database Reference for Firebase.
    var databaseReference: DatabaseReference? = null

    // variable for Text view.
    private var retrieveTV: TextView? = null
    private var retrieveTV1: TextView? = null
    private var retrieveTV2: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_blue)

        raw_image.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "users/user1/*"
                startActivityForResult(it, REQUEST_CODE_IMAGE_PICK)
            }
        }

        // below line is used to get the instance of our Firebase database.
        firebaseDatabase = FirebaseDatabase.getInstance()

        // below line is used to get reference for our database.
        databaseReference = firebaseDatabase!!.getReference("users/user1")

        // initializing our object class variable.

        retrieveTV2 = findViewById(R.id.imge1)
        retrieveTV = findViewById(R.id.textView)
        retrieveTV1 = findViewById(R.id.textView3)

        // calling method for getting data.
        getdata()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE_IMAGE_PICK) {
            data?.data?.let {
                curFile = it
                raw_image.setImageURI(it)
            }
        }
    }

    private fun getdata() {

        // calling add value event listener method for getting the values from database.
        databaseReference!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // this method is call to get the realtime updates in the data. this method is called when the data is changed in our Firebase console.
                // below line is for getting the data from snapshot of our database.
                val value = snapshot.value

                // after getting the value we are setting our value to our text view in below line.
                retrieveTV!!.text = value.toString()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@recycle_blue, "Required Field must be not empty", Toast.LENGTH_LONG).show()
            }
        })
    }
}

private fun Any.setImageURI(it: Uri) {

}
