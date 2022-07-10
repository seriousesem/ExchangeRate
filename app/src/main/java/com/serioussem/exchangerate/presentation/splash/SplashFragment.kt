package com.serioussem.exchangerate.presentation.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.SplashFragmentBinding
import com.serioussem.exchangerate.presentation.core.BaseFragment
import com.serioussem.exchangerate.utils.playAllSets
import com.serioussem.exchangerate.utils.playSingleSet

class SplashFragment : BaseFragment<SplashFragmentBinding>(SplashFragmentBinding::inflate) {

    companion object {
        private const val DURATION_1 = 2000L
    }

    override fun init() {
        initAnimations()
    }

    private fun initAnimations() {
        val alphaLogoTxt = ObjectAnimator.ofFloat(binding.logoTxt, View.ALPHA, 0f, 1f)
        val alphaNbuLogo = ObjectAnimator.ofFloat(binding.nbuLogo, View.ALPHA, 0f, 1f)
        val translationPrivatLogo =
            ObjectAnimator.ofFloat(binding.privatLogo, View.TRANSLATION_X, -600f, 1f)
        val translationMonoLogo =
            ObjectAnimator.ofFloat(binding.monoLogo, View.TRANSLATION_X, 600f, 1f)

        val animatorSet = AnimatorSet().apply {
            duration = DURATION_1
            playTogether(alphaLogoTxt, alphaNbuLogo, translationPrivatLogo, translationMonoLogo)
        }
        animatorSet.playSingleSet {
            this.findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }
}