package com.example.travllingapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    lateinit var btnsignup: AppCompatButton
    lateinit var Creatnew: AppCompatButton
    lateinit var Skip: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initview()

    }

    private fun initview() {
        btnsignup = findViewById(R.id.btnsignup)
        Creatnew = findViewById(R.id.Creatnew)
        Skip = findViewById(R.id.Skip)
        btnsignup.setOnClickListener {
            val i = Intent(applicationContext, signupActivity::class.java)
            startActivity(i)
        }
        Creatnew.setOnClickListener{
            val i = Intent(applicationContext, CreatnewActivity::class.java)
            startActivity(i)
        }
        Skip.setOnClickListener{
            val i = Intent(applicationContext,homepageActivity::class.java)
            startActivity(i)
        }
    }

}