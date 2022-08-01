package com.stephen.androidbolierplate.presentation.ui.main.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import com.stephen.androidbolierplate.domain.usecases.chat.GetChatRoomsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val getChatRoomsUseCase: GetChatRoomsUseCase,
) : ViewModel() {

    private val _chatRooms = MutableLiveData<List<ChatRoomModel>>()
    val chatRooms = _chatRooms as LiveData<List<ChatRoomModel>>

    // 채팅방 목록
    suspend fun getChatRooms(): Flow<PagingData<ChatRoomModel>> {
        return getChatRoomsUseCase.execute().cachedIn(viewModelScope)
    }

}