package com.stephen.androidbolierplate.domain.repository.auth

import com.stephen.androidbolierplate.data.model.auth.SignInRequestModel
import com.stephen.androidbolierplate.data.model.auth.SignInResponseModel
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

interface AuthRepository {
    suspend fun signIn(body: SignInRequestModel): Flow<SignInResponseModel>
    suspend fun setUserAccessToken(userAccessToken: String)
}