package com.example.collapsingtoolbarlayout

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.palette.graphics.Palette
import com.example.collapsingtoolbarlayout.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val collapsingToolbarLayout = binding.collapsingToolbarLayout
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.header_image)
        Palette.from(bitmap).generate { palette ->
            if (palette != null) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(androidx.appcompat.R.attr.colorPrimary))
            }
        }
    }
}