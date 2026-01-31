package com.example.task1

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.ArrayList

class Groceries : AppCompatActivity() {
    lateinit var nav : BottomNavigationView


    lateinit var gridView: GridView
    var nameslist = ArrayList<String>()
    var gimagelist = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_groceries)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //gridview implementation
        gridView = findViewById(R.id.gview)

        arrayListFill()

        var adapter = GroceryAdapter(this,nameslist,gimagelist)

        gridView.adapter = adapter


        gridView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "You have selected: ${nameslist[position]}", Toast.LENGTH_SHORT).show()
        }


        //Bottom navigation implementation
        nav = findViewById(R.id.BottomNav)
        nav.selectedItemId = R.id.groceries

        nav.setOnItemSelectedListener { item ->
            when(item.itemId){

                R.id.home ->{
                    startActivity(Intent(this, HomePage::class.java))
                    finish()
                    true
                }

                R.id.groceries ->{
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

    fun arrayListFill(){
        nameslist.add("Beetrrot")
        nameslist.add("cabbage")
        nameslist.add("carrot")
        nameslist.add("cauliflower")
        nameslist.add("coconut")
        nameslist.add("ladiesfinger")
        nameslist.add("onion")
        nameslist.add("potato")
        nameslist.add("radish")
        nameslist.add("tomato")


        gimagelist.add(R.drawable.beetrrot)
        gimagelist.add(R.drawable.cabbage)
        gimagelist.add(R.drawable.carrot)
        gimagelist.add(R.drawable.cauliflower)
        gimagelist.add(R.drawable.coconut)
        gimagelist.add(R.drawable.ladiresfinger)
        gimagelist.add(R.drawable.onion)
        gimagelist.add(R.drawable.potato)
        gimagelist.add(R.drawable.radish)
        gimagelist.add(R.drawable.tomato)
    }
}