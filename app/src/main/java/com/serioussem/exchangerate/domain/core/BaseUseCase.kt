package com.serioussem.exchangerate.domain.core

interface BaseUseCase<T>{
    fun fetchCurrencyRate(): T
}