package com.random.user.screens.users.state

import com.random.user.data.domain.UserProfile

data class UsersUIState(
    val isLoading: Boolean = false,
    val error: String = "",
    val isSuccess: Boolean = false,
    val users: List<UserProfile> = emptyList()
)
