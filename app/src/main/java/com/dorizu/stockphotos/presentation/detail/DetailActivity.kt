package com.dorizu.stockphotos.presentation.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.dorizu.core.domain.model.Photo
import com.dorizu.stockphotos.R
import com.dorizu.stockphotos.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()

        val detailPhoto = intent.getParcelableExtra<Photo>(PHOTO_EXTRA)
        showDetail(detailPhoto)
    }

    private fun showDetail(detailPhoto: Photo?) {
        if (detailPhoto != null){
            Glide.with(this)
                .load(detailPhoto.srcLarge)
                .centerCrop()
                .into(binding.imgPhoto)
            with(binding.content){
                tvPhotographer.text = detailPhoto.photographer
                tvResolution.text = getString(R.string.resolution, detailPhoto.width, detailPhoto.height)
            }
        }
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        with(binding.toolbar){
            navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_back_rounded_background)
            setNavigationOnClickListener { onBackPressed() }
        }
    }

    companion object{
        const val PHOTO_EXTRA = "photos_extra"
    }
}