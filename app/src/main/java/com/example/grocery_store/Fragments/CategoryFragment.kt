package com.example.grocery_store.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.grocery_store.Controller.Category_Adapter
import com.example.grocery_store.R
import com.example.grocery_store.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    lateinit var binding: FragmentCategoryBinding
    var data = arrayOf(
        "Vegetables & Fruits",
        "Dairy &\nBread",
        "Munchies",
        "Cold Drinks\n& Juices",
        "Breakfast",
        "Tea ,Coffee",
        "Biscuits",
        "Sweets",
        "Atta,Rice &\nDal",
        "Masala,Oil\n& More",
        "Sauces &\nSpreads",
        "Pan\nCorner",
        "Organic &\nGourmet",
        "Baby Care",
        "Pharma &\n Wellness",
        "Cleaning\n Essentials",
        "Home &\nOffice",
        "Personal\nCare",
        "Pet Care",
        "Chocolates"

    )
    var images = arrayOf(
        R.drawable.mango,
        R.drawable.amul,
        R.drawable.munchies,
        R.drawable.cold,
        R.drawable.breakfast,
        R.drawable.coffee,
        R.drawable.biscuits,
        R.drawable.sweets,
        R.drawable.atta,
        R.drawable.oil,
        R.drawable.sauces,
        R.drawable.pan,
        R.drawable.organic,
        R.drawable.babycare,
        R.drawable.vicks2,
        R.drawable.cleaning,
        R.drawable.office,
        R.drawable.personalcare,
        R.drawable.petcare,
        R.drawable.chocolates,
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
        var layoutManager = GridLayoutManager(activity, 4)
        binding.rvView.layoutManager = layoutManager
        binding.rvView.adapter = adapter

    }

}
