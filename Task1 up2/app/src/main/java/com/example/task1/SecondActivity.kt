package com.example.task1

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.MainScope

class SecondActivity : AppCompatActivity() {
   // lateinit var sname : EditText
    lateinit var smail : EditText
    lateinit var spass : EditText
    lateinit var signin : Button
    var count : Int = 0
    var isSignedIn : Boolean? = false
    var sname :String? = null
    lateinit var spref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
       // sname = findViewById(R.id.sename)
        smail = findViewById(R.id.setmail)
        spass = findViewById(R.id.sepassword)
        signin = findViewById(R.id.button2)




        //getting details from registration page
        sname  = intent.getStringExtra("Names").toString()
        var sUpassword :String =intent.getStringExtra("Password").toString()
        var sEmail :String = intent.getStringExtra("Email").toString()

        signin.setOnClickListener {
            //information user inputs from login page
          //  var lUname : String = sname.text.toString()
            var lpass : String = spass.text.toString()
            var lmail : String = smail.text.toString()
            if ( lpass.isEmpty() || lmail.isEmpty())
            {
                Toast.makeText(this,"Please enter every details",Toast.LENGTH_SHORT).show()
            }
            else{
            if ( (lmail == sEmail) && (lpass == sUpassword)) {
                Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                var intent = Intent(this@SecondActivity, HomePage::class.java)
                //intent.putExtra("UName",sUName)
                startActivity(intent)

                //saving login de such that on next open of goes to the home page directly
                saveData()

            } else if (count == 3) {
                showDialogMsg()
            } else {
                Toast.makeText(this, "Invalid Credentials try Again ", Toast.LENGTH_SHORT).show()
                count++
            }
        }
        }
    }

    fun showDialogMsg(){
        var alterDialog = AlertDialog.Builder(this@SecondActivity)
        alterDialog.setTitle("NEW USER")
        alterDialog.setMessage("Are you a new user if so,would you like to register!!")
        alterDialog.setIcon(R.drawable.alert)
        alterDialog.setCancelable(false)
        //if user click on NO
        alterDialog.setNegativeButton("No", DialogInterface.OnClickListener{`interface`, i ->
            count = 0
            `interface`.cancel()
        })
        //if user click on yes navigate to Registration page
        alterDialog.setPositiveButton("YES", DialogInterface.OnClickListener{`interface`, i ->
            var intent = Intent(this@SecondActivity, MainActivity::class.java)
            startActivity(intent)
        })
        alterDialog.create().show()
    }
    fun saveData(){
        spref = this.getSharedPreferences("loginStatus",MODE_PRIVATE)
        isSignedIn = true

        val editor = spref.edit()
        editor.putBoolean("SignedIn",isSignedIn!!)
        editor.putString("name",sname)

        editor.apply()
    }
}