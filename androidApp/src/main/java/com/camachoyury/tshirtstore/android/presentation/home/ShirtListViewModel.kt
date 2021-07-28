package com.camachoyury.tshirtstore.android.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camachoyury.tshirtstore.android.data.repository.Shirt
import com.camachoyury.tshirtstore.android.data.repository.ShirtRepository
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
class ShirtListViewModel @Inject constructor (private val shirtRepository: ShirtRepository): ViewModel() {

    private val _shirtList: MutableStateFlow<ShirtListState> =
        MutableStateFlow(ShirtListState.LoadingState)

    val shirtList: StateFlow<ShirtListState> = _shirtList.asStateFlow()

    @InternalCoroutinesApi
    @ExperimentalCoroutinesApi
    fun load() = viewModelScope.launch {
        _shirtList.value = ShirtListState.LoadingState
        shirtRepository.getTShirtById().collect {
            _shirtList.value = ShirtListState.Success(it)
        }
    }
}


sealed class ShirtListState{
    object LoadingState: ShirtListState()
    class Success(val shirts: List<Shirt>): ShirtListState()
    data class Error(val exception: Throwable): ShirtListState()

}