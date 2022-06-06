package com.teamb.paging3sample.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamb.paging3sample.common.Constants
import com.teamb.paging3sample.model.UnsplashImage

@Dao
interface UnSplashImageDao {

    @Query("SELECT * from ${Constants.UNSPLASH_IMAGE_TABLE}")
    fun getAllImages(): PagingSource<Int, UnsplashImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<UnsplashImage>)

    @Query("DELETE from ${Constants.UNSPLASH_IMAGE_TABLE}")
    suspend fun deleteAllImages()

}