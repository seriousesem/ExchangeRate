package com.serioussem.exchangerate.presentation.core.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.serioussem.exchangerate.presentation.favorites.FavoritesBankFragment
import com.serioussem.exchangerate.presentation.monobank.MonoBankBankFragment
import com.serioussem.exchangerate.presentation.nbu.NbuBankFragment
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankBankFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList =
        listOf<Fragment>(
            NbuBankFragment(),
            PrivatBankBankFragment(),
            MonoBankBankFragment(),
            FavoritesBankFragment()
        )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragmentList[0]
            1 -> fragmentList[1]
            2 -> fragmentList[2]
            3 -> fragmentList[3]
            else -> fragmentList[0]
        }
    }
}