package com.serioussem.exchangerate.domain.core

interface BaseMapper<T, S> {
    fun map(source: T): S
}