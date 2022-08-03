package com.stephen.androidbolierplate.presentation.ui.main.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.databinding.ItemUserBinding
import com.stephen.androidbolierplate.interfaces.ClickListener

/**
 * Written by StephenLeeDev on 2022/08/03.
 */

class PeopleAdapter(private val listener: ClickListener<UserModel>): PagingDataAdapter<UserModel, PeopleAdapter.PeopleViewHolder>(diffUtil) {

    inner class PeopleViewHolder(private val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: UserModel) {
            binding.apply {
                this.model = model
                root.setOnClickListener {
                    listener.onClick(model)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<UserModel>() {
            override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem.userId == newItem.userId
            }

            override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
                return oldItem == newItem
            }
        }
    }

}