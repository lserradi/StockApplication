package com.lara.s.lopez.domain.usecase

import com.lara.s.lopez.domain.repository.StocksRepository
import com.lara.s.lopez.domain.model.Stock
import io.reactivex.Single
import javax.inject.Inject

class GetStocksUseCase @Inject constructor(
    private val stocksRepository: StocksRepository,
) {

    fun execute(): Single<List<Stock>> = stocksRepository.getStocks()
}