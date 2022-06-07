package com.teamb.paging3sample.presentation

import androidx.lifecycle.ViewModel
import com.teamb.paging3sample.data.repository.PagingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: PagingRepository
) : ViewModel() {
    val getAllImages = repository.getAllImages()
}