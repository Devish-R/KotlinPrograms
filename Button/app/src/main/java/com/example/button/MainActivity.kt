package com.example.button

import android.graphics.Color
import android.graphics.Color.RED
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    lateinit var doMagic : Button
    lateinit var myButton: Button
     lateinit var tv : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        doMagic = findViewById(R.id.doMagic)
        myButton = findViewById(R.id.res)
        tv = findViewById(R.id.textView2)



        doMagic.setOnClickListener {
            tv.setBackgroundColor(Color.GRAY)
            tv.setTextColor(Color.BLUE)
            tv.text = "magic has happened "
            tv.isVisible = false
            doMagic.isVisible = false

        }

        myButton.setOnClickListener {
            tv.isVisible = true
            doMagic.isVisible = true
        }



    }


}