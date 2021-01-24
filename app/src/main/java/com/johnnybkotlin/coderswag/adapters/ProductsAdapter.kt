package com.johnnybkotlin.coderswag.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.johnnybkotlin.coderswag.R
import com.johnnybkotlin.coderswag.models.Product

class ProductsAdapter (val context : Context,val products: List<Product>, val itemClick: (Product) -> Unit) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    inner class ProductHolder(itemView: View,val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {

        val productName = itemView.findViewById<TextView>(R.id.productname_textview)
        val productPrice = itemView.findViewById<TextView>(R.id.productprice_textview)
        val productImage = itemView.findViewById<ImageView>(R.id.product_imageview)

        fun bindCategory(context:Context,product: Product){

            val resourceId = context.resources.getIdentifier(product.image,"drawable",context.packageName)
            productImage.setImageResource(resourceId)

            productName.text = product.title
            productPrice.text = product.price
            itemView.setOnClickListener { (itemClick(product))}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_products_listitem,parent,false)
        return ProductHolder(view,itemClick)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindCategory(context,products.get(position))
    }

    override fun getItemCount(): Int {
        return products.count()
    }

}