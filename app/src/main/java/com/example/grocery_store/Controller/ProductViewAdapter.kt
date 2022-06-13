package com.example.grocery_store.Controller

import android.app.Dialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.grocery_store.Controller.ProductViewAdapter.*
import com.example.grocery_store.Home_Screen.OrdersDetailsActivity
import com.example.grocery_store.Home_Screen.ViewCartActivity
import com.example.grocery_store.Modal_Data.DataBaseModal
import com.example.grocery_store.Modal_Data.ProductModalData
import com.example.grocery_store.R
import com.example.grocery_store.Utills.DBHelper
import com.google.android.material.bottomsheet.BottomSheetDialog

class ProductViewAdapter(
    val CartActivity: ViewCartActivity,
    val data: Array<String>,
    val photos: Array<Int>,
    val price: Array<Int>,
    val quantity: Array<Int>
) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view = LayoutInflater.from(CartActivity)
            .inflate(R.layout.product_show_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var l1 = ArrayList<DataBaseModal>()
        var db = DBHelper(CartActivity)
        holder.product.text = data[position]
        holder.photos.setImageResource(photos[position])
        holder.price1.setText("" + price[position])

        holder.add.setOnClickListener {
            db.insertData(data[position], quantity[position], price[position])
            l1 = db.readData()
            opendialog()
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var product = itemView.findViewById<TextView>(R.id.name_txt)
        var photos = itemView.findViewById<ImageView>(R.id.photos_btn)
        var add = itemView.findViewById<CardView>(R.id.data_add_btn)
        var price1 = itemView.findViewById<TextView>(R.id.item_price)
        var qu = itemView.findViewById<TextView>(R.id.item_weight)
    }


    fun opendialog() {
        var dialog = BottomSheetDialog(CartActivity)
        dialog.setContentView(R.layout.dialog)
        dialog.show()
        dialog.setCancelable(true)

        var ViewCart = dialog.findViewById<TextView>(R.id.view_cart)

        ViewCart!!.setOnClickListener {
            val intent = Intent(CartActivity, OrdersDetailsActivity::class.java)
            CartActivity.startActivity(intent)
        }

    }

}