package com.stephen.androidbolierplate.presentation.ui.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.data.model.PagingModel
import javax.inject.Inject

/**
 * Written by StephenLeeDev on 2022/07/30.
 */

class BoilerPlatePagingSource @Inject constructor(private val boilerPlateServiceUtil: BoilerPlateServiceUtil) : PagingSource<Int, BoilerPlateModel>() {

    private val size = 10
    var page = 0

    override fun getRefreshKey(state: PagingState<Int, BoilerPlateModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.nextKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BoilerPlateModel> {
        return try {
            toLoadResult(
                boilerPlateServiceUtil.getPagingMovies(
                    page = ++page,
                    size = size
                )
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private fun toLoadResult(data: PagingModel): LoadResult<Int, BoilerPlateModel> {
        return LoadResult.Page(
            data = data.items,
            prevKey = null,
            nextKey = if (data.isLast) null else page
        )
    }
}