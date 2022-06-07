package com.teamb.paging3sample.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.teamb.paging3sample.data.repository.PagingRepository
import com.teamb.paging3sample.model.UnsplashImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@ExperimentalPagingApi
@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: PagingRepository
) : ViewModel() {

     var searchQuery by mutableStateOf("")
        private set

    private val _searchImages = MutableStateFlow<PagingData<UnsplashImage>>(PagingData.empty())
    val searchImages = _searchImages


    fun updateSearchQuery(query: String) {
        searchQuery = query
    }

    fun search(query: String) {
        viewModelScope.launch {
            repository.searchImages(query).cachedIn(viewModelScope).collect {
                _searchImages.value = it
            }
        }
    }

}