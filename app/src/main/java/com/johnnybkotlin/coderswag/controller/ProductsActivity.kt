package com.johnnybkotlin.coderswag.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)

        categoryname_textview.text = categoryType
    }
}