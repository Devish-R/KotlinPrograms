package com.example.task1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    lateinit var sname : EditText
    lateinit var smail : EditText
    lateinit var spass : EditText
    lateinit var signin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sname = findViewById(R.id.sename)
        smail = findViewById(R.id.setmail)
        spass = findViewById(R.id.sepassword)
        signin = findViewById(R.id.button2)




        //getting details from registration page
        var sUName :String = intent.getStringExtra("Names").toString()
        var sUpassword :String =intent.getStringExtra("Password").toString()
        var sEmail :String = intent.getStringExtra("Email").toString()

        signin.setOnClickListener {
            //information user inputs from login page
            var lUname : String = sname.text.toString()
            var lpass : String = spass.text.toString()
            var lmail : String = smail.text.toString()

            if((lUname==sUName) && (lmail==sEmail) && (lpass==sUpassword)){
                Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()

            }
            else{
                Toast.makeText(this,"Invalid Credentials try Again ", Toast.LENGTH_SHORT).show()

            }
        }
    }
}