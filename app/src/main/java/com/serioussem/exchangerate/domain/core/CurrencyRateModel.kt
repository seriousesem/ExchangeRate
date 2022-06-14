package com.serioussem.exchangerate.domain.core

data class CurrencyRateModel(
    val countryFlag: Int,
    val currencyFullName: Int,
    val buyingRate: String,
    val sellingRate: String
)