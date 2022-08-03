package com.stephen.androidbolierplate.data.model.user

import com.google.gson.annotations.SerializedName

/**
 * Written by StephenLeeDev on 2022/08/02.
 */

data class UserPagingModel(
    val items: List<UserModel>,
    @SerializedName("is_last")
    val isLast: Boolean
)