package com.serioussem.exchangerate.data.privatbank.datasource.models

import com.google.gson.annotations.SerializedName

data class PrivatBankResponse(

	@field:SerializedName("PrivatBankResponse")
	val privatBankResponse: List<PrivatBankResponseItem?>? = null
)

data class PrivatBankResponseItem(

	@field:SerializedName("sale")
	val selling_rate: String? = null,

	@field:SerializedName("base_ccy")
	val baseCurrency: String? = null,

	@field:SerializedName("buy")
	val buying_rate: String? = null,

	@field:SerializedName("ccy")
	val targetCurrency: String? = null
)
