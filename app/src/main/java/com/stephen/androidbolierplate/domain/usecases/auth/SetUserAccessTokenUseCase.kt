package com.stephen.androidbolierplate.domain.usecases.auth

import com.stephen.androidbolierplate.domain.repository.auth.AuthRepository

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

class SetUserAccessTokenUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(userAccessToken: String) = authRepository.setUserAccessToken(userAccessToken)
}