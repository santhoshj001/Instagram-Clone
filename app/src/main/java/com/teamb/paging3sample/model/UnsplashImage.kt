package com.teamb.paging3sample.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamb.paging3sample.common.Constants
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = Constants.UNSPLASH_IMAGE_TABLE)
data class UnsplashImage(
    @PrimaryKey
    val id: String,
    @Embedded
    val urls: Urls,
    val likes: Int,
    @Embedded
    val user: User
)
