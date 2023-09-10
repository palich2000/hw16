package com.palich.listview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyRecyclerViewAdapter(private val items: List<SuperHero>, val cb: (s:String)->Any) : RecyclerView.Adapter<MyRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        holder.title.text = items[position].name
        val url = items[position].images?.sm ?: return
        Glide.with(holder.image.context).load(url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class MyRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = this.itemView.findViewById(R.id.text)
    val image: ImageView = this.itemView.findViewById(R.id.image)
}
