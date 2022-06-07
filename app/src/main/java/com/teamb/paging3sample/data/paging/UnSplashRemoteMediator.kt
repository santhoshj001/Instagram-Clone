package com.teamb.paging3sample.data.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.teamb.paging3sample.data.local.database.UnSplashDatabase
import com.teamb.paging3sample.data.remote.UnSplashApi
import com.teamb.paging3sample.model.UnSplashRemoteKeys
import com.teamb.paging3sample.model.UnsplashImage

@OptIn(ExperimentalPagingApi::class)
class UnSplashRemoteMediator(
    private val unSplashDatabase: UnSplashDatabase,
    private val unSplashApi: UnSplashApi
) : RemoteMediator<Int, UnsplashImage>() {
    private val unSplashImageDao = unSplashDatabase.unSplashImageDao()
    private val unSplashRemoteKeysDao = unSplashDatabase.unSplashRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UnsplashImage>
    ): MediatorResult {
        return try {
            val currentPage: Int = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val response = unSplashApi.getAllImages(page = currentPage, pageSize = 10)
            val endPaginationReached = response.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endPaginationReached) null else currentPage + 1

            unSplashDatabase.withTransaction {
                if (loadType == LoadType.PREPEND) {
                    unSplashImageDao.deleteAllImages()
                    unSplashRemoteKeysDao.deleteAllRemoteKeys()
                }

                val keys = response.map { image ->
                    UnSplashRemoteKeys(
                        id = image.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }
                unSplashImageDao.addImages(response)
                unSplashRemoteKeysDao.addAllRemoteKeys(keys)
            }
            MediatorResult.Success(endOfPaginationReached = endPaginationReached)
        } catch (e: Exception) {
            MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, UnsplashImage>
    ): UnSplashRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                unSplashRemoteKeysDao.getRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, UnsplashImage>
    ): UnSplashRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()
            ?.let { unsplashImage ->
                unSplashRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
            }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, UnsplashImage>
    ): UnSplashRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()
            ?.let { unsplashImage ->
                unSplashRemoteKeysDao.getRemoteKeys(id = unsplashImage.id)
            }
    }
}