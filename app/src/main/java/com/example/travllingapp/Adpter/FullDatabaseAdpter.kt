package com.example.travllingapp.Adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.DsiplayActivty
import com.example.travllingapp.Modelclass.Fulldatamodelclass
import com.example.travllingapp.R

class FullDatabaseAdpter(var dsiplayActivty: DsiplayActivty, var list: ArrayList<Fulldatamodelclass>,
                         var onItemClick :(place : String,price : String,Day : String,People : String,City : String,img : String,key: String) ->Unit  ):

    RecyclerView.Adapter<FullDatabaseAdpter.Myviewholder>() {
    class Myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Email: TextView = itemView.findViewById(R.id.txtemail)
        var price: TextView = itemView.findViewById(R.id.txtprice)
        var Day: TextView = itemView.findViewById(R.id.txtDay)
        var People: TextView = itemView.findViewById(R.id.txtpeople)
        var City: TextView = itemView.findViewById(R.id.txtcity)
        var img: ImageView = itemView.findViewById(R.id.img_beach)
        var Book_beach: AppCompatButton = itemView.findViewById(R.id.Book_beach)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        var View = LayoutInflater.from(parent.context)
            .inflate(R.layout.display_data_item_file, parent, false)
        return Myviewholder(View)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        holder.Email.text = list[position].palce
        holder.price.text = list[position].price
        holder.Day.text = list[position].Day
        holder.People.text=list[position].people
        holder.City.text=list[position].city


        Glide.with(dsiplayActivty).load(list[position].ImageUri).into(holder.img)

        holder.Book_beach.setOnClickListener {
            onItemClick.invoke(
                list[position].palce,
                list[position].price,
                list[position].Day,
                list[position].people,
                list[position].city,
                list[position].ImageUri,
                list[position].key,
            )
        }
    }

    override fun getItemCount(): Int {

        return list.size
    }

}