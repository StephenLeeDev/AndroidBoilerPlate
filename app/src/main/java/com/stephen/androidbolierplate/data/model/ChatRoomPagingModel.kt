package com.stephen.androidbolierplate.data.model

import com.google.gson.annotations.SerializedName
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class ChatRoomPagingModel(
    val items: List<ChatRoomModel>,
    @SerializedName("is_last")
    val isLast: Boolean
)