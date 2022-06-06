package com.teamb.paging3sample.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamb.paging3sample.common.Constants
import com.teamb.paging3sample.model.UnSplashRemoteKeys
import com.teamb.paging3sample.model.UnsplashImage
import retrofit2.http.DELETE


@Dao
interface UnSplashRemoteKeysDao {

    @Query("SELECT * from unsplash_remote_keys_image_table WHERE id = :id")
    fun getRemoteKeys(id :String): UnSplashRemoteKeys
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(images: List<UnSplashRemoteKeys>)

    @Query("DELETE from unsplash_remote_keys_image_table")
    suspend fun deleteAllRemoteKeys()

}