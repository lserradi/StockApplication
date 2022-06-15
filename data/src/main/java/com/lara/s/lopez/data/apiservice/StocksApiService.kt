package com.lara.s.lopez.data.apiservice

import com.lara.s.lopez.data.model.StockListResponse
import com.lara.s.lopez.data.model.StocksResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

const val ROOT_URL_LIST_STOCK_PATH = "favorites"
const val ROOT_URL_STOCK_PATH = "favorites/{id}"


interface StocksApiService {

    @GET(ROOT_URL_LIST_STOCK_PATH)
    fun getListStockApi(): Single<StockListResponse>

    @GET(ROOT_URL_STOCK_PATH)
    fun getDetailStockApi(@Path("id") id: String): Single<StocksResponse>
}