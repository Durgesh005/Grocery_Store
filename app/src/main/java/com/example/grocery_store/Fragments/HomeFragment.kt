package com.example.grocery_store.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocery_store.Controller.HomeAdapter
import com.example.grocery_store.Home_Screen.ViewCartActivity
import com.example.grocery_store.Modal_Data.ProductModalData
import com.example.grocery_store.R
import com.example.grocery_store.Utills.DBHelper
import com.example.grocery_store.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var list1 = ArrayList<ProductModalData>()
    var data = arrayOf(
        "Safeda Mango",
        "Banana",
        "Onion",
        "Cucumber",
        "Beetroot",
        "Apple",
        "Potato",
        "Ginger"


    )
    var images = arrayOf(
        R.drawable.vege,
        R.drawable.apple,
        R.drawable.amulp,
        R.drawable.amulp,
        R.drawable.amulp,
        R.drawable.amulp,
        R.drawable.amulp,
        R.drawable.amulp,


        )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        /*binding.carousel.registerLifecycle(lifecycle)*/

        var db = DBHelper(activity)
        setupRecyclerView()

        binding.addCartBtn.setOnClickListener {

            db.insertData(
                binding.orderIdEdt.text.toString(),
                binding.productNameEdt.text.toString(),
                binding.priceEdt.text.toString(),
            )
            var intent = Intent(activity, ViewCartActivity::class.java)

            startActivity(intent)

        }
        list1 = db.readData()


        return binding.root
    }

    fun setupRecyclerView() {
        var adapter = HomeAdapter(activity, data, images)
        var layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.productView.layoutManager = layoutManager
        binding.productView.adapter = adapter

        var adapter2 = HomeAdapter(activity, data, images)
        var layoutManager2 = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.productView.layoutManager = layoutManager2
        binding.productView.adapter = adapter2


    }


}