package com.serioussem.exchangerate.data.privatbank.datasource.model

import com.google.gson.annotations.SerializedName

data class PrivatBankModelList(

	@field:SerializedName("PrivatBankResponse")
	val privatBankResponse: List<PrivatBankModel>
)

data class PrivatBankModel(

	@field:SerializedName("sale")
	val selling_rate: String,

	@field:SerializedName("base_ccy")
	val baseCurrency: String,

	@field:SerializedName("buy")
	val buying_rate: String,

	@field:SerializedName("ccy")
	val targetCurrency: String
)
