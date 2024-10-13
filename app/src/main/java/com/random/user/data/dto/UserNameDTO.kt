package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserNameDTO(
    val title: String,
    val first: String,
    val last: String
) : Model
