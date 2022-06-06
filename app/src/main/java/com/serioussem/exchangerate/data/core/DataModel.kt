package com.serioussem.exchangerate.data.core

data class DataModel(
    val country: String,
    val currencyShortName: String,
    val currencyFullName: String,
    val buyingRate: Double,
    val sellingRate: Double
)
