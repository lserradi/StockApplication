package com.lara.s.lopez.data.network

import com.lara.s.lopez.data.apiservice.StocksApiService
import com.lara.s.lopez.data.model.StockListResponse
import com.lara.s.lopez.domain.model.Stock
import io.reactivex.Single
import javax.inject.Inject

class StocksDataSource @Inject constructor(private val apiService: StocksApiService) {

    fun getStockIds(): Single<StockListResponse> =
        apiService.getListStockApi()

    fun getDetailStocksApi(id: String): Single<Stock> =
        apiService.getDetailStockApi(id).map { it.toDomain(id) }
}