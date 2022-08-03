package com.stephen.androidbolierplate.domain.repository.chat

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.api.chat.ChatServiceUtil
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.presentation.ui.main.chat.ChatRoomPagingSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class ChatRepositoryImpl(
    private val chatServiceUtil: ChatServiceUtil,
    private val chatRoomPagingSource: ChatRoomPagingSource
) : ChatRepository {

    override suspend fun getChatRooms(): Flow<PagingData<ChatRoomModel>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { chatRoomPagingSource }
        ).flow.catch {}
    }

}