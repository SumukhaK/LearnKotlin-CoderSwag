package com.johnnybkotlin.coderswag.controller

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.adapters.ProductsAdapter
import com.johnnybkotlin.coderswag.services.DataServices
import com.johnnybkotlin.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        categoryname_textview.text = categoryType

        var spanCount = 2
        val orientation = resources.configuration.orientation
        if(orientation == Configuration.ORIENTATION_LANDSCAPE || resources.configuration.screenWidthDp>720){

            spanCount = 3
        }

        Log.d("Products orientation "," orientation : "+orientation+" spanCount : "+spanCount)

        val layoutManager = GridLayoutManager(this,spanCount)
        products_recyclerview.layoutManager = layoutManager
        productsAdapter = ProductsAdapter(this,DataServices.getProducts(categoryType.toString())){


        }
        products_recyclerview.adapter = productsAdapter
    }
}