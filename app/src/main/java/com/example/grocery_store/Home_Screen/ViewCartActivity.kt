package com.example.grocery_store.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocery_store.Controller.ProductViewAdapter
import com.example.grocery_store.Controller.ViewCartAdapter
import com.example.grocery_store.Modal_Data.ProductModalData
import com.example.grocery_store.R
import com.example.grocery_store.databinding.ActivityViewCartBinding

class ViewCartActivity : AppCompatActivity() {

    lateinit var binding: ActivityViewCartBinding
    var list1 = ArrayList<ProductModalData>()
    var data = arrayOf(
        "Vegetables & Fruits",
        "Dairy & Bread",
        "Munchies",
        "Cold Drinks & Juices",
        "Breakfast",
        "Tea ,Coffee",
        "Biscuits",
        "Sweets",
        "Atta,Rice & Dal",
        "Masala,Oil & More",
        "Sauces & Spreads",
        "Pan Corner",
        "Organic & Gourmet",
        "Baby Care",
        "Pharma & Wellness",
        "Cleaning Essentials",
        "Home & Office",
        "Personal Care",
        "Pet Care",
        "Chocolates"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            onBackPressed()
        }
        val cat = intent.getStringExtra("n1")
        binding.headingTxt.text = cat

        viewMaker(cat)

    }


    fun setupRecyclerView(l1: ArrayList<ProductModalData>) {

        var adapter = ViewCartAdapter(this, l1)
        var layoutManager = LinearLayoutManager(this)
        binding.cartRvView.layoutManager = layoutManager
        binding.cartRvView.adapter = adapter

    }

    fun viewMaker(cat: String?) {

        if (cat.equals(data[0])) {
            var names = arrayOf(
                "Kesar Mango",
                "Apple",
                "Banana",
                "Sweet Lime",
                "Watermelon",
                "Kiwi",
                "Dragon Fruit",
                "Pineapple"

            )
            var photos = arrayOf(
                R.drawable.mango,
                R.drawable.apple,
                R.drawable.banana,
                R.drawable.sweetlime,
                R.drawable.watermelon,
                R.drawable.kiwi,
                R.drawable.dragon,
                R.drawable.pinepapple
            )
            var price = arrayOf(270, 120, 100, 157, 140, 110, 170, 190, 135)
            var quantity = arrayOf(1, 2, 4, 1, 1, 2, 5, 1)

            var adapter1 = ProductViewAdapter(this, names, photos, price, quantity)
            var layoutManager = GridLayoutManager(this, 2)
            binding.cartRvView.layoutManager = layoutManager
            binding.cartRvView.adapter = adapter1
        }
    }


}