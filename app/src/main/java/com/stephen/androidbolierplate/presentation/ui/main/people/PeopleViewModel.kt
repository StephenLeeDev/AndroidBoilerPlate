package com.stephen.androidbolierplate.presentation.ui.main.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.domain.usecases.user.GetFriendsUseCase
import com.stephen.androidbolierplate.domain.usecases.user.GetPeopleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/08/03.
 */

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase,
    private val getFriendsUseCase: GetFriendsUseCase
) : ViewModel() {

    // 검색어를 통해 유저 목록 조회
    suspend fun getPeople(query: String): Flow<PagingData<UserModel>> {
        return getPeopleUseCase.execute(query = query).cachedIn(viewModelScope)
    }

    // 내 친구 목록 조회
    suspend fun getFriends(): Flow<PagingData<UserModel>> {
        return getFriendsUseCase.execute().cachedIn(viewModelScope)
    }

}