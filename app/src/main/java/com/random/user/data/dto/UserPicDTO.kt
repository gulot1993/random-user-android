package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserPicDTO(
    val large: String,
    val medium: String,
    val thumbnail: String
) : Model