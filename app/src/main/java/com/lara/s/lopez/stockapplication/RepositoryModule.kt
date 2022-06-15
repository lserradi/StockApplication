package com.lara.s.lopez.stock.di

import com.lara.s.lopez.data.repository.StocksDataRepository
import com.lara.s.lopez.domain.repository.StocksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideGetListStocks(stocksDataRepository: StocksDataRepository): StocksRepository

}