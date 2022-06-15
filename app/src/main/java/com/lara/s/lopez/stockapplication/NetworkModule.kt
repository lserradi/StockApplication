package com.lara.s.lopez.stockapplication

import com.lara.s.lopez.core.Constant
import com.lara.s.lopez.data.apiservice.StocksApiService
import com.lara.s.lopez.data.network.BaseApiClient
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .build()
    }

    @Provides
    fun provideStockApiService(baseApiClient: BaseApiClient): StocksApiService {
        return baseApiClient.create(StocksApiService::class.java)
    }
}