package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserIDDTO(
    val name: String,
    val value: String
) : Model