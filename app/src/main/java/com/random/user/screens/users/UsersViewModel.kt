package com.random.user.screens.users

import androidx.lifecycle.viewModelScope
import com.random.user.base.BaseViewModel
import com.random.user.repositories.UsersRepository
import com.random.user.screens.users.state.UsersActionState
import com.random.user.screens.users.state.UsersUIState
import com.random.user.utils.ResourceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor() : BaseViewModel<UsersUIState, UsersActionState>() {
    @Inject
    lateinit var repository: UsersRepository

    fun getUsers(limit: Int) {
        viewModelScope.launch {
            if (limit <= 0) {
                mutableUIState.value = mutableUIState.value.copy(error = "Incorrect number of limits. Please try again")
                return@launch
            }
            repository
                .getUsers(limit)
                .collectLatest { resourceState ->
                    when(resourceState) {
                        is ResourceState.Error -> {
                            mutableUIState.value = mutableUIState.value.copy(error = resourceState.message, isLoading = false)
                        }

                        is ResourceState.Loading -> {
                            mutableUIState.value = mutableUIState.value.copy(isLoading = true, error = "")
                        }

                        is ResourceState.Success -> {
                            mutableUIState.value = mutableUIState.value.copy(users = resourceState.data, isLoading = false, error = "")
                        }
                    }
                }
        }
    }

    override val initialState: UsersUIState
        get() = UsersUIState()

}