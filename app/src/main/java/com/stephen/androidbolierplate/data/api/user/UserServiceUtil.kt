package com.stephen.androidbolierplate.data.api.user

import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.data.model.user.UserPagingModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

interface UserServiceUtil {

    /**
     * 내 정보 가져오기
     */
    @GET("v3/6dc43a3e-c6cc-44e0-a3f0-592331bafc5a")
    suspend fun getUserInfo(): UserModel

    /**
     * 검색어로 유저 목록 조회
     */
    @GET("v3/59133581-92e0-414e-b8de-25a59ee931cd")
    suspend fun getPeople(
        @Query("query") query: String, // 검색어
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
    ): UserPagingModel

    /**
     * 내 친구 목록 가져오기
     */
    @GET("v3/59133581-92e0-414e-b8de-25a59ee931cd")
    suspend fun getFriends(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
    ): UserPagingModel

}