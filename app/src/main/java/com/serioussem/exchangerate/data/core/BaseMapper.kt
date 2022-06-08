package com.serioussem.exchangerate.data.core

interface BaseMapper<T, S> {
    fun map(source: T): S
}