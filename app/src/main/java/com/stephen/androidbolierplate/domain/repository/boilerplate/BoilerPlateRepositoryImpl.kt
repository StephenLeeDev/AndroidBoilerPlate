package com.stephen.androidbolierplate.domain.repository.boilerplate

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.presentation.ui.list.BoilerPlatePagingSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

class BoilerPlateRepositoryImpl(
    private val boilerPlateServiceUtil: BoilerPlateServiceUtil,
    private val boilerPlatePagingSource: BoilerPlatePagingSource
) : BoilerPlateRepository {

    override suspend fun getMovies(): Flow<List<BoilerPlateModel>> {
        return flow { emit(boilerPlateServiceUtil.getMovies()) }.flowOn(Dispatchers.IO)
    }

    override suspend fun getPagingMovies(): Flow<PagingData<BoilerPlateModel>> {
        boilerPlatePagingSource.page = 0
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { boilerPlatePagingSource }
        ).flow
    }

}