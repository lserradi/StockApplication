package com.lara.s.lopez.data.network

import com.lara.s.lopez.core.Constant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class BaseApiClient @Inject constructor() {

    private val retrofit: Retrofit by lazy { initializeRetrofit() }

    private fun initializeMoshi(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }

    private fun initializeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(initializeMoshi()))
            .build()
    }

}