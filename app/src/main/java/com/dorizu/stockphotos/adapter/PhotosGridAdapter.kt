package com.dorizu.stockphotos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dorizu.core.domain.model.Photo
import com.dorizu.stockphotos.R
import com.dorizu.stockphotos.databinding.ItemPhotoGridBinding

class PhotosGridAdapter : RecyclerView.Adapter<PhotosGridAdapter.ListViewHolder>() {

    private var listData = ArrayList<Photo>()
    var onItemClick: ((Photo) -> Unit)? = null

    fun setData(newList: List<Photo>?) {
        listData.clear()
        if (!newList.isNullOrEmpty()) listData.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo_grid, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int = listData.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPhotoGridBinding.bind(itemView)
        fun bind(data: Photo) {
            binding.imgPhoto.clipToOutline = true
            Glide.with(itemView)
                .load(data.srcMedium)
                .centerCrop()
                .into(binding.imgPhoto)
        }
    }
}