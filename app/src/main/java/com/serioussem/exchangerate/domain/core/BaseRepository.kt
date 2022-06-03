package com.serioussem.exchangerate.domain.core

interface BaseRepository<T> {
    fun fetchCurrencyRate(): T
}