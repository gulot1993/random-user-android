package com.random.user.data.dto

import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserLocationDTO(
    val street: UserLocationAddressDTO,
    val city: String,
    val state: String,
    val postcode: String
) : Model
