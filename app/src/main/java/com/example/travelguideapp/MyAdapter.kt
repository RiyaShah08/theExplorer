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
        val internetUrl = currentitem.imageURL

        println(internetUrl)

        Glide
            .with(holder.context)
            .load(internetUrl)
            .into(holder.image)
        var coo = currentitem.placecoo
        println("////////////////////////////////")
        println(coo)
        println("////////////////////////////////")
        holder.placename.text = currentitem.placename
        holder.placedis.text = currentitem.placedis
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.findViewById(R.id.raw_image)
        val placename : TextView = itemView.findViewById(R.id.placename)
        val placedis : TextView = itemView.findViewById(R.id.placedis)
    }
}