package com.serioussem.exchangerate.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.HomeScreenBinding

class HomeScreen : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        HomeScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}