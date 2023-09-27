package com.example

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travllingapp.Adpter.FullDatabaseAdpter
import com.example.travllingapp.Modelclass.Fulldatamodelclass
import com.example.travllingapp.Modelclass.Modelclassdatabase
import com.example.travllingapp.databinding.ActivityDsiplayActivtyBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

private fun <E> ArrayList<E>.add(element: Modelclassdatabase) {

}

class DsiplayActivty : AppCompatActivity() {
    lateinit var binding: ActivityDsiplayActivtyBinding
    var reference = FirebaseDatabase.getInstance().reference
    lateinit var placename: String

    var list = ArrayList<Fulldatamodelclass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDsiplayActivtyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initview()
    }

    private fun initview() {

        if (intent!=null)

        {
            placename=intent.getStringExtra("Beach").toString()
            binding.txttltle.text=placename
            if (placename=="Beaches")
            {
                beaches()
            }
            else if (placename=="Desrt")
            {
                Desrt()
            }
            else if (placename=="Forest")
            {
                Forest()
            }
            else if (placename=="Taj")
            {
                Taj()
            }
        }



    }

    private fun Taj() {
        reference.root.child("TAjtb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: Fulldatamodelclass? = child.getValue(Fulldatamodelclass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = FullDatabaseAdpter(this@DsiplayActivty, list, onItemClick = {
                    place: String,
                    price: String,
                    Day: String,
                    People: String,
                    City: String,
                    img: String,
                    key: String ->

                    var i = Intent(this@DsiplayActivty,DataaDisplay:: class.java)
                    i.putExtra("place",place)
                    i.putExtra("price",price)
                    i.putExtra("Day",Day)
                    i.putExtra("People",People)
                    i.putExtra("City",City)
                    i.putExtra("img",img)
                    i.putExtra("key",key)

                    startActivity(i)

                })
                var manager =
                    LinearLayoutManager(this@DsiplayActivty, LinearLayoutManager.VERTICAL, false)
                binding?.rcv?.layoutManager = manager
                binding.rcv.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun Forest() {
        reference.root.child("Foresttb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: Fulldatamodelclass? = child.getValue(Fulldatamodelclass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = FullDatabaseAdpter(this@DsiplayActivty, list, onItemClick = {
                        place: String,
                        price: String,
                        Day: String,
                        People: String,
                        City: String,
                        img: String,
                        key: String ->

                    var i = Intent(this@DsiplayActivty,DataaDisplay:: class.java)
                    i.putExtra("place",place)
                    i.putExtra("price",price)
                    i.putExtra("Day",Day)
                    i.putExtra("People",People)
                    i.putExtra("City",City)
                    i.putExtra("img",img)
                    i.putExtra("key",key)

                    startActivity(i)

                })
                var manager =
                    LinearLayoutManager(this@DsiplayActivty, LinearLayoutManager.VERTICAL, false)
                binding?.rcv?.layoutManager = manager
                binding.rcv.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun Desrt() {
        reference.root.child("DesrtTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: Fulldatamodelclass? = child.getValue(Fulldatamodelclass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = FullDatabaseAdpter(this@DsiplayActivty, list, onItemClick = {
                        place: String,
                        price: String,
                        Day: String,
                        People: String,
                        City: String,
                        img: String,
                        key: String ->

                    var i = Intent(this@DsiplayActivty,DataaDisplay:: class.java)
                    i.putExtra("place",place)
                    i.putExtra("price",price)
                    i.putExtra("Day",Day)
                    i.putExtra("People",People)
                    i.putExtra("City",City)
                    i.putExtra("img",img)
                    i.putExtra("key",key)

                    startActivity(i)

                })
                var manager =
                    LinearLayoutManager(this@DsiplayActivty, LinearLayoutManager.VERTICAL, false)
                binding?.rcv?.layoutManager = manager
                binding.rcv.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun beaches() {
        reference.root.child("FullDatatb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: Fulldatamodelclass? = child.getValue(Fulldatamodelclass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = FullDatabaseAdpter(this@DsiplayActivty, list, onItemClick = {
                        place: String,
                        price: String,
                        Day: String,
                        People: String,
                        City: String,
                        img: String,
                        key: String ->

                    var i = Intent(this@DsiplayActivty,DataaDisplay:: class.java)
                    i.putExtra("place",place)
                    i.putExtra("price",price)
                    i.putExtra("Day",Day)
                    i.putExtra("People",People)
                    i.putExtra("City",City)
                    i.putExtra("img",img)
                    i.putExtra("key",key)

                    startActivity(i)

                })
                var manager =
                    LinearLayoutManager(this@DsiplayActivty, LinearLayoutManager.VERTICAL, false)
                binding?.rcv?.layoutManager = manager
                binding.rcv.adapter = adpter

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}