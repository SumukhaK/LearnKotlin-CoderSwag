package com.johnnybkotlin.coderswag.controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.adapters.CategoryAdapter
import com.johnnybkotlin.coderswag.adapters.CategoryRecylerAdapter
import com.johnnybkotlin.coderswag.models.Category
import com.johnnybkotlin.coderswag.services.DataServices
import com.johnnybkotlin.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var categoryRecAdapter : CategoryRecylerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        categorylistview.layoutManager = layoutManager
        categoryRecAdapter = CategoryRecylerAdapter(this,DataServices.categories){
                category ->
            //Toast.makeText(this@MainActivity," Selected category : ${category.title}",Toast.LENGTH_LONG).show()
            val intent = Intent(this@MainActivity,ProductsActivity::class.java)
            intent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(intent)
        }

        categorylistview.adapter = categoryRecAdapter


    }
}
