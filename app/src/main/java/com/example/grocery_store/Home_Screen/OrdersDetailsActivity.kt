package com.example.grocery_store.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocery_store.Controller.DataShowAdapter
import com.example.grocery_store.Modal_Data.DataBaseModal
import com.example.grocery_store.Utills.DBHelper
import com.example.grocery_store.databinding.ActivityOrdersDetailsBinding

class OrdersDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityOrdersDetailsBinding
    var list1 = ArrayList<DataBaseModal>()
    var total: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdersDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.backArrow.setOnClickListener {
            onBackPressed()
        }

        var db = DBHelper(this)
        list1 = db.readData()
        setupRecyclerView(list1)

        var i = 0
        while (i < list1.size) {
            var sum = list1[i].price.toInt()
            i++
            total = total + sum
        }

        binding.totalAmountTxt.text = total.toString()
        var final = total - 70

        binding.finalTotalTxt.text = final.toString()
        Toast.makeText(this, "View Cart", Toast.LENGTH_SHORT).show()
    }

    fun setupRecyclerView(l1: ArrayList<DataBaseModal>) {

        var adapter = DataShowAdapter(this, l1)
        var layoutManager = LinearLayoutManager(this)
        binding.MyCartView.layoutManager = layoutManager
        binding.MyCartView.adapter = adapter


    }
}