package com.stephen.androidbolierplate.domain.repository.chat

import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

interface ChatRepository {
    suspend fun getChatRooms(): Flow<PagingData<ChatRoomModel>>
}