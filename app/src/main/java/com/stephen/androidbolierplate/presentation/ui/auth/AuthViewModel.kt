package com.stephen.androidbolierplate.presentation.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.stephen.androidbolierplate.data.model.auth.SignInRequestModel
import com.stephen.androidbolierplate.domain.repository.auth.AuthRepository
import com.stephen.androidbolierplate.domain.usecases.auth.PostSignInUseCase
import com.stephen.androidbolierplate.domain.usecases.auth.SetUserAccessTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val signInUseCase: PostSignInUseCase,
    private val setUserAccessTokenUseCase: SetUserAccessTokenUseCase
) : ViewModel() {

    private val _goToMain = MutableLiveData(false)
    val goToMain = _goToMain as LiveData<Boolean>

    fun googleSocialSignIn(email: String) {
        CoroutineScope(Dispatchers.IO).launch {

            signInUseCase.execute(body = SignInRequestModel(email = email))
                .catch {
                    it.message
                }
                .collect { response ->
                    setUserAccessTokenUseCase.execute(response.accessToken)
                    withContext(Dispatchers.Main) {
                        _goToMain.value = true
                    }
                }

        }
    }
}