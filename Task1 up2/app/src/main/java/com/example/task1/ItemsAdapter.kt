package com.example.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import de.hdodenhof.circleimageview.CircleImageView

class ItemsAdapter(
    var pricelist: ArrayList<String>,
    var imagelist: ArrayList<Int>,
    var itemNames: ArrayList<String>,  var context: Context,) : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textviewItemname.text = itemNames.get(position)
        holder.textviewprice.text = pricelist.get(position)
        holder.imageview.setImageResource(imagelist.get(position))
    }

    override fun getItemCount(): Int {
        return itemNames.size
    }

    class ItemViewHolder(itemView: View) : ViewHolder(itemView) {

        var textviewItemname: TextView = itemView.findViewById(R.id.itemtitle)
        var textviewprice: TextView = itemView.findViewById(R.id.price)
        var imageview: CircleImageView = itemView.findViewById(R.id.profile_image)
    }

}