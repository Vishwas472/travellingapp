package com.example.travllingapp.Modelclass

import android.net.Uri

class Fulldatamodelclass {
    var ImageUri: String=""
    var people: String=""
    var palce: String = ""
    var Day: String = ""
    var Discription: String = ""
    var city: String = ""
    var price: String = ""
    var Rating: String = ""
    var key: String = ""

    constructor(
        palce: String,
        people: String,
        Day: String,
        discription: String,
        city: String,
        price: String,
        rating: String,
        key: String,
        ImageUri: Uri,

        )
    {
        this.ImageUri = ImageUri.toString()
        this.palce = palce
        this.Day = Day
        this.Discription = discription
        this.key = key
        this.city =city
        this.price = price
        this.Rating = rating
        this.people = people

    }
    constructor() {

    }


}