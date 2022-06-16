package com.lara.s.lopez.data.cache

import com.lara.s.lopez.core.logger.CoordinatorLogger
import com.lara.s.lopez.domain.model.Stock
import javax.inject.Inject

class MemoryDataSource @Inject constructor(
    private val logger: CoordinatorLogger,
) {

    private var stocks: List<Stock>? = null

    fun save(list: List<Stock>) {
        logger.debug(javaClass.name, "Save stocks from memory data source")
        stocks = list
    }

    fun get(): List<Stock>? {
        logger.debug(javaClass.name, "Get stocks from memory data source")
        return stocks
    }
}