package com.lara.s.lopez.domain.repository

import com.lara.s.lopez.domain.model.Stock
import io.reactivex.Single

interface StocksRepository {

    fun getStocks(): Single<List<Stock>>

    fun getDetailStock(id: String): Single<Stock>
}