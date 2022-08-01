package com.stephen.androidbolierplate.data.model.chat


import com.google.gson.annotations.SerializedName

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
)