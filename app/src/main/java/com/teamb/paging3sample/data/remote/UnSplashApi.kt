package com.teamb.paging3sample.data.remote

import com.teamb.paging3sample.BuildConfig
import com.teamb.paging3sample.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface UnSplashApi {

    @Headers("Authorization : Client-ID ${BuildConfig.API_KEY} ")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): List<UnsplashImage>

    @Headers("Authorization : Client-ID ${BuildConfig.API_KEY} ")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): List<UnsplashImage>

}