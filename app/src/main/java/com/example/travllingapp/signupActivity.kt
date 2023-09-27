package com.example.travllingapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travllingapp.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class signupActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    lateinit var binding: ActivitySignupBinding
    val auth = Firebase.auth
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        val view = binding.root
        sharedPreferences= getSharedPreferences("MySharedpref", MODE_PRIVATE)
        setContentView(view)
        initview()

    }

    private fun initview() {
        binding.signup.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        var I = Intent(this, homepageActivity::class.java)
                        startActivity(I)
                        Toast.makeText(this, "Log in Succesfully", Toast.LENGTH_SHORT).show()
                        var myEdit: SharedPreferences.Editor = sharedPreferences.edit()
                        myEdit.putBoolean("isLogin", true)
                        myEdit.putString("email",binding.email.toString())
                        myEdit.commit()

                        finish()
                    } else {

                        Toast.makeText(this, "please enter 6 digits", Toast.LENGTH_SHORT).show()
                    }
                }

        }
        binding.signup.setOnClickListener{
            val intent = Intent(this, homepageActivity::class.java)
            startActivity(intent)
        }
        binding.signIn.setOnClickListener{
            val intent = Intent(this, CreatnewActivity::class.java)
            startActivity(intent)
        }


    }

}