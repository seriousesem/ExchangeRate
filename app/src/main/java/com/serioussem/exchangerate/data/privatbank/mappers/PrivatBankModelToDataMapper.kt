package com.serioussem.exchangerate.data.privatbank.mappers

import com.serioussem.exchangerate.data.models.DataModel
import com.serioussem.exchangerate.data.privatbank.model.PrivatBankModel
import com.serioussem.exchangerate.data.core.BaseMapper

class PrivatBankModelToDataMapper : BaseMapper<PrivatBankModel, DataModel> {
    override fun map(source: PrivatBankModel) =
        DataModel(
            currencyShortName = source.targetCurrency,
            buyingRate = source.buying_rate,
            sellingRate = source.selling_rate
        )
}