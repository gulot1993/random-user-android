package com.random.user.service

import com.random.user.data.base.BaseResponse
import com.random.user.data.dto.ResponseInfoDTO
import com.random.user.data.dto.UserDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("?")
    suspend fun getUsers(@Query("results") results: Int): BaseResponse<List<UserDTO>, ResponseInfoDTO>
}