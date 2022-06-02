package com.example.grocery_store.Controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.grocery_store.R


class Category_Adapter(
    val factivity: FragmentActivity?,
    val data: Array<String>,
    val images: Array<Int>
) : RecyclerView.Adapter<Category_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(factivity).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.product.text = data[position]
        holder.photos.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photos = itemView.findViewById<ImageView>(R.id.icon_btn)
        var product = itemView.findViewById<TextView>(R.id.product_txt)
    }
}

