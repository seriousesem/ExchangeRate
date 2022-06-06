package com.serioussem.exchangerate.domain.core

interface BaseUseCase<T>{
    suspend fun fetchCurrencyRate(): T
}