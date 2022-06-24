package com.serioussem.exchangerate.data.nbu.model

import com.google.gson.annotations.SerializedName

data class NbuResponse(

	@field:SerializedName("cc")
	val currencyName: String,

	@field:SerializedName("txt")
	val txt: String,

	@field:SerializedName("rate")
	val rate: Double,

	@field:SerializedName("r030")
	val currencyCode: Int,

	@field:SerializedName("exchangedate")
	val exchangeDate: String
)
