package com.example.travllingapp.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.DesrtActivity
import com.example.FulldataActivity
import com.example.TajActivity
import com.example.forestActivty
import com.example.travllingapp.databinding.FragmentMyprofilefragmnetBinding
import com.example.travllingapp.profileactivity
import com.example.travllingapp.signupActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class myprofilefragmnet : Fragment() {


    lateinit var bindding: FragmentMyprofilefragmnetBinding
    lateinit var sharedPreferences: SharedPreferences
    val auth = Firebase.auth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindding = FragmentMyprofilefragmnetBinding.inflate(inflater, container, false)
        sharedPreferences= requireActivity().getSharedPreferences("MySharedpref", AppCompatActivity.MODE_PRIVATE)
        bindding.btnadmin.setOnClickListener {
            val intent = Intent(requireContext(), profileactivity::class.java)
            startActivity(intent)


        }

        initView()

        return bindding.root



    }

    private fun initView() {


        bindding.btnBeachData.setOnClickListener {
            val i = Intent(requireContext(),FulldataActivity :: class.java)
            startActivity(i)

        }
        bindding.DsrtData.setOnClickListener {
            val i = Intent(requireContext(),DesrtActivity :: class.java)
            startActivity(i)

        }
        bindding.Forest.setOnClickListener {
            val i = Intent(requireContext(),forestActivty :: class.java)
            startActivity(i)

        }
        bindding.Taj.setOnClickListener {
            val i = Intent(requireContext(),TajActivity:: class.java)
            startActivity(i)

        }
        bindding.btnLogOut.setOnClickListener {

            var myEdit: SharedPreferences.Editor = sharedPreferences.edit()
            myEdit.remove("isLogin")
            myEdit.commit()
            auth.signOut()
            var intent = Intent(context, signupActivity::class.java)
            Toast.makeText(context, "Successfully Logged Out", Toast.LENGTH_SHORT).show()
            startActivity(intent)

        }
    }


}