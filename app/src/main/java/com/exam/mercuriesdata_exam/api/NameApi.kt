package com.exam.mercuriesdata_exam.api

import com.exam.mercuriesdata_exam.ErrorResponse
import com.exam.mercuriesdata_exam.SuccessResponse
import com.slack.eithernet.ApiResult
import com.slack.eithernet.DecodeErrorBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NameApi {

    @DecodeErrorBody
    @FormUrlEncoded
    @POST("WistronMobile/SysFun/WebService/LoginChk_Test.aspx")
    suspend fun callApiForNavigation(
        @Field("username") userName: String
    ): ApiResult<SuccessResponse<*>, ErrorResponse<*>>
}