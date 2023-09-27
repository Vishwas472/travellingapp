package com.example

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.travllingapp.Modelclass.Fulldatamodelclass
import com.example.travllingapp.R
import com.example.travllingapp.databinding.ActivityDesrtBinding
import com.example.travllingapp.databinding.ActivityTajBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.UUID

class TajActivity : AppCompatActivity() {
    lateinit var binding: ActivityTajBinding
    private val PICK_IMAGE_REQUEST = 100
    lateinit var uri: Uri
    lateinit var ImageUri: Uri
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTajBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()    }

    private fun initview() {
        var reference = FirebaseDatabase.getInstance().reference

        binding.btnselectimag.setOnClickListener {


            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(
                    intent,
                    "Select Image from here..."
                ),
                PICK_IMAGE_REQUEST
            )

            binding.BtnAdd.setOnClickListener {
                var palce = binding.edtPlace.text.toString()
                var city = binding.edtCity.text.toString()
                var Day = binding.edtnumber.text.toString()
                var People = binding.edtemail.text.toString()
                var price = binding.edtprice.text.toString()
                var Discription = binding.edtdescription.text.toString()
                var Rating = binding.edtrate.text.toString()

                var key = reference.root.child("TAjtb").push().key ?: ""

                var modelClass = Fulldatamodelclass(
                    palce,
                    People,
                    Day,
                    Discription,
                    city,
                    price,
                    Rating,
                    key, ImageUri
                )

                reference.root.child("TAjtb").child(key).setValue(modelClass)
                    .addOnCompleteListener {

                        if (it.isSuccessful) {
                            Toast.makeText(this, "Data Add Succesfully", Toast.LENGTH_SHORT).show()
                        }
                    }.addOnFailureListener { Log.e("TAG", "Error: " + it) }

            }


        }
    }
    fun uploadImage() {
        if (uri != null) {

            // Code for showing progressDialog while uploading
            val progressDialog = ProgressDialog(this)
            progressDialog.setTitle("Uploading...")
            progressDialog.show()

            // Defining the child of storageReference
            val ref: StorageReference = FirebaseStorage.getInstance().getReference()
                .child("images/" + UUID.randomUUID().toString())

            // adding listeners on upload
            // or failure of image
            if (ref != null) {
                ref.putFile(uri).continueWith {

                    ref.downloadUrl.addOnCompleteListener {
                        ImageUri = it.result
                    }


                }

                    .addOnSuccessListener { // Image uploaded successfully
                        // Dismiss dialog
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@TajActivity,
                                "Image Uploaded!!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                    .addOnFailureListener { e -> // Error, Image not uploaded
                        progressDialog.dismiss()
                        Toast
                            .makeText(
                                this@TajActivity,
                                "Failed " + e.message,
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }

            }
        }
    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )


        if (requestCode == PICK_IMAGE_REQUEST && resultCode == AppCompatActivity.RESULT_OK && data != null && data.data != null) {

            // Get the Uri of data
            uri = data.data!!
            uploadImage()

        }
    }

}