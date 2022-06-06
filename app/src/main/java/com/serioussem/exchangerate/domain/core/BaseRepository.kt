package com.serioussem.exchangerate.domain.core

interface BaseRepository<T> {
    suspend fun fetchCurrencyRate(): T
}