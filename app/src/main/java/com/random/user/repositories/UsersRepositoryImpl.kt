package com.random.user.repositories

import com.random.user.data.domain.UserProfile
import com.random.user.data.dto.UserDTO.Companion.toDomain
import com.random.user.service.APIService
import com.random.user.utils.ResourceState
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(): UsersRepository {

    @Inject
    lateinit var apiService: APIService
    override suspend fun getUsers(limit: Int) = flow {
        emit(ResourceState.Loading())
        val response = apiService.getUsers(results = limit)
        emit(ResourceState.Success(data = response.results.map { it.toDomain() }))
    }.catch {
        emit(ResourceState.Error(message = it.message.toString()))
    }
}