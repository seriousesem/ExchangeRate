package com.serioussem.exchangerate.app

import android.app.Application
import com.serioussem.exchangerate.di.*
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin { modules (privatBankRetrofitModule, monoBankRetrofitModule) }
    }
}