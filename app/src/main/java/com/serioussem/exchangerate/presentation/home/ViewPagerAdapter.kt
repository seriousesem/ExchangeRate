package com.serioussem.exchangerate.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.serioussem.exchangerate.presentation.monobank.MonoBankFragment
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragmentList = listOf<Fragment>(PrivatBankFragment(), MonoBankFragment())

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> fragmentList[0]
            1 -> fragmentList[1]
            else -> fragmentList[0]
        }
    }
}