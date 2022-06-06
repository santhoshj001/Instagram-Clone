package com.teamb.paging3sample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.teamb.paging3sample.common.Constants

@Entity(tableName = Constants.UNSPLASH_REMOTE_KEYS_IMAGE_TABLE)
data class UnSplashRemoteKeys(
    @PrimaryKey
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
