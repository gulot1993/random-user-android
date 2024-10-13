package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseInfoDTO(
    val seed: String,
    val results: Int,
    val version: String,
    val page: Int
) : Model