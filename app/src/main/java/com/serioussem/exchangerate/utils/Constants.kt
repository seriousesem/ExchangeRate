package com.serioussem.exchangerate.utils

import com.serioussem.exchangerate.R

object Constants {
    val countryFlag = listOf(
        R.drawable.us, R.drawable.eur, R.drawable.gb,
        R.drawable.jp, R.drawable.ch, R.drawable.cn,
        R.drawable.noting
    )
    val currencyFullName = listOf(
        R.string.dollar_usa, R.string.euro, R.string.pound_sterling, R.string.japanese_yen,
        R.string.swiss_franc, R.string.yuan_renminbi, R.string.any_currency, R.string.aoe_dih,
        R.string.afgani, R.string.alb_lek, R.string.virm_dram, R.string.ang_kvan, R.string.arg_peso,
        R.string.avstr_dol, R.string.azer_man, R.string.bang_taka, R.string.bolg_lev, R.string.bahr_din,
        R.string.burun_fran
    )
    val currencyCode =
        listOf(
            840, 978, 826, 392, 756, 156, 784, 971, 8, 51, 973, 32, 36, 944,
            50, 975, 48, 108   , 96, 68, 986, 72, 933, 124, 976, 152, 170, 188,
            192, 203, 262, 208, 12, 818, 230, 981, 936, 270, 324, 344, 191,
            348, 360, 376, 356, 368, 364, 352, 400, 404, 417, 116, 408, 410,
            414, 398, 418, 422, 144, 434, 504, 498, 969, 807, 496, 478, 480,
            454, 484, 458, 943, 516, 566, 558, 578, 524, 554, 512, 604, 608,
            586, 985, 600, 634, 946, 941, 682, 690, 938, 752, 702, 694, 706,
            968, 760, 748, 764, 972, 795, 788, 949, 901, 834, 800, 858, 860,
            937, 704, 950, 952, 886, 710, 894
        )
}