package com.example.grocery_store.Home_Screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.grocery_store.R
import com.example.grocery_store.databinding.ActivitySpalashScreenBinding
import pl.droidsonroids.gif.GifImageView

class SplashScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivitySpalashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalashScreenBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_spalash_screen)

        
        val backgroundImage: GifImageView = findViewById(R.id.SplashScreenImage)
        val slideAnimation = AnimationUtils.loadAnimation(this, R.anim.side_slide)
        backgroundImage.startAnimation(slideAnimation)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}