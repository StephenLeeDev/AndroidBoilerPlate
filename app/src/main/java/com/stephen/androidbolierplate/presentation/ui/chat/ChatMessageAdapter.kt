package com.stephen.androidbolierplate.presentation.ui.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stephen.androidbolierplate.data.model.chat.ChatMessageModel
import com.stephen.androidbolierplate.databinding.ItemChatReceiveBinding
import com.stephen.androidbolierplate.databinding.ItemChatSendBinding

/**
 * Written by StephenLeeDev on 2022/08/02.
 */

class ChatMessageAdapter : ListAdapter<ChatMessageModel, RecyclerView.ViewHolder>(diffUtil) {

    /**
     * 내가 보낸 메시지 ViewHolder
     */
    inner class ChatMessageSendViewHolder(private val binding: ItemChatSendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(message: ChatMessageModel) {
            binding.apply {
                this.model = message
            }
        }
    }

    /**
     * 상대가 보낸 메시지 ViewHolder
     */
    inner class ChatMessageReceiveViewHolder(private val binding: ItemChatReceiveBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(message: ChatMessageModel) {
            binding.apply {
                this.model = message
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return currentList[position].viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            SENDER -> {
                ChatMessageSendViewHolder(
                    ItemChatSendBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> {
                ChatMessageReceiveViewHolder(
                    ItemChatReceiveBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = currentList[position]
        when(item.viewType) {
            SENDER -> {
                (holder as ChatMessageSendViewHolder).bind(item)
            }
            else -> {
                (holder as ChatMessageReceiveViewHolder).bind(item)
            }
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChatMessageModel>() {
            override fun areItemsTheSame(oldItem: ChatMessageModel, newItem: ChatMessageModel): Boolean {
                return oldItem.messageId == newItem.messageId
            }

            override fun areContentsTheSame(oldItem: ChatMessageModel, newItem: ChatMessageModel): Boolean {
                return oldItem == newItem
            }

        }

        val SENDER: Int = 1
        val RECEIVER: Int = 2
    }

}