package com.example.grocery_store.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.grocery_store.R
import com.example.grocery_store.databinding.ActivityHomeViewBinding
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class Home_View : AppCompatActivity() {
    lateinit var binding: ActivityHomeViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

    /*    binding.carousel.registerLifecycle(lifecycle)*/

        val list = mutableListOf<CarouselItem>()



        list.add(
            CarouselItem(
                imageDrawable = R.drawable.image3,
                caption = "JOIN NOW"
            )
        )


        list.add(
            CarouselItem(
                imageDrawable = R.drawable.image6
            )
        )

/*
        binding.carousel.setData(list)
*/
    }
}