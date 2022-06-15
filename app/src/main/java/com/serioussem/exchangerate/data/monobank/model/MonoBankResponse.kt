package com.serioussem.exchangerate.data.monobank.model

import com.google.gson.annotations.SerializedName

data class MonoBankResponse(
    @field:SerializedName("date")
    val date: Int,

    @field:SerializedName("currencyCodeA")
    val targetCurrency: Int,

    @field:SerializedName("currencyCodeB")
    val baseCurrency: Int,

    @field:SerializedName("rateCross")
    val rateCross: Double,

    @field:SerializedName("rateBuy")
    val rateBuy: Double,

    @field:SerializedName("rateSell")
    val rateSell: Double
)
