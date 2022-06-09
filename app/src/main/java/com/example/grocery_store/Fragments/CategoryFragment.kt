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
        binding = FragmentCategoryBinding.inflate(layoutInflater)

        setupRecyclerView()
        return binding.root
    }

    fun setupRecyclerView() {
        var adapter = Category_Adapter(activity, data, images)
        var layoutManager = GridLayoutManager(activity,2)
        binding.rvView.layoutManager = layoutManager
        binding.rvView.adapter = adapter

    }

}
