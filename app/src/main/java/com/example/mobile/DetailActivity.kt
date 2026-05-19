package com.example.mobile

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image =
            if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra("image", Image::class.java)
            } else {
                intent.getParcelableExtra<Image>("image")
            }

        if (image != null) {
            binding.detailImage.setImageResource(image.imageSource)
            binding.detailTitle.text = image.imageTitle
            binding.detailDesc.text = image.imageDesc
        }
    }
}