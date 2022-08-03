package com.stephen.androidbolierplate.domain.usecases.auth

import com.stephen.androidbolierplate.data.model.auth.SignInRequestModel
import com.stephen.androidbolierplate.data.model.auth.SignInResponseModel
import com.stephen.androidbolierplate.domain.repository.auth.AuthRepository
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

class PostSignInUseCase(private val authRepository: AuthRepository) {
    suspend fun execute(body: SignInRequestModel): Flow<SignInResponseModel> = authRepository.signIn(body = body)
}