package com.stephen.androidbolierplate.data.api.chat

import com.stephen.androidbolierplate.data.model.ChatRoomPagingModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

interface ChatServiceUtil {

    /**
     * 채팅방 목록 가져오기
     */
//    @GET("v3/f0983342-4389-4050-a29e-5f6ce13142df") // isLast == false
    @GET("v3/5dd259ba-ecee-4b48-ba89-b1d57e16f96f") // isLast == true
    suspend fun getChatRooms(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
    ): ChatRoomPagingModel

}