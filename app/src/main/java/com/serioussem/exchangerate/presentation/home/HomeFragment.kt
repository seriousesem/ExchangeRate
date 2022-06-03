package com.serioussem.exchangerate.presentation.home

import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.HomeFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment


class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    companion object {
        private const val ALPHA_MAX = 250
        private const val ALPHA_MIN = 70

    }

    private val homeViewModel: HomeViewModel by viewModels()

    override fun init() {
        initViewPager()
        initPageTitle()
    }


    private fun initViewPager() {
        binding.viewPager.adapter =
            ViewPagerAdapter(fragmentManager = parentFragmentManager, lifecycle = lifecycle)
        binding.tabLayout.tabIconTint = null
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    with(tab) {
                        setText(R.string.privat_bank)
                        setIcon(R.drawable.privat_logo)
                        icon?.alpha = ALPHA_MAX
                    }
                    homeViewModel.updatePageTitle(title = getString(R.string.currency_rate_in_privat_bank))
                }
                1 -> {
                    with(tab) {
                        setText(R.string.mono_bank)
                        setIcon(R.drawable.mono_logo)
                        icon?.alpha = ALPHA_MIN
                    }
                    homeViewModel.updatePageTitle(title = getString(R.string.currency_rate_in_mono_bank))
                }
            }
        }.attach()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                tab.icon?.alpha = ALPHA_MAX
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.icon?.alpha = ALPHA_MIN
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun initPageTitle(){
        binding.pageTitle.text = homeViewModel.pageTitle.value
    }
}
