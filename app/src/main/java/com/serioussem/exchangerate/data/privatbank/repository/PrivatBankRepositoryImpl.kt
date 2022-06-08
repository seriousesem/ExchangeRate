package com.serioussem.exchangerate.data.privatbank.repository

import com.serioussem.exchangerate.data.privatbank.datasource.retrofit.PrivatBankService
import com.serioussem.exchangerate.domain.core.DomainModel
import com.serioussem.exchangerate.domain.core.DomainResult
import com.serioussem.exchangerate.domain.privatbank.repository.PrivatBankRepository

class PrivatBankRepositoryImpl(private val service: PrivatBankService) : PrivatBankRepository {
    override suspend fun fetchCurrencyRate(): DomainResult<DomainModel> {
        return super.fetchCurrencyRate()
    }
}