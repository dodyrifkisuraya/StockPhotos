package com.dorizu.core.di

import com.dorizu.core.data.PhotoRepository
import com.dorizu.core.domain.repository.IPhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(photoRepository: PhotoRepository): IPhotoRepository

}