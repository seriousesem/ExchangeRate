package com.serioussem.exchangerate.data.privatbank.datasource.mapper

import com.serioussem.exchangerate.data.core.DataModel
import com.serioussem.exchangerate.data.privatbank.datasource.model.PrivatBankModel
import com.serioussem.exchangerate.domain.core.BaseMapper

class PrivatBankModelToDataMapper : BaseMapper<PrivatBankModel, DataModel> {
    override fun map(source: PrivatBankModel) =
        DataModel(
            currencyShortName = source.targetCurrency,
            buyingRate = source.buying_rate,
            sellingRate = source.selling_rate
        )
}