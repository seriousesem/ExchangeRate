package com.serioussem.exchangerate.data.privatbank.model

import com.google.gson.annotations.SerializedName

data class PrivatBankResponse(

	@field:SerializedName("sale")
	val selling_rate: String,

	@field:SerializedName("base_ccy")
	val baseCurrency: String,

	@field:SerializedName("buy")
	val buying_rate: String,

	@field:SerializedName("ccy")
	val targetCurrency: String
)
