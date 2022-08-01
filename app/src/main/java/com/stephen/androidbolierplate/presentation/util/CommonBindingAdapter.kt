package com.stephen.androidbolierplate.presentation.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Written by StephenLeeDev on 2022/07/28.
 */

object CommonBindingAdapter {

    @BindingAdapter("app:setImageUrl")
    @JvmStatic
    fun setImageUrl(view: AppCompatImageView, imageUrl: String) {
        Glide.with(view.context)
            .load(imageUrl)
            .centerCrop()
            .into(view)

    }

}