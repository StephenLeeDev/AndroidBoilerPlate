package com.stephen.androidbolierplate.domain.repository.auth

import com.stephen.androidbolierplate.data.api.AuthServiceUtil
import com.stephen.androidbolierplate.data.model.auth.SignInRequestModel
import com.stephen.androidbolierplate.data.model.auth.SignInResponseModel
import com.stephen.androidbolierplate.data.util.PrefUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

class AuthRepositoryImpl(
    private val authServiceUtil: AuthServiceUtil,
    private val prefUtil: PrefUtil
) : AuthRepository {

    override suspend fun signIn(body: SignInRequestModel): Flow<SignInResponseModel> {
        return flow { emit(authServiceUtil.postSignIn(body)) }.flowOn(Dispatchers.IO)
    }

    override suspend fun setUserAccessToken(userAccessToken: String) {
        prefUtil.setUserAccessToken(userAccessToken)
    }
}