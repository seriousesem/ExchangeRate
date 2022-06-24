package com.serioussem.exchangerate.presentation.home

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.HomeFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.core.adapters.ViewPagerAdapter


class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    companion object {
        private const val ALPHA_MAX = 250
        private const val ALPHA_MIN = 70

    }

    override fun init() {
        initViewPager()
    }

    private fun initViewPager() {
        with(binding){
            viewPager.adapter =
                ViewPagerAdapter(fragmentManager = parentFragmentManager, lifecycle = lifecycle)
            tabLayout.tabIconTint = null
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> {
                        with(tab) {

                            setIcon(R.drawable.nbu_icon)
                            icon?.alpha = ALPHA_MAX
                        }
                    }
                    1 -> {
                        with(tab) {

                            setIcon(R.drawable.privatbank_icon)
                            icon?.alpha = ALPHA_MIN
                        }
                    }
                    2 -> {
                        with(tab) {

                            setIcon(R.drawable.monobank_icon)
                            icon?.alpha = ALPHA_MIN
                        }
                    }
                    3 -> {
                        with(tab) {

                            setIcon(R.drawable.favorites_icon)
                            icon?.alpha = ALPHA_MIN
                        }
                    }
                }
            }.attach()

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab) {
                    tab.icon?.alpha = ALPHA_MAX
                }
                override fun onTabUnselected(tab: TabLayout.Tab) {
                    tab.icon?.alpha = ALPHA_MIN
                }
                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }
    }
}
