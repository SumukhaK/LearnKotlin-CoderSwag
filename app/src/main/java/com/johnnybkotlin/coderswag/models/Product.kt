package com.johnnybkotlin.coderswag.models

class Product constructor(val title:String, val price:String, val image:String) {

    override fun toString(): String {
        return "Product(title='$title', price='$price', image='$image')"
    }
}