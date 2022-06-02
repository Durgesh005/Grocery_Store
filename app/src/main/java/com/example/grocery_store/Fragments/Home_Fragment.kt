package com.example.grocery_store.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.grocery_store.R
import com.example.grocery_store.databinding.FragmentHomeBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem


class Home_Fragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.carousel.registerLifecycle(lifecycle)

        val list = mutableListOf<CarouselItem>()



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

        binding.carousel.setData(list)


        return binding.root
    }


}