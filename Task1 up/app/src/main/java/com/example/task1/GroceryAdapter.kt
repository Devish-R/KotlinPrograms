package com.example.task1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class GroceryAdapter(
    var context: Context,
    var nameslist: ArrayList<String>,
    var gimagelist: ArrayList<Int>
) : BaseAdapter() {


    override fun getCount(): Int {
        return nameslist.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
       return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {


        val view : View = LayoutInflater.from(parent!!.context).inflate(R.layout.gridview,parent,false)

        var groceryName : TextView = view.findViewById(R.id.gtext)
        var  gimageview : ImageView = view.findViewById(R.id.gimage)

        groceryName.text = nameslist.get(position)
        gimageview.setImageResource(gimagelist.get(position))

        return view
    }
}