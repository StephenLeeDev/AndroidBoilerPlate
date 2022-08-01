package com.stephen.androidbolierplate.presentation.ui.main.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.databinding.ItemChatroomBinding

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class ChatRoomAdapter: ListAdapter<ChatRoomModel, ChatRoomAdapter.ChatRoomViewHolder>(diffUtil) {

    inner class ChatRoomViewHolder(private val binding: ItemChatroomBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ChatRoomModel) {
            binding.model = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomViewHolder {
        return ChatRoomViewHolder(ItemChatroomBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
        holder.bind(currentList[position] ?: return)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ChatRoomModel>() {
            override fun areItemsTheSame(oldItem: ChatRoomModel, newItem: ChatRoomModel): Boolean {
                return oldItem.roomId == newItem.roomId
            }

            override fun areContentsTheSame(
                oldItem: ChatRoomModel,
                newItem: ChatRoomModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}