package com.stephen.androidbolierplate.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stephen.androidbolierplate.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val boilerPlateViewModel: BoilerPlateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initObservers()
        boilerPlateViewModel.getBoilerPlate()
    }

    private fun initObservers() {
        boilerPlateViewModel.boilerPlateState.observe(this@MainActivity) { state ->
            when (state) {
                is BoilerPlateState.Progress -> {
                    // TODO : 통신 중
                }
                is BoilerPlateState.Success -> {
                    // TODO : 통신 성공
                }
                is BoilerPlateState.Fail -> {
                    // TODO : 통신 실패
                }
            }
        }
    }
}
