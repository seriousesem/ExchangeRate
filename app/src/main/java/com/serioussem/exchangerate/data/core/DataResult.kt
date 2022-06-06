package com.serioussem.exchangerate.data.core

data class DataResult(
    val country: String,
    val currencyShortName: String,
    val currencyFullName: String,
    val buyingRate: Double,
    val sellingRate: Double
)
