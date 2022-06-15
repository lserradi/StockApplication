package com.lara.s.lopez.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StockListResponse(
    @Json(name = "result")
    val idList: List<String>,
)

