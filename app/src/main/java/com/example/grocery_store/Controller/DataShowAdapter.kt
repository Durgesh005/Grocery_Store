package com.example.grocery_store.Controller

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocery_store.Home_Screen.OrdersDetailsActivity
import com.example.grocery_store.Home_Screen.OrdersDetailsActivity.Companion.binding
import com.example.grocery_store.Modal_Data.DataBaseModal
import com.example.grocery_store.R
import com.example.grocery_store.Utills.DBHelper

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
        holder.edit.setOnClickListener {
            editdialog(position)
        }

    }

    override fun getItemCount(): Int {
        return l1.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var productname = itemView.findViewById<TextView>(R.id.NameProduct_txt)
        var quantity = itemView.findViewById<TextView>(R.id.Quantity_txt)
        var price = itemView.findViewById<TextView>(R.id.Price_txt)
        var edit = itemView.findViewById<ImageView>(R.id.edit_btn)
    }

    fun editdialog(position: Int) {
        var update_dialog = Dialog(ordersDetailsActivity)
        update_dialog.setContentView(R.layout.dialog4)
        update_dialog.show()
        update_dialog.setCancelable(true)
        var update = update_dialog.findViewById<Button>(R.id.update_btn)
        var delete = update_dialog.findViewById<Button>(R.id.delete_btn)


        update.setOnClickListener {
            var update_dialog = Dialog(ordersDetailsActivity)
            update_dialog.setContentView(R.layout.update_dialog)
            update_dialog.show()

            var product_name = update_dialog.findViewById<TextView>(R.id.NameProduct_txt)
            var pricetxt = update_dialog.findViewById<TextView>(R.id.Price_txt)
            var Quentity = update_dialog.findViewById<TextView>(R.id.Quantity_txt)
            var dialog_update_btn = update_dialog.findViewById<Button>(R.id.dialog_update_btn)


            Quentity.setText("" + l1[position].quantity)
            pricetxt.setText("" + l1[position].price)

            dialog_update_btn.setOnClickListener {


                /*  DBHelper(ordersDetailsActivity).updateData(
                      l1[position].price,
                  )*/
                var l1 = DBHelper(ordersDetailsActivity).readData()
                setupRecyclerView(l1)

                Toast.makeText(
                    ordersDetailsActivity,
                    "Item Updated Successfully",
                    Toast.LENGTH_LONG
                ).show()

                update_dialog.dismiss()
            }
        }

        delete.setOnClickListener {
            DBHelper(ordersDetailsActivity).deleteData(l1[position].price)
            var l1 = DBHelper(ordersDetailsActivity).readData()
            setupRecyclerView(l1)
            Toast.makeText(ordersDetailsActivity, "Item Deleted Successfully", Toast.LENGTH_LONG)
                .show()
            update_dialog.dismiss()


        }

    }

    fun setupRecyclerView(l1: ArrayList<DataBaseModal>) {

        var adapter = DataShowAdapter(ordersDetailsActivity, l1)
        var layoutManager = LinearLayoutManager(ordersDetailsActivity)
        binding.MyCartView.layoutManager = layoutManager
        binding.MyCartView.adapter = adapter

    }
}