package com.teamb.paging3sample.data.repository

import androidx.paging.*
import com.teamb.paging3sample.common.Constants
import com.teamb.paging3sample.data.local.database.UnSplashDatabase
import com.teamb.paging3sample.data.paging.UnSplashRemoteMediator
import com.teamb.paging3sample.data.remote.UnSplashApi
import com.teamb.paging3sample.model.UnsplashImage
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

@ExperimentalPagingApi
class PagingRepository @Inject constructor(
    private val unSplashApi: UnSplashApi,
    private val unSplashDatabase: UnSplashDatabase
) {
    fun getAllImages(): Flow<PagingData<UnsplashImage>> {
        val pagingSourceFactory = { unSplashDatabase.unSplashImageDao().getAllImages() }
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGE_SIZE, initialLoadSize =
                Constants.PAGE_SIZE * 2
            ),
            remoteMediator = UnSplashRemoteMediator(
                unSplashApi = unSplashApi,
                unSplashDatabase = unSplashDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}