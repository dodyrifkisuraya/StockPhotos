package com.dorizu.stockphotos.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dorizu.stockphotos.R
import com.dorizu.stockphotos.adapter.PhotosGridAdapter
import com.dorizu.stockphotos.databinding.ActivityMainBinding
import com.dorizu.stockphotos.presentation.detail.DetailActivity
import com.dorizu.stockphotos.presentation.detail.DetailActivity.Companion.PHOTO_EXTRA
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val photoGridAdapter = PhotosGridAdapter()
        photoGridAdapter.onItemClick = { selectedPhoto ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(PHOTO_EXTRA, selectedPhoto)
            startActivity(intent)
        }

        mainViewModel.listPhoto.observe(this, {res ->
            photoGridAdapter.setData(res.data)
        })

        with(binding.rvPhotos){
            layoutManager = GridLayoutManager(this@MainActivity,2, GridLayoutManager.VERTICAL, false)
            adapter = photoGridAdapter
        }

        binding.cpGrid.setOnClickListener {
            binding.cpGrid.setChipStrokeColorResource(R.color.purple_500)
            binding.cpList.setChipStrokeColorResource(R.color.transparent)
            with(binding.rvPhotos){
                layoutManager = GridLayoutManager(this@MainActivity,2, GridLayoutManager.VERTICAL, false)
                adapter = photoGridAdapter
            }
        }

        binding.cpList.setOnClickListener {
            binding.cpList.setChipStrokeColorResource(R.color.purple_500)
            binding.cpGrid.setChipStrokeColorResource(R.color.transparent)
            with(binding.rvPhotos){
                layoutManager = GridLayoutManager(this@MainActivity,1, GridLayoutManager.VERTICAL, false)
                adapter = photoGridAdapter
            }
        }
    }
}