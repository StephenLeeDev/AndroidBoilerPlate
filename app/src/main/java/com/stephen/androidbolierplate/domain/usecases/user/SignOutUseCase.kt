package com.stephen.androidbolierplate.domain.usecases.user

import com.stephen.androidbolierplate.data.util.PrefUtil

/**
 * Written by StephenLeeDev on 2022/08/03.
 */

class SignOutUseCase(private val prefUtil: PrefUtil) {
    suspend fun execute() = prefUtil.logout()
}