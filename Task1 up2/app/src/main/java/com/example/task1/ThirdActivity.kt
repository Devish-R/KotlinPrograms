package com.example.task1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ThirdActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var bt : Button
    var isSignedIn : Boolean? = false
    var name : String? = null
    lateinit var sprefs : SharedPreferences

    lateinit var nav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tv = findViewById(R.id.textView2)
        bt = findViewById(R.id.exit)


        retrieveName()
        tv.text = "HI! $name WELCOME!!"

        bt.setOnClickListener {
            saveData()

            var intent = Intent(this@ThirdActivity, MainActivity::class.java)
            startActivity(intent)

        }

        nav = findViewById(R.id.BottomNav)
        nav.selectedItemId = R.id.profile

        nav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.home ->{
                    startActivity(Intent(this, HomePage::class.java))
                    finish()
                    true
                }

                R.id.groceries -> {
                    startActivity(Intent(this, Groceries::class.java))
                    finish()
                    true
                }

                R.id.profile ->{
                    true
                }
                else -> false
            }
        }
    }
    fun saveData(){
        sprefs = this.getSharedPreferences("loginStatus",MODE_PRIVATE)
            val editor = sprefs.edit()
            name = null
            editor.putBoolean("SignedIn",isSignedIn!!)
             editor.putString("name", name)
            editor.apply()

    }

    fun retrieveName(){
        sprefs = this.getSharedPreferences("loginStatus",MODE_PRIVATE)
        name = sprefs.getString("name",null)
    }
}