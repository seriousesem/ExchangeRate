package com.serioussem.exchangerate.data.core

interface BaseDataSource<T> {
    suspend fun fetch(): T
}