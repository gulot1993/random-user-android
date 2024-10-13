package com.random.user.utils

sealed class ResourceState<T> {
    data class Success<T>(val data: T): ResourceState<T>()
    class Loading<T> : ResourceState<T>()
    data class Error<T>(val message: String) : ResourceState<T>()
}