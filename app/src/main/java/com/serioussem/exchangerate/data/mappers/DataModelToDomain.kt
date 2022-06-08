package com.serioussem.exchangerate.data.mappers

import com.serioussem.exchangerate.data.models.DataModel
import com.serioussem.exchangerate.data.core.BaseMapper
import com.serioussem.exchangerate.domain.core.DomainModel

class DataModelToDomain : BaseMapper<DataModel, DomainModel> {
    override fun map(source: DataModel) =
        DomainModel(
            currencyShortName = source.currencyShortName,
            buyingRate = source.buyingRate,
            sellingRate = source.sellingRate
        )
}