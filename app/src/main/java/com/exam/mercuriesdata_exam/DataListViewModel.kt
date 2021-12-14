package com.exam.mercuriesdata_exam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exam.mercuriesdata_exam.entities.RequestDataItem
import com.exam.mercuriesdata_exam.repository.DataRepository
import com.slack.eithernet.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataListViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _listData = MutableSharedFlow<List<RequestDataItem>>()
    val listData = _listData.asSharedFlow()

    fun getListData() {
        viewModelScope.launch {
            when (val result = dataRepository.getListData()) {
                is ApiResult.Success -> _listData.emit(result.value)
                is ApiResult.Failure -> result.toString()
            }
        }
    }
}