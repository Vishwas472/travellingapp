package com.example.travllingapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travllingapp.databinding.ActivityCreatnewBinding
import com.example.travllingapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreatnewActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivityCreatnewBinding
    val auth = Firebase.auth
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatnewBinding.inflate(layoutInflater)
        val view = binding.root
        sharedPreferences= getSharedPreferences("MySharedpref", MODE_PRIVATE)

        setContentView(view)
        initview()
    }

    private fun initview() {
        binding.signin.setOnClickListener {
            auth.createUserWithEmailAndPassword(binding.email.text.toString(),binding.password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.e("TAG", "initview: "+task )
                        Toast.makeText(this, "Add Succesfully", Toast.LENGTH_SHORT).show()
                        var myEdit: SharedPreferences.Editor = sharedPreferences.edit()
                        myEdit.putBoolean("isLogin", true)
                        myEdit.commit()
                        var intent = Intent(this, homepageActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {

                        Toast.makeText(this, "please enter 6 digits", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        binding.signup.setOnClickListener{
            val i = Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
        }

    }
}