package com.example.grocery_store.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocery_store.Controller.ViewCartAdapter
import com.example.grocery_store.Modal_Data.ProductModalData
import com.example.grocery_store.Utills.DBHelper
import com.example.grocery_store.databinding.ActivityViewCartBinding

class ViewCartActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewCartBinding
    var list1 = ArrayList<ProductModalData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = DBHelper(this)
        list1 = db.readData()
        setupRecyclerView(list1)

    }

    fun setupRecyclerView(l1: ArrayList<ProductModalData>) {

        var adapter = ViewCartAdapter(this, l1)
        var layoutManager = LinearLayoutManager(this)
        binding.cartRvView.layoutManager = layoutManager
        binding.cartRvView.adapter = adapter

    }
}