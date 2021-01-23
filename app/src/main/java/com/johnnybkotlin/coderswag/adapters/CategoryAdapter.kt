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
        val holder: ViewHolder

        if(convertView == null) {
            categoryView =
                LayoutInflater.from(context).inflate(R.layout.row_category_listitem, null)
            holder = ViewHolder()
            holder.categoryImage = categoryView.findViewById(R.id.categoryimage)
            holder.categoryName = categoryView.findViewById(R.id.categorytextView)
            categoryView.tag = holder
        }else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        holder.categoryName?.text=category.title

        val resourceid =
            context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceid)
        return categoryView
    }



    private class ViewHolder{

        var categoryImage : ImageView ?= null
        var categoryName : TextView ?= null

    }

}