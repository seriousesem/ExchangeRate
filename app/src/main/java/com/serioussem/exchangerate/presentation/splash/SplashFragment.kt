package com.serioussem.exchangerate.presentation.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.SplashFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.presentation.nbu.NbuViewModel
import com.serioussem.exchangerate.utils.playAllSets
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashFragmentBinding>(SplashFragmentBinding::inflate) {

    private var listAnimatorSet = mutableListOf<AnimatorSet>()

    companion object {
        private const val DURATION_1 = 2000L
    }

    override fun init() {
        initAnimators()
        initAnimations()
    }

    private fun initAnimations() {
        listAnimatorSet.playAllSets(lifecycleScope) {
            this.findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }

    }

    private fun initAnimators() {
        val alphaLogoTxt = ObjectAnimator.ofFloat(binding.logoTxt, View.ALPHA, 0f, 1f)
        val alphaNbuLogo = ObjectAnimator.ofFloat(binding.nbuLogo, View.ALPHA, 0f, 1f)
        val translationPrivatLogo =
            ObjectAnimator.ofFloat(binding.privatLogo, View.TRANSLATION_X, -600f, 1f)
        val translationMonoLogo =
            ObjectAnimator.ofFloat(binding.monoLogo, View.TRANSLATION_X, 600f, 1f)

        val animatorSet1 = AnimatorSet().apply {
            duration = DURATION_1
            playTogether(alphaLogoTxt, alphaNbuLogo, translationPrivatLogo, translationMonoLogo)
        }
        listAnimatorSet.add(animatorSet1)

    }

}