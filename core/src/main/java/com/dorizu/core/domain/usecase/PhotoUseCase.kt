package com.dorizu.core.domain.usecase

import com.dorizu.core.domain.repository.IPhotoRepository
import javax.inject.Inject

class PhotoUseCase @Inject constructor(private val photoRepository: IPhotoRepository): IPhotosUseCase {
    override fun getCuratedPhoto() = photoRepository.getCuratedPhoto()
}