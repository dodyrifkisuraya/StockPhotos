package com.dorizu.stockphotos.di

import com.dorizu.core.domain.usecase.IPhotosUseCase
import com.dorizu.core.domain.usecase.PhotoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun providePhotoRepositoryUseCase(photoUseCase: PhotoUseCase): IPhotosUseCase
}