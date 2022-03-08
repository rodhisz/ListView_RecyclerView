package com.example.listbuah

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BuahAdapter (val namabuah : Array<String>, val gambarbuah :Array<Int>, val suarabuah : Array<Int>) :
    RecyclerView.Adapter<BuahAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvBuah = view.findViewById<TextView>(R.id.item_tv_buah)
        val imgBuah = view.findViewById<ImageView>(R.id.item_img)

    }

    // 1. Call Layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_buah, parent, false)
        return MyViewHolder(view)
    }

    // 2. Mengatur posisi antar data
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvBuah.text = namabuah[position]
        holder.imgBuah.setImageResource(gambarbuah[position])
        holder.itemView.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(holder.itemView.context, suarabuah[position])
            mediaPlayer.start()
        }
    }

    // 3. Count data / menampilkan banyak data yang ada
    override fun getItemCount(): Int {
        return namabuah.size
    }

}