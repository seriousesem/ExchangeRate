package com.serioussem.exchangerate.domain.core

import kotlinx.coroutines.flow.Flow

interface BaseRepository<T> {
    suspend fun fetchCurrencyRate(): Flow<T>
}