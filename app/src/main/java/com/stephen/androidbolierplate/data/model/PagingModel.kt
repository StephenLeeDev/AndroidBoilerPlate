package com.stephen.androidbolierplate.data.model

import com.google.gson.annotations.SerializedName

/**
 * Written by StephenLeeDev on 2022/07/30.
 */

data class PagingModel(
    val items: List<BoilerPlateModel>,
    @SerializedName("is_last")
    val isLast: Boolean
)
