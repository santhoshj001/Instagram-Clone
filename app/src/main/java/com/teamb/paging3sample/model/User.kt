package com.teamb.paging3sample.model

import androidx.room.Embedded
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    @SerialName("links")
    @Embedded
    val userLinks: UserLink
)
