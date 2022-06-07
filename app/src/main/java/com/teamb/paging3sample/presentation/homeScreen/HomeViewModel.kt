package com.teamb.paging3sample.presentation.homeScreen

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
class HomeViewModel @Inject constructor(
    repository: PagingRepository
) : ViewModel() {
    //val getAllImages = repository.getAllImages()

    private val _allImages = MutableStateFlow<PagingData<UnsplashImage>>(PagingData.empty())
    val getAllImages = _allImages


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllImages().collect {
                _allImages.value = it
            }
        }

    }

}