package com.example.grocery_store.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.grocery_store.Fragments.Category
import com.example.grocery_store.Fragments.Home_Fragment
import com.example.grocery_store.Fragments.Shopping_Cart
import com.example.grocery_store.Fragments.User
import com.example.grocery_store.R
import com.example.grocery_store.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(Home_Fragment())

        binding.bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(Home_Fragment())
                    true
                }
                R.id.category -> {
                    loadFragment(Category())
                    true
                }
                R.id.cart -> {
                    loadFragment(Shopping_Cart())
                    true
                }
                R.id.user -> {
                    loadFragment(User())
                    true
                }

                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.view_pager, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}