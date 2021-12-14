package com.exam.mercuriesdata_exam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exam.mercuriesdata_exam.repository.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RequestDataViewModel @Inject constructor(
    private val dataRepository: DataRepository,
) : ViewModel() {

    private val _requestSuccess = MutableSharedFlow<Unit>()
    val requestSuccess = _requestSuccess.asSharedFlow()

    fun requestData(username: String) {
        viewModelScope.launch {
            dataRepository.callAPiForNavigation(username)
            _requestSuccess.emit(Unit)
        }
    }
}