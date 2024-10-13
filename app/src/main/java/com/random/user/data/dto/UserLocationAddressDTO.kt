package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLocationAddressDTO(
    val number: Int,
    val name: String
) : Model
