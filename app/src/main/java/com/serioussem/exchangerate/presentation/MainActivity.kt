package com.serioussem.exchangerate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.serioussem.exchangerate.R
import com.serioussem.exchangerate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}