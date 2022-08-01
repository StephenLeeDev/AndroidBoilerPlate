package com.stephen.androidbolierplate.data.api.auth

import com.stephen.androidbolierplate.data.model.auth.SignInRequestModel
import com.stephen.androidbolierplate.data.model.auth.SignInResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

interface AuthServiceUtil {

    /**
     * 로그인
     * 현재 구글 로그인만 구현된 상태
     */
    @POST("v3/ffb8bbda-355b-4f93-bffc-62afb77ac004")
    suspend fun postSignIn(@Body body: SignInRequestModel): SignInResponseModel

}