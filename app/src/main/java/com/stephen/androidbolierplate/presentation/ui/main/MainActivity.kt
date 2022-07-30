package com.stephen.androidbolierplate.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import com.stephen.androidbolierplate.databinding.ActivityMainBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val boilerPlateViewModel: BoilerPlateViewModel by viewModels()
    private val adapter = BoilerPlateAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
        initObservers()
        boilerPlateViewModel.getBoilerPlate()
    }

    private fun initViews() {
        binding.apply {
            recyclerView.adapter = adapter
        }
    }

    private fun initObservers() {
        boilerPlateViewModel.boilerPlateState.observe(this@MainActivity) { state ->
            when (state) {
                is BoilerPlateState.Progress -> {
                    // TODO : 통신 중
                }
                is BoilerPlateState.Success -> {
                    adapter.submitList(state.list)
                }
                is BoilerPlateState.Fail -> {
                    // TODO : 통신 실패
                }
            }
        }
    }
}
