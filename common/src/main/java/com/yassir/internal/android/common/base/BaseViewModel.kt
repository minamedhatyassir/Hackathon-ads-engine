package com.yassir.internal.android.common.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseViewModel<S, I, E>(initState: S) : ViewModel() {

    private val _intent: MutableSharedFlow<I> = MutableSharedFlow()
    val intent: SharedFlow<I> = _intent.asSharedFlow()

    private val _effects: MutableSharedFlow<E> = MutableSharedFlow()
    val effects: SharedFlow<E> = _effects.asSharedFlow()

    private val _state: MutableStateFlow<S> = MutableStateFlow(initState)
    val state: StateFlow<S> = _state.asStateFlow()

    init {
        observeIntents()
    }

    private fun observeIntents() {
        viewModelScope.launch {
            intent.collect() { processIntents(it) }
        }
    }

    fun sendAction(action: I) {
        viewModelScope.launch {
            _intent.emit(action)
        }
    }

    fun sendEffect(effect: E) {
        viewModelScope.launch {
            _effects.emit(effect)
        }
    }

    protected suspend fun setState(reducer: S.() -> S) {
        _state.emit(reducer(_state.first()))
    }

    abstract suspend fun processIntents(intent: I)


}