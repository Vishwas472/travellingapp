package com.example.travllingapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.DsiplayActivty
import com.example.HomedispalyActivity
import com.example.travllingapp.Adpter.MyAdpter
import com.example.travllingapp.Modelclass.Modelclassdatabase
import com.example.travllingapp.databinding.FragmentHomefragmentBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class homefragment : Fragment() {

    private var bbinding: FragmentHomefragmentBinding? = null
    val imageList = ArrayList<SlideModel>()
    lateinit var imageSlider: ImageSlider
    lateinit var palcename : String
    private val binding get() = bbinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bbinding = FragmentHomefragmentBinding.inflate(inflater, container, false)
        val view = binding?.root
        var refrence = FirebaseDatabase.getInstance().reference
        var list = ArrayList<Modelclassdatabase>()

        initview()


            refrence.root.child("MapTb").addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (child in snapshot.children) {
                        var data: Modelclassdatabase? =
                            child.getValue(Modelclassdatabase::class.java)
                        if (data != null) {
                            list.add(data)
                        }
                    }
                    var adpter = MyAdpter(this@homefragment, list , Onitemclick = {
                        place: String, price: String, img: String, key: String ->

                        var i = Intent(context,HomedispalyActivity::class.java)
                        i.putExtra("place",place)
                        i.putExtra("price",price)
                        i.putExtra("img",img)
                        i.putExtra("key",key)
                        startActivity(i)
                    })

                    var manager =
                        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    binding?.rcv?.layoutManager = manager
                    binding?.rcv?.adapter = adpter
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })



        return view
    }

    private fun initview() {


        bbinding?.beatches?.setOnClickListener {
            val intent = Intent(requireActivity().application, DsiplayActivty::class.java)
            intent.putExtra("Beach", "Beaches")
            startActivity(intent)


        }

        bbinding?.Desrt?.setOnClickListener {
            val intent = Intent(requireActivity().application, DsiplayActivty::class.java)
            intent.putExtra("Beach", "Desrt")
            startActivity(intent)

            bbinding?.Forest?.setOnClickListener {
                val intent = Intent(requireActivity().application, DsiplayActivty::class.java)
                intent.putExtra("Beach", "Forest")
                startActivity(intent)
            }
            bbinding?.Taj?.setOnClickListener {
                val intent = Intent(requireActivity().application, DsiplayActivty::class.java)
                intent.putExtra("Beach", "Taj")
                startActivity(intent)
            }

        }
    }

}