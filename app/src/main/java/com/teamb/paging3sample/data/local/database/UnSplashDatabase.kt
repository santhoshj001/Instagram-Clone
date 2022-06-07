package com.teamb.paging3sample.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teamb.paging3sample.model.UnsplashRemoteKeys
import com.teamb.paging3sample.data.local.dao.UnSplashImageDao
import com.teamb.paging3sample.data.local.dao.UnSplashRemoteKeysDao
import com.teamb.paging3sample.model.UnsplashImage

@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnSplashDatabase() : RoomDatabase() {
    abstract fun unSplashImageDao(): UnSplashImageDao
    abstract fun unSplashRemoteKeysDao(): UnSplashRemoteKeysDao

}