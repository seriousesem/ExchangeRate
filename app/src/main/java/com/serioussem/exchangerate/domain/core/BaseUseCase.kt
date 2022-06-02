package com.serioussem.exchangerate.domain.core

interface BaseUseCase<T> {
    fun fetchCurrency(): T
}