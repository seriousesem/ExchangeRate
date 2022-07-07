package com.serioussem.exchangerate.presentation.favorites

import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.FavoriteFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseBankFragment
import com.serioussem.exchangerate.presentation.core.BaseFragment

class FavoritesBankFragment : BaseBankFragment() {

    companion object {
        const val title = R.string.currency_rate_favorites
    }

    override fun updateTitle(): String = getString(title)

    override fun init() {
    }

}