package com.stephen.androidbolierplate.presentation.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.domain.usecases.user.GetUserInfoUseCase
import com.stephen.androidbolierplate.domain.usecases.user.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val signOutUseCase: SignOutUseCase
) : ViewModel() {

    private val _userInfo = MutableLiveData<UserModel>()
    val userInfo = _userInfo as LiveData<UserModel>

    fun getUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            getUserInfoUseCase.execute()
                .catch {  }
                .collect { user ->
                    withContext(Dispatchers.Main) {
                        _userInfo.value = user
                    }
                }
        }
    }

    fun signOut() {
        viewModelScope.launch(Dispatchers.IO) {
            signOutUseCase.execute()
        }
    }

}