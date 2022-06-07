package com.teamb.paging3sample.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.teamb.paging3sample.common.Constants
import com.teamb.paging3sample.data.remote.UnSplashApi
import com.teamb.paging3sample.model.UnsplashImage

class SearchPagingSource(
    private val unSplashApi: UnSplashApi,
    private val query: String

) : PagingSource<Int, UnsplashImage>() {
    override fun getRefreshKey(state: PagingState<Int, UnsplashImage>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UnsplashImage> {
        val currentPage = params.key ?: 1
        return try {
            val response = unSplashApi.searchImages(
                query = query,
                page = currentPage,
                pageSize = Constants.PAGE_SIZE
            )
            val endOfPaginationReached = response.images.isEmpty()
            if (endOfPaginationReached) {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            } else {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}