package com.dorizu.core.utils

import com.dorizu.core.data.remote.response.PhotosItemResponse
import com.dorizu.core.domain.model.Photo

object DataMapper {
    fun mapPhotosResponseToDomain(input: List<PhotosItemResponse>) =
        input.map {
            Photo(
                srcMedium = it.src.medium,
                srcLarge = it.src.large,
                width = it.width,
                avgColor = it.avgColor,
                photographer = it.photographer,
                photographerId = it.photographerId,
                photographerUrl = it.photographerUrl,
                id = it.id,
                url = it.url,
                liked = it.liked,
                height = it.height
            )
        }
}