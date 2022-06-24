package com.serioussem.exchangerate.presentation.core.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.serioussem.exchangerate.presentation.favorites.FavoritesFragment
import com.serioussem.exchangerate.presentation.monobank.MonoBankFragment
import com.serioussem.exchangerate.presentation.nbu.NbuFragment
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList =
        listOf<Fragment>(
            NbuFragment(),
            PrivatBankFragment(),
            MonoBankFragment(),
            FavoritesFragment()
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