package com.exam.mercuriesdata_exam.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RequestDataItem(
    @Json(name = "copyright") val copyright: String,
    @Json(name = "url") val url: String,
    @Json(name = "title") val title: String,
    @Json(name = "description") val description: String,
    @Json(name = "date") val date: String,
    @Json(name = "apod_site") val apodSite: String,
    @Json(name = "media_type") val mediaType: String,
    @Json(name = "hdurl") val hdUrl: String,
)
