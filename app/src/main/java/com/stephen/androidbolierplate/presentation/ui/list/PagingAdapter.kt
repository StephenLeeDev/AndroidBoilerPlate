package com.stephen.androidbolierplate.presentation.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.databinding.ItemBoilerplateBinding
import com.stephen.androidbolierplate.interfaces.ClickListener

/**
 * Written by StephenLeeDev on 2022/07/30.
 */

class PagingAdapter(private val listener: ClickListener<BoilerPlateModel>): PagingDataAdapter<BoilerPlateModel, PagingAdapter.PagingViewHolder>(diffUtil) {

    inner class PagingViewHolder(private val binding: ItemBoilerplateBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(model: BoilerPlateModel) {
            binding.model = model
            binding.root.setOnClickListener {
                listener.onClick(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        return PagingViewHolder(ItemBoilerplateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<BoilerPlateModel>() {
            override fun areItemsTheSame(oldItem: BoilerPlateModel, newItem: BoilerPlateModel): Boolean {
                return oldItem.name == newItem.name
            }

            override fun areContentsTheSame(
                oldItem: BoilerPlateModel,
                newItem: BoilerPlateModel
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}