package com.example.grocery_store.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.grocery_store.Fragments.CategoryFragment
import com.example.grocery_store.Fragments.HomeFragment
import com.example.grocery_store.Fragments.ShoppingCartFragment
import com.example.grocery_store.Fragments.UserFragment
import com.example.grocery_store.R
import com.example.grocery_store.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())
        val firstFragment = HomeFragment()
        val secondFragment = CategoryFragment()
        val thirdFragment = ShoppingCartFragment()
        val forthFragment = UserFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.daily -> loadFragment(firstFragment)
                R.id.store -> loadFragment(secondFragment)
                R.id.cart -> loadFragment(thirdFragment)
                R.id.orders -> loadFragment(forthFragment)

            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.view_pager, fragment)
            commit()
        }
    }
}