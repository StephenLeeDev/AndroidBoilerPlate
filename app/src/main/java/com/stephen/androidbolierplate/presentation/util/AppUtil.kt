package com.stephen.androidbolierplate.presentation.util

import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

object AppUtil {

    private lateinit var toast: Toast

    fun showToast(
        context: Context,
        message: String,
        toastLength: Int = Toast.LENGTH_SHORT
    ) {
        if (!this::toast.isInitialized) toast = Toast(context)
        toast.cancel()
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast = Toast.makeText(context, message, toastLength)
        toast.show()
    }

}