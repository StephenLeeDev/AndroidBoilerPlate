package com.stephen.androidbolierplate.data.api

import com.stephen.androidbolierplate.data.model.auth.SignInRequestModel
import com.stephen.androidbolierplate.data.model.auth.SignInResponseModel
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

interface AuthServiceUtil {

    @POST("v3/ffb8bbda-355b-4f93-bffc-62afb77ac004")
    suspend fun postSignIn(@Body body: SignInRequestModel): SignInResponseModel

}