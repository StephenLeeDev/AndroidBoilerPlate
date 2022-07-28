package com.stephen.androidbolierplate.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.databinding.ItemBoilerplateBinding

/**
 * Written by StephenLeeDev on 2022/07/28.
 */

class BoilerPlateAdapter: ListAdapter<BoilerPlateModel, BoilerPlateAdapter.BoilerPlateViewHolder>(diffUtil) {

    inner class BoilerPlateViewHolder(val binding: ItemBoilerplateBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(model: BoilerPlateModel) {
            binding.model = model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoilerPlateAdapter.BoilerPlateViewHolder {
        return BoilerPlateViewHolder(ItemBoilerplateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BoilerPlateViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<BoilerPlateModel>() {
            override fun areItemsTheSame(oldItem: BoilerPlateModel, newItem: BoilerPlateModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(oldItem: BoilerPlateModel, newItem: BoilerPlateModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}