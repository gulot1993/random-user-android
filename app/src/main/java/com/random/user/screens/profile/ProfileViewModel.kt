package com.random.user.screens.profile

import androidx.lifecycle.ViewModel
import com.random.user.repositories.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var repository: UsersRepository
}