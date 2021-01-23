package com.johnnybkotlin.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.models.Category

class CategoryRecylerAdapter (val context: Context, val categories: List<Category>): RecyclerView.Adapter<CategoryRecylerAdapter.Holder>() {



    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val catergoryImage = itemView.findViewById<ImageView>(R.id.categoryimage)
        val catergoryName = itemView.findViewById<TextView>(R.id.categorytextView)

        fun bindCategory(context:Context,category: Category){

            val resourceId = context.resources.getIdentifier(category.image,"drawable",context.packageName)
            catergoryImage.setImageResource(resourceId)

            catergoryName.text = category.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val view = LayoutInflater.from(context).inflate(R.layout.row_category_listitem,parent,false)
        return Holder(view)

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(context,categories.get(position))
    }

    override fun getItemCount(): Int {

        return categories.count()
    }
}