package com.stephen.androidbolierplate.data.api.user

import com.stephen.androidbolierplate.data.model.user.UserModel
import retrofit2.http.GET

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

interface UserServiceUtil {

    /**
     * 내 정보 가져오기
     */
    @GET("v3/6dc43a3e-c6cc-44e0-a3f0-592331bafc5a")
    suspend fun getUserInfo(): UserModel

}