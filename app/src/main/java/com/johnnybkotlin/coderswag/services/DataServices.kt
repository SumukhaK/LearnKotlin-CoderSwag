package com.johnnybkotlin.coderswag.services

import com.johnnybkotlin.coderswag.models.Category
import com.johnnybkotlin.coderswag.models.Product

object DataServices {

    val categories = listOf( Category("SHIRTS","shirtimage"),
        Category("HOODIES","hoodieimage"),
        Category("HATS","hatimage"),
        Category("DIGITAL","digitalgoodsimage"))

    val hats = listOf( Product("Devslopes Graphic Beanie","$18","hat1"),
        Product("Devslopes Hat black","$20","hat2"),
        Product("Devslopes Hat white","$21","hat3"),
        Product("Devslopes Hat Snapback","$19","hat4"))

    val hoodies = listOf( Product("Devslopes Hoodie Gray","$28","hoodie1"),
        Product("Devslopes Hoodie Red","$32","hoodie2"),
        Product("Devslopes Gray Hoodie ","$19","hoodie3"),
        Product("Devslopes Hoodie black","$20","hoodie4"))


    val shirts = listOf( Product("Devslopes Shirt Black","$18","shirt1"),
        Product("Devslopes Badge light Gray","$20","shirt2"),
        Product("Devslopes Logo Shirt Red ","$22","shirt3"),
        Product("Devslopes Hustle","$22","shirt4"),
        Product("Kickflip Studios","$18","shirt5"))

    val digitalProducts = listOf<Product>()


    fun getProducts(category:String) : List<Product>{

        return when(category){

            "SHIRTS" -> shirts
            "HATS" -> hats
            "HOODIES" -> hoodies
            else -> digitalProducts
        }

    }
}