package com.lara.s.lopez.data.cache

import com.lara.s.lopez.domain.model.Stock
import javax.inject.Inject

class MemoryDataSource @Inject constructor() {

    private var stocks: List<Stock>? = null

    fun save(list: List<Stock>) {
        stocks = list
    }

    fun get(): List<Stock>? {
        return stocks
    }
}