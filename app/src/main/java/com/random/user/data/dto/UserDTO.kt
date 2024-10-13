package com.random.user.data.dto

import com.random.user.data.base.Model
import com.random.user.data.domain.UserProfile
import kotlinx.android.parcel.Parcelize
import org.joda.time.DateTime

@Parcelize
data class UserDTO(
    val gender: String,
    val name: UserNameDTO,
    val location: UserLocationDTO,
    val email: String,
    val dob: UserDobDTO,
    val phone: String,
    val cell: String,
    val picture: UserPicDTO,
    val id: UserIDDTO? = null,
    val login: UserLoginDTO
) : Model {
    companion object {
        fun UserDTO.toDomain(): UserProfile {
            return with(this) {
                UserProfile(
                    uuid = login.uuid,
                    completeName = listOf(name.title, name.first, name.last).joinToString(" "),
                    gender = UserProfile.Companion.Gender.entries.find { it.name == gender } ?: UserProfile.Companion.Gender.MALE,
                    completeAddress = listOf(location.street.name, location.street.number,location.city, location.state, location.postcode).joinToString(" "),
                    contactNo = listOf(cell, phone).joinToString(" / "),
                    dateOfBirth = DateTime.parse(dob.date),
                    age = dob.age,
                    email = email,
                    photo = picture.large,
                    id = id?.value.orEmpty()
                )
            }
        }
    }
}
