package com.stephen.androidbolierplate.data.model.chat

import com.google.gson.annotations.SerializedName
import com.stephen.androidbolierplate.presentation.ui.chat.ChatMessageAdapter

/**
 * Written by StephenLeeDev on 2022/08/02.
 *
 * 채팅방 내부의 메시지 목록에 사용
 */

data class ChatMessageModel(
    @SerializedName("message_id")
    val messageId: String,
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("sender_id")
    val senderId: String,
    @SerializedName("unread_count")
    val unreadCount: Int = 0,

    /**
     * 어댑터를 위한 ViewType
     */
    var viewType: Int = 1
) {

    fun setViewType(userId: String) {
        viewType =
            if (userId == senderId) {
                ChatMessageAdapter.SENDER // 내가 보낸 메시지
            } else {
                ChatMessageAdapter.RECEIVER // 내가 받은 메시지
            }
    }

    fun getTime(): String = "오전 10:23"
}
