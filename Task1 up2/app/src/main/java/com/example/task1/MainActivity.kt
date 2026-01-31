package com.example.task1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userName : EditText
    lateinit var mail : EditText
    lateinit var password : EditText
    lateinit var register : Button
    lateinit var shpref: SharedPreferences
    var Singin : Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        retriveData()

        userName = findViewById(R.id.etname)
        mail = findViewById(R.id.etmail)
        password = findViewById(R.id.etpassword)
        register = findViewById(R.id.button)

        register.setOnClickListener {
            var username : String = userName.text.toString()
            var pass : String = password.text.toString()
            var email : String = mail.text.toString()

            if(username.isEmpty() || email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Please enter every details",Toast.LENGTH_SHORT).show()
            }

            else {
                var intent = Intent(this@MainActivity, SecondActivity::class.java)

                intent.putExtra("Names", username)
                intent.putExtra("Password", pass)
                intent.putExtra("Email", email)

                startActivity(intent)

            }
        }
    }

    fun retriveData() {
        shpref = this.getSharedPreferences("loginStatus", MODE_PRIVATE)
        Singin = shpref.getBoolean("SignedIn", false)
        if (Singin == true) {
            startActivity(Intent(this@MainActivity, HomePage::class.java))
        }
    }

}