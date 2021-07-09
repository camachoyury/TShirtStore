package com.camachoyury.tshirtstore.android.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camachoyury.tshirtstore.android.data.repository.Shirt
import com.camachoyury.tshirtstore.android.domain.ShirtUserCase
import com.camachoyury.tshirtstore.android.presentation.home.ShirtListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailShirtViewModel @Inject constructor(val shirtUserCase: ShirtUserCase) : ViewModel() {
    private val _shirt: MutableStateFlow<ShirtDetailState> =
        MutableStateFlow(ShirtDetailState.LoadingState)
    val shirt: StateFlow<ShirtDetailState> = _shirt.asStateFlow()


    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    fun loadById(id: String) = viewModelScope.launch {
        _shirt.value = ShirtDetailState.LoadingState
        shirtUserCase(id = id).collect {
            _shirt.value = ShirtDetailState.Success(it)
        }
    }
}

sealed class ShirtDetailState{
    object LoadingState: ShirtDetailState()
    class Success(val shirt: Shirt): ShirtDetailState()
    data class Error(val exception: Throwable): ShirtDetailState()

}