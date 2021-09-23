package com.dorizu.core.data

import com.dorizu.core.data.remote.RemoteDataSource
import com.dorizu.core.data.remote.network.ApiResponse
import com.dorizu.core.data.remote.response.PhotosItemResponse
import com.dorizu.core.domain.model.Photo
import com.dorizu.core.domain.repository.IPhotoRepository
import com.dorizu.core.utils.DataMapper
import io.reactivex.Flowable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : IPhotoRepository {
    override fun getCuratedPhoto(): Flowable<ResultState<List<Photo>>> =
        object : MapApiResponseToResultState<List<Photo>, List<PhotosItemResponse>>(){
            override fun createCall(): Flowable<ApiResponse<List<PhotosItemResponse>>>
                    = remoteDataSource.getListPhoto()

            override fun mapResponseToDomain(data: List<PhotosItemResponse>): List<Photo>
                    = DataMapper.mapPhotosResponseToDomain(data)
        }.asFlowable()
}
