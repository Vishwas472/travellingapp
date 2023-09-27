package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.travllingapp.R
import com.example.travllingapp.databinding.ActivityDataaDisplayBinding

class DataaDisplay : AppCompatActivity() {
    lateinit var binding : ActivityDataaDisplayBinding
    lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityDataaDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()

    }

    private fun initview() {
        if (intent!=null) {

            var key = intent.getStringExtra("key").toString()
            var place = intent.getStringExtra("place").toString()
            var price = intent.getStringExtra("price").toString()
            var Day = intent.getStringExtra("Day").toString()
            var People = intent.getStringExtra("People").toString()
            var City = intent.getStringExtra("City").toString()
            var img = intent.getStringExtra("img").toString()

            binding.placename.text = place
            binding.people.text=People
            binding.Packege.text = Day
            binding.city.text = City
            binding.Price.text = price


            Glide.with(baseContext).load(img).into(binding.image)
        }
    }
}