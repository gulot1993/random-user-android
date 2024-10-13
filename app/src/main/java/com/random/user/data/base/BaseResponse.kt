package com.random.user.data.base

data class BaseResponse<T, I>(
    val results: T,
    val info: I
)