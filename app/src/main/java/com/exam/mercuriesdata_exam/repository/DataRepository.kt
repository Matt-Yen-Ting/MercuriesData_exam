package com.exam.mercuriesdata_exam.repository

import com.exam.mercuriesdata_exam.api.NameApi
import com.exam.mercuriesdata_exam.api.ListDataApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val nameApi: NameApi,
    private val listDataApi: ListDataApi
) {
    suspend fun callAPiForNavigation(username: String) = withContext(Dispatchers.IO) {
        nameApi.callApiForNavigation(username)
    }

    suspend fun getListData() = withContext(Dispatchers.IO) {
        listDataApi.getListData()
    }
}