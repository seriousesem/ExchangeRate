package com.serioussem.exchangerate.presentation.home

import com.google.android.material.tabs.TabLayoutMediator
import com.serioussem.exchangerate.databinding.HomeFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment


class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    override fun init() {
        TODO("Not yet implemented")
    }

    private fun initView(){
        binding.viewPager.adapter = ViewPagerAdapter(fragment = HomeFragment())

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
           when(position){
               0 -> {
                   tab.text = "ПриватБанк"
               }
               1 -> {
                   tab.text = "МоноБанк"
               }
           }
        }
    }

}