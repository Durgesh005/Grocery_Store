package com.example.grocery_store.Controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocery_store.Home_Screen.OrdersDetailsActivity
import com.example.grocery_store.Modal_Data.DataBaseModal
import com.example.grocery_store.R

class DataShowAdapter(
    val ordersDetailsActivity: OrdersDetailsActivity,
    val l1: ArrayList<DataBaseModal>
) : RecyclerView.Adapter<DataShowAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(ordersDetailsActivity).inflate(R.layout.mycaart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var answer = l1[position].price

        holder.price.text = l1[position].price
        holder.productname.text = l1[position].name
        holder.quantity.text = l1[position].quantity

    }

    override fun getItemCount(): Int {
        return l1.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productname = itemView.findViewById<TextView>(R.id.NameProduct_txt)
        var quantity = itemView.findViewById<TextView>(R.id.Quantity_txt)
        var price = itemView.findViewById<TextView>(R.id.Price_txt)
    }
}