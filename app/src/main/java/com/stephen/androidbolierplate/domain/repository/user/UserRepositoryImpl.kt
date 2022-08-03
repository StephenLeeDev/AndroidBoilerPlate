package com.stephen.androidbolierplate.domain.repository.user

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.api.user.UserServiceUtil
import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.presentation.ui.main.people.UserPagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class UserRepositoryImpl(
    private val userServiceUtil: UserServiceUtil,
    private val userPagingSource: UserPagingSource
) : UserRepository {

    override suspend fun getUserInfo(): Flow<UserModel> =
        flow { emit(userServiceUtil.getUserInfo()) }.flowOn(Dispatchers.IO)

    override suspend fun getPeople(query: String): Flow<PagingData<UserModel>> {
        userPagingSource.page = 0
        userPagingSource.query = query
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { userPagingSource }
        ).flow.catch {}
    }

    override suspend fun getFriends(): Flow<PagingData<UserModel>> {
        userPagingSource.page = 0
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { userPagingSource }
        ).flow.catch {}
    }

}