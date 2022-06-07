package com.teamb.paging3sample.di

import android.content.Context
import androidx.room.Room
import com.teamb.paging3sample.common.Constants
import com.teamb.paging3sample.data.local.database.UnSplashDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {


    @Provides
    @Singleton
    fun providesDataBase(@ApplicationContext context: Context): UnSplashDatabase {
        return Room.databaseBuilder(
            context,
            UnSplashDatabase::class.java,
            Constants.UNSPLASH_TABLE
        ).build()
    }
}