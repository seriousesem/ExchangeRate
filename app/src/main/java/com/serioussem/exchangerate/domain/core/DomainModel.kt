package com.serioussem.exchangerate.domain.core

data class DomainModel(
    val currencyShortName: String,
    val buyingRate: String,
    val sellingRate: String
)