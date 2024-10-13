package com.random.user.di

import com.random.user.repositories.UsersRepository
import com.random.user.repositories.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun providesUserRepository(usersRepository: UsersRepositoryImpl): UsersRepository
}