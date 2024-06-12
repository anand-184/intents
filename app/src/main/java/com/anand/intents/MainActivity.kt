package com.anand.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private fun Any.putExtra(extraEmail: Any) {

}

class MainActivity : AppCompatActivity() {
    var dial: Button?= null
    var email: Button?= null
    var message: Button?= null
    var website: Button?=null
    var number: EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dial =findViewById(R.id.dial)
        email=findViewById(R.id.email)
        message=findViewById(R.id.message)
        website=findViewById(R.id.website)
        number=findViewById(R.id.number)


        dial?.setOnClickListener {
            number?.visibility= View.VISIBLE
            try {

                var intent = Intent(Intent.ACTION_DIAL)
                intent.setData(Uri.parse("tel:"))
                startActivity(intent)
            } catch (exception: Exception) {
                Toast.makeText(this,"Sorry dail failed", Toast.LENGTH_LONG).show()
            }
        }
        message?.setOnClickListener {
            try{
                var intent=Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("sms:" ))
                startActivity(intent)
            }catch (exception:Exception){
                Toast.makeText(this,"Message sending failed",Toast.LENGTH_LONG).show()
            }
        }
        website?.setOnClickListener {
            try {
                var intent=Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("https://github.com/"))
                startActivity(intent)
            }catch (exception:Exception){
                Toast.makeText(this,"Failed to go to Website",Toast.LENGTH_LONG).show()
            }
        }
        email?.setOnClickListener {
            try{
                var intent=Intent(Intent.ACTION_SENDTO)
                intent.setData(Uri.parse("mailto:o7services017@gmail.com"))
                intent.putExtra(Intent.EXTRA_SUBJECT,"Leave Application")
                intent.putExtra(Intent.EXTRA_TEXT," My name is  Anandita pursuing summer training of 45 days. ")
                startActivity(Intent.createChooser(intent,"Send Email"))
            }catch (exception:Exception){
                Toast.makeText(this,"Email failed",Toast.LENGTH_LONG).show()
            }
        }



        }


    }
