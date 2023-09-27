package com.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.travllingapp.R
import com.example.travllingapp.databinding.ActivityDesrtBinding
import com.example.travllingapp.databinding.ActivityHomedispalyBinding

class HomedispalyActivity : AppCompatActivity() {
    lateinit var bindding :ActivityHomedispalyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindding = ActivityHomedispalyBinding.inflate(layoutInflater)
        setContentView(bindding.root)
        initview()
    }

    private fun initview() {
        if(intent!= null)
        {
            var place = intent.getStringExtra("place").toString()
            var price = intent.getStringExtra("place").toString()
            var img = intent.getStringExtra("img").toString()
            var key = intent.getStringExtra("key").toString()

            bindding.palce.text=place
            bindding.price.text=price

            Glide.with(baseContext).load(img).into(bindding.img)

        }

    }
}