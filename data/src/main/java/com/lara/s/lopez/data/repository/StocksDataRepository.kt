package com.lara.s.lopez.data.repository

import com.lara.s.lopez.core.logger.CoordinatorLogger
import com.lara.s.lopez.data.cache.MemoryDataSource
import com.lara.s.lopez.data.network.StocksDataSource
import com.lara.s.lopez.domain.model.Stock
import com.lara.s.lopez.domain.repository.StocksRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class StocksDataRepository @Inject constructor(
    private val stocksDataSource: StocksDataSource,
    private var memoryDataSource: MemoryDataSource,
    private val logger: CoordinatorLogger,
) : StocksRepository {


    override fun getStocks(): Single<List<Stock>> {
        return if (memoryDataSource.get() != null) {
            Single.just(memoryDataSource.get())
        } else {
            stocksDataSource.getStockIds()
                .flatMapObservable { Observable.fromIterable(it.idList) }
                .map { id -> stocksDataSource.getDetailStocksApi(id).blockingGet() }
                .toList()
                .doOnSuccess {
                    logger.debug(javaClass.name, "Get stocks from retrofit petition")
                    memoryDataSource.save(it)
                }
                .doOnError {
                    throw RuntimeException(it.message + "Error to get stocks")
                }
        }
    }

    override fun getDetailStock(id: String): Single<Stock> {
        val stock = memoryDataSource.get()?.find { it.id == id }
        return if (stock != null) {
            Single.just(stock)
        } else {
            stocksDataSource.getDetailStocksApi(id)
        }
    }
}