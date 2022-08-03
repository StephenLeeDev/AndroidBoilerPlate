package com.stephen.androidbolierplate.presentation.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.stephen.androidbolierplate.data.util.PrefUtil
import com.stephen.androidbolierplate.databinding.ActivitySplashBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity
import com.stephen.androidbolierplate.presentation.ui.auth.SignInActivity
import com.stephen.androidbolierplate.presentation.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    @Inject
    lateinit var prefUtil: PrefUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            delay(1500)

            if (prefUtil.isHoldingToken()) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            }
            else {
                startActivity(Intent(this@SplashActivity, SignInActivity::class.java))
            }
            finish()
        }

    }
}