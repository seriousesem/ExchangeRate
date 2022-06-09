package com.serioussem.exchangerate.data.core

interface BaseMapper<S, T> {
    fun map(source: S): T
}