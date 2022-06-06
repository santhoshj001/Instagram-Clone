package com.teamb.paging3sample.data.remote

import com.teamb.paging3sample.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface UnSplashApi {

   
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int
    ): List<UnsplashImage>


}