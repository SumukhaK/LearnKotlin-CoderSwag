package com.johnnybkotlin.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.models.Category

class CategoryAdapter(context: Context,categories: List<Category>) : BaseAdapter() {

    val context = context
    val categories = categories

    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return  categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0;
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView:View

        categoryView = LayoutInflater.from(context).inflate(R.layout.row_category_listitem,null)

        val categoryImage :ImageView = categoryView.findViewById(R.id.categoryimage)
        val categoryName : TextView = categoryView.findViewById(R.id.categorytextView)
        val category = categories[position]
        categoryName.setText(category.title)

        val resourceid = context.resources.getIdentifier(category.image,"drawable",context.packageName)
        categoryImage.setImageResource(resourceid)

        return categoryView
    }


}