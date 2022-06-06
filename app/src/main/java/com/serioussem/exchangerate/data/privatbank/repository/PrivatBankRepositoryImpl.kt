package com.serioussem.exchangerate.data.privatbank.repository

import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository

class PrivatBankRepositoryImpl: PrivatBankRepository {
    override suspend fun fetchCurrencyRate(): DomainResult<DomainModel> {
        return super.fetchCurrencyRate()
    }
}