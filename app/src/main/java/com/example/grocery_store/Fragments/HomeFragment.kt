package com.example.grocery_store.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.grocery_store.Modal_Data.ProductModalData
import com.example.grocery_store.Utills.DBHelper
import com.example.grocery_store.R
import com.example.grocery_store.databinding.FragmentHomeBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var list1 = ArrayList<ProductModalData>()
    val list = mutableListOf<CarouselItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        /*binding.carousel.registerLifecycle(lifecycle)*/

        val db = DBHelper(activity)

        binding.addCartBtn.setOnClickListener {

            db.insertData(
                binding.orderIdEdt.text.toString(),
                binding.productNameEdt.text.toString(),
                binding.priceEdt.text.toString(),

                )
            list1 = db.readData()
        }


        list.add(
            CarouselItem(
                imageDrawable = R.drawable.gift4
            )
        )


        list.add(
            CarouselItem(
                imageDrawable = R.drawable.gift4
            )
        )

        /* binding.carousel.setData(list)*/


        return binding.root
    }


}