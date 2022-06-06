package com.serioussem.exchangerate.app

import android.app.Application

class App : Application(){

    companion object{
        private const val PrivatBankUrl = "https://api.privatbank.ua/p24api/"
        private const val MonoBankUrl = "https"
    }

    override fun onCreate() {
        super.onCreate()
    }
}