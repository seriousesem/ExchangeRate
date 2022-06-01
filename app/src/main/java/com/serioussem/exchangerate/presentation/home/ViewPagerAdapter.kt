package com.serioussem.exchangerate.presentation.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.serioussem.exchangerate.presentation.monobank.MonoBankFragment
import com.serioussem.exchangerate.presentation.privatbank.PrivatBankFragment

class ViewPagerAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PrivatBankFragment()
            1 -> MonoBankFragment()
            else -> PrivatBankFragment()
        }
    }
}