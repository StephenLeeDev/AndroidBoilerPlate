package com.stephen.androidbolierplate.presentation.ui.main.chat

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stephen.androidbolierplate.data.api.chat.ChatServiceUtil
import com.stephen.androidbolierplate.data.model.ChatRoomPagingModel
import com.stephen.androidbolierplate.data.model.chat.ChatRoomModel
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/07/30.
 */

class ChatRoomPagingSource @Inject constructor(private val chatServiceUtil: ChatServiceUtil) : PagingSource<Int, ChatRoomModel>() {

    private val size = 10
    var page = 0

    override fun getRefreshKey(state: PagingState<Int, ChatRoomModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ChatRoomModel> {
        return try {
            toLoadResult(
                chatServiceUtil.getChatRooms(
                    page = ++page,
                    size = size
                )
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun toLoadResult(data: ChatRoomPagingModel): LoadResult<Int, ChatRoomModel> {
        return LoadResult.Page(
            data = data.items,
            prevKey = null,
            nextKey = if (data.isLast) null else page
        )
    }
}