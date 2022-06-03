package com.serioussem.exchangerate.domain.core

data class CurrencyRateDomainModel(
    val country: String,
    val currencyShortName: String,
    val currencyFullName: String,
    val buyingRate: Double,
    val sellingRate: Double
)