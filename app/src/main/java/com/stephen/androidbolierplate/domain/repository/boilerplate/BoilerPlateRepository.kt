package com.stephen.androidbolierplate.domain.repository.boilerplate

import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

interface BoilerPlateRepository {
    suspend fun getMovies(): Flow<List<BoilerPlateModel>>
    suspend fun getPagingMovies(): Flow<PagingData<BoilerPlateModel>>
}