package com.example.task1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var bt : Button
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
        var name : String = intent.getStringExtra("UNAME").toString()
        tv.text = "HI! $name WELCOME!!"

        bt.setOnClickListener {
            var intent = Intent(this@ThirdActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}