package com.stephen.androidbolierplate.presentation.ui.main.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stephen.androidbolierplate.R
import com.stephen.androidbolierplate.databinding.FragmentChatBinding
import com.stephen.androidbolierplate.presentation.ui.base.BaseFragment

class ChatFragment : BaseFragment() {

    private val binding by lazy { FragmentChatBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }
}