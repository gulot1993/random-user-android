package com.random.user.repositories

import com.random.user.data.domain.UserProfile
import com.random.user.utils.ResourceState
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun getUsers(limit: Int): Flow<ResourceState<List<UserProfile>>>
}