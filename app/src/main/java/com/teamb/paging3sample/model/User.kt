package com.teamb.paging3sample.model

import androidx.room.Embedded
import com.teamb.paging3sample.model.UserLinks
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("links")
    @Embedded
    val userLinks: UserLinks,
    val username: String
)
