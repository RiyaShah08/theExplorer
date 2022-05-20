package com.example.travelguideapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.bumptech.glide.Glide
import android.content.Context
import android.widget.Toast


class MyAdapter(private val userList: ArrayList<realtime_fetch> ) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_image,
        parent, false)

        return MyViewHolder(itemView,parent.context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]
        //val targetImageView = findViewById(R.id.imageView) as ImageView
        val internetUrl = "https://firebasestorage.googleapis.com/v0/b/travelguideapp-c22a1.appspot.com/o/images%2Fnew1.png?alt=media&token=2ef389d0-cf30-4952-a199-9c1f53b6d4bb"

        Glide
            .with(holder.context)
            .load(internetUrl)
            .into(holder.imageURL)
        holder.placename.text = currentitem.placename
        holder.placedis.text = currentitem.placedis
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView){

        val imageURL: ImageView = itemView.findViewById(R.id.raw_image)
        val placename : TextView = itemView.findViewById(R.id.placename)
        val placedis : TextView = itemView.findViewById(R.id.placedis)

    }
}