package com.stephen.androidbolierplate.data.model.chat


import com.google.gson.annotations.SerializedName
import com.stephen.androidbolierplate.presentation.util.TimeUtil

data class ChatRoomModel(
    @SerializedName("created_date")
    val createdDate: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("profile_url")
    val profileUrl: String,
    @SerializedName("room_id")
    val roomId: String,
    @SerializedName("sender_name")
    val senderName: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("unread_message_count")
    val unreadMessageCount: Int
) {

    // 안읽은 메시지가 존재하는가
    fun hasUnreadMessage(): Boolean = unreadMessageCount > 0

    // 안읽은 메시지 String 으로 반환
    fun unreadMessageCountToString(): String = "$unreadMessageCount"

    // 마지막 메시지의 생성일을 기준으로한 날짜
    fun messageDateByString(): String = TimeUtil.getIntervalByString(createdDate)

}