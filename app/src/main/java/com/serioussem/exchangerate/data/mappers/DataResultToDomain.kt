package com.serioussem.exchangerate.data.mappers

import com.serioussem.exchangerate.data.core.DataModel
import com.serioussem.exchangerate.data.core.DataResult
import com.serioussem.exchangerate.domain.core.BaseMapper
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainResult

class DataResultToDomain: BaseMapper<DataResult<List<DataModel>>, DomainResult<List<DomainModel>>> {
    override fun map(source: DataResult<List<DataModel>>): DomainResult<List<DomainModel>> {
        TODO("Not yet implemented")
    }
}