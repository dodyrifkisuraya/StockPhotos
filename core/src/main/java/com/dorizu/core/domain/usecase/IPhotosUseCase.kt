package com.dorizu.core.domain.usecase

import com.dorizu.core.data.ResultState
import com.dorizu.core.domain.model.Photo
import io.reactivex.Flowable

interface IPhotosUseCase {
    fun getCuratedPhoto(): Flowable<ResultState<List<Photo>>>
}