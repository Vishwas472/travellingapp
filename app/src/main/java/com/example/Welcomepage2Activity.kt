package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import com.example.travllingapp.MainActivity
import com.example.travllingapp.R
import com.example.travllingapp.databinding.ActivityFulldataBinding
import com.example.travllingapp.databinding.ActivityWelcomepage2Binding
import com.example.travllingapp.homepageActivity

class Welcomepage2Activity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomepage2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomepage2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

       binding.next.setOnClickListener{
            val intent = Intent(this, WelcomePageActivity::class.java)
            startActivity(intent)
        }
       binding.start.setOnClickListener{
            val intent = Intent(this, homepageActivity::class.java)
            startActivity(intent)
        }
    }
}