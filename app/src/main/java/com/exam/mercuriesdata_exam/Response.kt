package com.exam.mercuriesdata_exam

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SuccessResponse<T>(
    val data: T? = null
)


@JsonClass(generateAdapter = true)
data class ErrorResponse<T>(
    val data: T? = null
)
