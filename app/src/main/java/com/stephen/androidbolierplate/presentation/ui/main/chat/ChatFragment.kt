package com.stephen.androidbolierplate.presentation.ui.main.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.stephen.androidbolierplate.databinding.FragmentChatBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : BaseFragment() {

    private val binding by lazy { FragmentChatBinding.inflate(layoutInflater) }
    private val chatRoomViewModel: ChatRoomViewModel by viewModels()

    private val adapter = TrashChatRoomAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViews()
        getChatRooms()
        return binding.root
    }

    private fun initViews() {
        binding.apply {
            recyclerView.adapter = adapter
        }
    }

    private fun getChatRooms() {
        lifecycleScope.launch {
            chatRoomViewModel.getChatRooms()
                .catch { }
                .collectLatest {
                    adapter.submitData(it)
                }
        }
    }

}