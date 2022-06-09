package com.example.grocery_store.Controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grocery_store.Home_Screen.ViewCartActivity
import com.example.grocery_store.Modal_Data.ProductModalData
import com.example.grocery_store.R
import org.w3c.dom.Text

class ViewCartAdapter(val viewCartActivity: ViewCartActivity, val l1: ArrayList<ProductModalData>) :
    RecyclerView.Adapter<ViewCartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(viewCartActivity).inflate(R.layout.view_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = l1[position].id
        holder.name.text = l1[position].product
        holder.price.text = l1[position].price
    }

    override fun getItemCount(): Int {
        return l1.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var id = itemView.findViewById<TextView>(R.id.order_id_txt)
        var name = itemView.findViewById<TextView>(R.id.product_name_txt)
        var price = itemView.findViewById<TextView>(R.id.price_txt)

    }


}