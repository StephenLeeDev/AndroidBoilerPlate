package com.stephen.androidbolierplate.presentation.ui.main.chat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.databinding.FragmentChatBinding
import com.stephen.androidbolierplate.interfaces.ClickListener
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment
import com.stephen.androidbolierplate.presentation.ui.chat.ChatActivity
import com.stephen.androidbolierplate.presentation.ui.main.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChatFragment : BaseFragment() {

    private val binding by lazy { FragmentChatBinding.inflate(layoutInflater) }
    private val chatRoomViewModel: ChatRoomViewModel by viewModels()
    private val userViewModel: UserViewModel by activityViewModels()

    private val adapter = ChatRoomAdapter(object : ClickListener<ChatRoomModel> {
        override fun onClick(t: ChatRoomModel) {
            startActivity(
                Intent(requireActivity(), ChatActivity::class.java).apply {
                    putExtra(ChatRoomModel::class.java.name, Gson().toJson(t))
                    putExtra("userId", userViewModel.userInfo.value?.userId ?: "")
                }
            )
        }
    })

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