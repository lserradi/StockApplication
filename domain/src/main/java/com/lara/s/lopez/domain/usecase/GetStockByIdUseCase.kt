package com.lara.s.lopez.domain.usecase

import com.lara.s.lopez.domain.model.Stock
import com.lara.s.lopez.domain.repository.StocksRepository
import io.reactivex.Single
import javax.inject.Inject

class GetStockByIdUseCase @Inject constructor(
    private val stocksRepository: StocksRepository,
) {

    fun execute(id: String): Single<Stock> = stocksRepository.getDetailStock(id)
}