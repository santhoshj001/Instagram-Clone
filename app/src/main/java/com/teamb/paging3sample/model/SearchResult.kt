package com.teamb.paging3sample.model

import com.teamb.paging3sample.model.UnsplashImage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResult(
    @SerialName("results")
    val images: List<UnsplashImage>,
)