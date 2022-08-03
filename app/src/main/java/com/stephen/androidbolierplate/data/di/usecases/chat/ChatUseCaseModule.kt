package com.stephen.androidbolierplate.data.di.usecases.chat

import com.stephen.androidbolierplate.domain.repository.chat.ChatRepository
import com.stephen.androidbolierplate.domain.usecases.chat.GetChatRoomsUseCase
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
object ChatUseCaseModule {

    @Provides
    @Singleton
    fun provideGetChatRoomsUseCase(chatRepository: ChatRepository): GetChatRoomsUseCase {
        return GetChatRoomsUseCase(chatRepository)
    }

}