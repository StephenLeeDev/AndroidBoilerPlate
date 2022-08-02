package com.stephen.androidbolierplate.presentation.ui.main.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.databinding.ItemChatroomBinding
import com.stephen.androidbolierplate.interfaces.ClickListener

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class ChatRoomAdapter(private val listener: ClickListener<ChatRoomModel>): PagingDataAdapter<ChatRoomModel, ChatRoomAdapter.ChatRoomViewHolder>(diffUtil) {

    inner class ChatRoomViewHolder(private val binding: ItemChatroomBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ChatRoomModel) {
            binding.apply {
                this.model = model
                root.setOnClickListener {
                    listener.onClick(model) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatRoomViewHolder {
        return ChatRoomViewHolder(ItemChatroomBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ChatRoomViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
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