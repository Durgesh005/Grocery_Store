package com.example.grocery_store.Controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.grocery_store.Modal_Data.DataBaseModal
import com.example.grocery_store.R
import com.example.grocery_store.Utills.DBHelper

class HomeAdapter(
    val activity: FragmentActivity?,
    val data: Array<String>,
    val images: Array<Int>,
    val quantity: Array<Int>,
    val price: Array<Int>,

    ) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(activity).inflate(R.layout.allproducts, parent, false)
        return HomeAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var l1 = ArrayList<DataBaseModal>()
        var db = DBHelper(activity)
        holder.product.text = data[position]
        holder.photos.setImageResource(images[position])
        holder.price.text = ("" + price[position])


        holder.add.setOnClickListener {
            db.insertData(data[position], quantity[position], price[position])
            l1 = db.readData()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photos = itemView.findViewById<ImageView>(R.id.images_btn)
        var product = itemView.findViewById<TextView>(R.id.item_name)
        var price = itemView.findViewById<TextView>(R.id.item_price)
        var add = itemView.findViewById<CardView>(R.id.add_product_btn)
    }
}