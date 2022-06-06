package com.example.grocery_store.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocery_store.Controller.Category_Adapter
import com.example.grocery_store.R
import com.example.grocery_store.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    lateinit var binding: FragmentCategoryBinding

    var data = arrayOf(
        "Vegetables",
        "Dairy",
        "Munchies",
        "Cold Drinks",
        "Breakfast",
        "Tea & Coffee",
        "Bakery",
        "Sweet Tooth"


    )
    var images = arrayOf(
        R.drawable.tide,
        R.drawable.product1,
        R.drawable.product1,
        R.drawable.product1,
        R.drawable.product1,
        R.drawable.product1,
        R.drawable.product1,
        R.drawable.product1,


        )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoryBinding.inflate(layoutInflater)

        setupRecyclerView()
        return binding.root
    }

    fun setupRecyclerView() {
        var adapter = Category_Adapter(activity, data, images)
        var layoutManager = LinearLayoutManager(activity)
        binding.rvView.layoutManager = layoutManager
        binding.rvView.adapter = adapter

    }

}
