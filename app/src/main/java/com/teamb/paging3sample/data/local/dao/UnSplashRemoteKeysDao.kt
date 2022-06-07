package com.teamb.paging3sample.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teamb.paging3sample.model.UnsplashRemoteKeys

@Dao
interface UnSplashRemoteKeysDao {
    @Query("SELECT * from unsplash_remote_keys_image_table WHERE id =:id")
    fun getRemoteKeys(id :String): UnsplashRemoteKeys
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(keys: List<UnsplashRemoteKeys>)

    @Query("DELETE from unsplash_remote_keys_image_table")
    suspend fun deleteAllRemoteKeys()
}