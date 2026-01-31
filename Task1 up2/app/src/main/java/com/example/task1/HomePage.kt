package com.example.task1

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task1.R.id.recyclerview
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomePage : AppCompatActivity() {
    lateinit var recycler : RecyclerView

    var itemNames = ArrayList<String>()
    var pricelist =  ArrayList<String>()
    var imagelist = ArrayList<Int>()


    lateinit var adapter : ItemsAdapter

    lateinit var nav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recycler = findViewById(R.id.recyclerview)

        recycler.layoutManager = LinearLayoutManager(this)

        itemNames.add("LAPTOP")
        itemNames.add("AC")
        itemNames.add("FAN")
        itemNames.add("FRIDGE")
        itemNames.add("IRONBOX")
        itemNames.add("MOBLIE")
        itemNames.add("MOBILE CHARGER")
        itemNames.add("POWER BANK")
        itemNames.add("SPEAKER")
        itemNames.add("TV")


        pricelist.add("Price: 400000")
        pricelist.add("Price: 18000")
        pricelist.add("Price: 3000")
        pricelist.add("Price: 30000")
        pricelist.add("Price: 400")
        pricelist.add("Price: 24000")
        pricelist.add("Price: 400")
        pricelist.add("Price: 599")
        pricelist.add("Price: 489")
        pricelist.add("Price: 16000")

        imagelist.add(R.drawable.lap)
        imagelist.add(R.drawable.ac)
        imagelist.add(R.drawable.fan)
        imagelist.add(R.drawable.fridge)
        imagelist.add(R.drawable.ironbox)
        imagelist.add(R.drawable.mobile)
        imagelist.add(R.drawable.mobilecharger)
        imagelist.add(R.drawable.powerbank)
        imagelist.add(R.drawable.speaker)
        imagelist.add(R.drawable.tv)

        adapter = ItemsAdapter(pricelist,imagelist,itemNames,this)
        recycler.adapter = adapter

        nav = findViewById<BottomNavigationView>(R.id.BottomNav)
        nav.selectedItemId = R.id.home

        nav.setOnItemSelectedListener { item ->
            when(item.itemId){

                R.id.home ->{
                    true
                }

                R.id.groceries ->{
                    startActivity(Intent(this, Groceries::class.java))
                    finish()
                    true
                }

                R.id.profile ->{
                    startActivity(Intent(this, ThirdActivity::class.java))
                    finish()
                    true
                }
                else -> false
            }

        }





    }
}