package com.example.travllingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.travelapp.fragment.mytripsfragment
import com.example.travllingapp.databinding.ActivityHomepageBinding
import com.example.travllingapp.databinding.ActivitySignupBinding
import com.example.travllingapp.fragment.favruaitefargment
import com.example.travllingapp.fragment.homefragment
import com.example.travllingapp.fragment.myprofilefragmnet
import com.example.travllingapp.fragment.searchfragment

class homepageActivity : AppCompatActivity() {
    lateinit var binding : ActivityHomepageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initview()
    }

    private fun initview() {

        loadffragment(homefragment())

        binding.bottomview.setOnItemReselectedListener {
            if (it.itemId == R.id.home) {
                loadffragment(homefragment())
            } else if (it.itemId == R.id.Favouraite) {

                loadffragment(favruaitefargment())
            }
            else if (it.itemId == R.id.Myrips) {

                loadffragment(mytripsfragment())
            } else if (it.itemId == R.id.Profile) {

                loadffragment(myprofilefragmnet())
            }

        }
    }
    private fun loadffragment(fragment: Fragment) {


        val fragmenttransiction = supportFragmentManager.beginTransaction()
        fragmenttransiction.replace(R.id.containers, fragment)
        fragmenttransiction.commit()
    }

}