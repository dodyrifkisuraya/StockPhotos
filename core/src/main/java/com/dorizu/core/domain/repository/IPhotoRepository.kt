package com.dorizu.core.domain.repository

import com.dorizu.core.data.ResultState
import com.dorizu.core.domain.model.Photo
import io.reactivex.Flowable

interface IPhotoRepository {
    fun getCuratedPhoto(): Flowable<ResultState<List<Photo>>>
}