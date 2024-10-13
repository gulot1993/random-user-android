package com.random.user.data.domain

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.random.user.data.base.Model
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime

@Parcelize
data class UserProfile(
    val uuid: String = "",
    val completeName: String = "",
    val gender: Gender = Gender.MALE,
    val completeAddress: String = "",
    val email: String = "",
    val contactNo: String = "",
    val dateOfBirth: DateTime = DateTime.now(),
    val age: Int = 0,
    val photo: String = "",
    val id: String = ""
) : Model {
    companion object {
        enum class Gender(gender: String) {
            MALE("male"),
            FEMALE("female")
        }
    }
}

class UserProfileArgument : NavType<UserProfile>(isNullableAllowed = true) {
    override fun get(bundle: Bundle, key: String): UserProfile? {
        return bundle.getParcelable(key, UserProfile::class.java)
    }

    override fun parseValue(value: String): UserProfile {
        return Gson().fromJson(value, UserProfile::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: UserProfile) {
        bundle.putParcelable(key, value)
    }

}