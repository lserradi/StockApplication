package com.lara.s.lopez.data.model

import com.lara.s.lopez.domain.model.CategoryType
import com.lara.s.lopez.domain.model.Stock
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class StocksResponse(
    @Json(name = "name")
    val name: String = "",
    @Json(name = "hot")
    val hot: Int = 0,
    @Json(name = "ricCode")
    val ricCode: Int,
    @Json(name = "category")
    val category: String,
) {

    fun toDomain(id: String): Stock =
        Stock(id = id,
            name = name,
            hot = hot,
            ricCode = ricCode,
            category = CategoryType.valueOf(category))
}