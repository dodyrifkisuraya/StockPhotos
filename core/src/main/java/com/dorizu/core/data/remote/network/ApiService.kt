package com.dorizu.core.data.remote.network

import com.dorizu.core.data.remote.response.CuratedResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("Authorization: 563492ad6f917000010000013c84e6de5749444fb3b6c0ee10e52972")
    @GET("/v1/curated")
    fun getListPhoto(): Flowable<CuratedResponse>
}