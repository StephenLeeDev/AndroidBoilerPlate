package com.stephen.androidbolierplate.presentation.ui.splash

import android.os.Bundle
import com.stephen.androidbolierplate.databinding.ActivitySplashBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity

class SplashActivity : BaseActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}