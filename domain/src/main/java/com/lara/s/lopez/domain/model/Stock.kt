package com.lara.s.lopez.domain.model

data class Stock(
    val id: String = "",
    val name: String = "",
    val hot: Int = 0,
    val ricCode: Int,
    val category: CategoryType
)
