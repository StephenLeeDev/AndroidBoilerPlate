package com.stephen.androidbolierplate.domain.usecases.chat

import com.stephen.androidbolierplate.domain.repository.chat.ChatRepository

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

class GetChatRoomsUseCase(private val chatRepository: ChatRepository) {
    suspend fun execute() = chatRepository.getChatRooms()
}