package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserDobDTO(
    val date: String,
    val age: Int
) : Model