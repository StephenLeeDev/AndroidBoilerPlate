package com.stephen.androidbolierplate.domain.repository.user

import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.model.user.UserModel
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

interface UserRepository {
    suspend fun getUserInfo(): Flow<UserModel>
    suspend fun getPeople(query: String): Flow<PagingData<UserModel>>
    suspend fun getFriends(): Flow<PagingData<UserModel>>
}