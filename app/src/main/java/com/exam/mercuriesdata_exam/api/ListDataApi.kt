package com.exam.mercuriesdata_exam.api

import com.exam.mercuriesdata_exam.ErrorResponse
import com.exam.mercuriesdata_exam.entities.RequestDataItem
import com.slack.eithernet.ApiResult
import retrofit2.http.GET

interface ListDataApi {

    @GET("cmmobile/NasaDataSet/main/apod.json")
    suspend fun getListData(): ApiResult<List<RequestDataItem>, ErrorResponse<*>>
}