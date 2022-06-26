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
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_forgotpass.view.*
import kotlinx.android.synthetic.main.activity_item_image.view.*


class MyAdapter(private val userList: ArrayList<realtime_fetch>, val listner:recycle_blue) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_image,
            parent, false)

        itemView.button_loc.setOnClickListener {
            listner.setClick()
        }
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
        holder.placeloc.text = currentitem.placecoo
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class MyViewHolder(itemView: View, val context: Context) : RecyclerView.ViewHolder(itemView){

        val image: ImageView = itemView.findViewById(R.id.raw_image)
        val placename : TextView = itemView.findViewById(R.id.placename)
        val placedis : TextView = itemView.findViewById(R.id.placedis)
        val placeloc : TextView = itemView.findViewById(R.id.placeloc)
        val button : Button = itemView.findViewById(R.id.button_loc)

    }
}