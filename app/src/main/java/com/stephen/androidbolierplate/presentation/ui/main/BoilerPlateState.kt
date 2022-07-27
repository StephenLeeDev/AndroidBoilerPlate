package com.stephen.androidbolierplate.presentation.ui.main

import com.stephen.androidbolierplate.data.model.BoilerPlateModel

/**
 * Written by StephenLeeDev on 2022/07/27.
 */

sealed class BoilerPlateState {
    object Progress : BoilerPlateState()

    data class Success(
        val list: List<BoilerPlateModel> = emptyList()
    ) : BoilerPlateState()

    object Fail : BoilerPlateState()
}
