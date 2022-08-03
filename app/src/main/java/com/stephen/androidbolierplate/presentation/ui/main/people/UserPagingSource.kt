package com.stephen.androidbolierplate.presentation.ui.main.people

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stephen.androidbolierplate.data.api.user.UserServiceUtil
import com.stephen.androidbolierplate.data.model.user.UserModel
import com.stephen.androidbolierplate.data.model.user.UserPagingModel
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/08/02.
 *
 * 하기 2가지 용도로 사용
 * 1. 검색어(query)가 있으면, 검색어를 통해 유저 목록 검색
 * 2. 검색어(query)가 없으면, 내 친구 목록 조회
 */

class UserPagingSource @Inject constructor(private val userServiceUtil: UserServiceUtil) : PagingSource<Int, UserModel>() {

    var query = ""
    private val size = 10
    var page = 0

    override fun getRefreshKey(state: PagingState<Int, UserModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserModel> {
        return try {
            toLoadResult(
                // 검색어(query)가 있으면, 검색어를 통해 유저 목록 검색
                if (query.isEmpty()) {
                    userServiceUtil.getPeople (
                        query = query,
                        page = ++page,
                        size = size
                    )
                }
                // 검색어(query)가 없으면, 내 친구 목록 조회
                else {
                    userServiceUtil.getFriends (
                        page = ++page,
                        size = size
                    )
                }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun toLoadResult(data: UserPagingModel): LoadResult<Int, UserModel> {
        return LoadResult.Page(
            data = data.items,
            prevKey = null,
            nextKey = if (data.isLast) null else page
        )
    }
}