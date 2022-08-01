package com.stephen.androidbolierplate.domain.repository.user

import com.stephen.androidbolierplate.data.api.user.UserServiceUtil
import com.stephen.androidbolierplate.data.model.user.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class UserRepositoryImpl(
    private val userServiceUtil: UserServiceUtil
) : UserRepository {

    override suspend fun getUserInfo(): Flow<UserModel> =
        flow { emit(userServiceUtil.getUserInfo()) }.flowOn(Dispatchers.IO)

}