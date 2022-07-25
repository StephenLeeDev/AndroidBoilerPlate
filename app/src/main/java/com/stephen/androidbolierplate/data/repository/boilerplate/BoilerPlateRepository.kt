package com.stephen.androidbolierplate.data.repository.boilerplate

import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

interface BoilerPlateRepository {
    suspend fun getMovies(): Flow<List<BoilerPlateModel>>
}