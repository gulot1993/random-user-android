package com.random.user.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<VS: Any, AS: Any> : ViewModel() {
    protected val mutableUIState: MutableStateFlow<VS> by lazy { MutableStateFlow(initialState) }
    protected val mutableActionState: MutableSharedFlow<AS> = MutableSharedFlow()
    abstract val initialState: VS

    val uiState: StateFlow<VS> by lazy { mutableUIState.asStateFlow() }
    val actionState: SharedFlow<AS> by lazy { mutableActionState.asSharedFlow() }
}