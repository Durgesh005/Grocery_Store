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
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var list1 = ArrayList<ProductModalData>()
    val list = mutableListOf<CarouselItem>()
    var data =
        arrayOf("Mango", "Banana", "Apple", "Tomato", "Beetroot", "Onion", "Potato", "Ginger")
    var images = arrayOf(
        R.drawable.mango,
        R.drawable.banana,
        R.drawable.tomato,
        R.drawable.beetroot,
        R.drawable.onion,
        R.drawable.potato,
        R.drawable.ginger,
        R.drawable.ginger
    )
    var price = arrayOf(270, 120, 100, 157, 140, 110, 170, 190, 135)
    var quantity = arrayOf(1, 2, 4, 1, 1, 2, 5, 1)
    var data2 = arrayOf(
        "Appy Fizz",
        "Thunshup",
        "Sprite",
        "Pepsi",
        "7UP Drink",
        "Cocacola",
        "Limaca",
        "Kinley Soda"
    )
    var images2 = arrayOf(
        R.drawable.appy,
        R.drawable.thumsup1,
        R.drawable.thumsup,
        R.drawable.pespi,
        R.drawable.up,
        R.drawable.cold,
        R.drawable.limaca,
        R.drawable.kinley
    )
    var price2 = arrayOf(70, 80, 65, 85, 45, 90, 38, 22)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        /*binding.carousel.registerLifecycle(lifecycle)*/

        var db = DBHelper(activity)
        setupRecyclerView()

        binding.addCartBtn.setOnClickListener {


            var intent = Intent(activity, ViewCartActivity::class.java)

            startActivity(intent)

        }
        /*list1 = db.readData()*/


        list.add(
            CarouselItem(
                imageDrawable = R.drawable.lays
            )
        )


        list.add(
            CarouselItem(
                imageDrawable = R.drawable.lays2
            )
        )

        binding.carousel.setData(list)


        return binding.root
    }


    fun setupRecyclerView() {
        var adapter = HomeAdapter(activity, data, images, quantity, price)
        var layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.productView.layoutManager = layoutManager
        binding.productView.adapter = adapter

        var adapter2 = HomeAdapter(activity, data2, images2, quantity, price2)
        var layoutManager2 = LinearLayoutManager(activity)
        layoutManager2.orientation = LinearLayoutManager.HORIZONTAL
        binding.productView2.layoutManager = layoutManager2
        binding.productView2.adapter = adapter2


    }


}