package com.dorizu.core.data.remote

import android.annotation.SuppressLint
import android.util.Log
import com.dorizu.core.data.remote.network.ApiResponse
import com.dorizu.core.data.remote.network.ApiService
import com.dorizu.core.data.remote.response.PhotosItemResponse
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    @SuppressLint("CheckResult")
    fun getListPhoto(): Flowable<ApiResponse<List<PhotosItemResponse>>> {
        val resultData = PublishSubject.create<ApiResponse<List<PhotosItemResponse>>>()

        val client = apiService.getListPhoto()
        client
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .take(1)
            .subscribe({response ->
                val dataCategory = response.photos
                resultData.onNext(if (dataCategory.isNotEmpty()) ApiResponse.Success(dataCategory) else ApiResponse.Empty)
            }, {error ->
                resultData.onNext(ApiResponse.Error(error.message.toString()))
                Log.e(TAG, error.toString())
            })

        return resultData.toFlowable(BackpressureStrategy.BUFFER)
    }

    companion object{
        const val TAG = "RemoteDataSource"
    }
}