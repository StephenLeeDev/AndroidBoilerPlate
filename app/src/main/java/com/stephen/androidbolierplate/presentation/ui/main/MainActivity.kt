package com.stephen.androidbolierplate.presentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.stephen.androidbolierplate.R
import com.stephen.androidbolierplate.databinding.ActivityMainBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseActivity
import com.stephen.androidbolierplate.presentation.ui.main.chat.ChatRoomAdapter
import com.stephen.androidbolierplate.presentation.ui.main.chat.ChatRoomViewModel
import com.stephen.androidbolierplate.presentation.util.setupWithNavController

class MainActivity : BaseActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val userViewModel: UserViewModel by viewModels()
//    private val chatRoomViewModel: ChatRoomViewModel by viewModels()

    private val adapter = ChatRoomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpBottomNavigation()
        initViews()
        initObservers()
        getUserInfo()
    }

    private fun getUserInfo() {
        userViewModel.getUserInfo()
    }

    private fun initViews() {
        binding.apply {
            recyclerView.adapter = adapter
        }
    }

    private fun setUpBottomNavigation() {
        val navGraphIds = listOf(
            R.navigation.navigation_home,
            R.navigation.navigation_people,
            R.navigation.navigation_chat,
            R.navigation.navigation_mypage,
            R.navigation.navigation_employment
        )

        binding.bottomNavigation.setupWithNavController(
            navGraphIds,
            supportFragmentManager,
            R.id.fragment_main,
            intent
        )
    }

    private fun initObservers() {
//        boilerPlateViewModel.boilerPlateState.observe(this@MainActivity) { state ->
//            when (state) {
//                is BoilerPlateState.Progress -> {
//                    // TODO : 통신 중
//                }
//                is BoilerPlateState.Success -> {
//                    adapter.submitList(state.list)
//                }
//                is BoilerPlateState.Fail -> {
//                    // TODO : 통신 실패
//                }
//            }
//        }
    }
}
