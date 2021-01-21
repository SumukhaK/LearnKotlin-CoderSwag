package com.johnnybkotlin.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.adapters.CategoryAdapter
import com.johnnybkotlin.coderswag.models.Category
import com.johnnybkotlin.coderswag.services.DataServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>
    lateinit var customAdapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //adapter = ArrayAdapter(this@MainActivity,android.R.layout.simple_list_item_1,DataServices.categories)
        customAdapter = CategoryAdapter(this@MainActivity,DataServices.categories)

        //categorylistview.adapter = adapter
        categorylistview.adapter = customAdapter

    }
}