package com.stephen.androidbolierplate.data.di.repository.chat

import com.stephen.androidbolierplate.data.api.chat.ChatServiceUtil
import com.stephen.androidbolierplate.domain.repository.chat.ChatRepository
import com.stephen.androidbolierplate.domain.repository.chat.ChatRepositoryImpl
import com.stephen.androidbolierplate.presentation.ui.main.chat.ChatRoomPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

@Module
@InstallIn(SingletonComponent::class)
object ChatRepositoryModule {

    @Provides
    @Singleton
    fun provideChatRepository(
        chatServiceUtil: ChatServiceUtil,
        chatRoomPagingSource: ChatRoomPagingSource
    ): ChatRepository {
        return ChatRepositoryImpl(chatServiceUtil, chatRoomPagingSource)
    }

}