package com.stephen.androidbolierplate.domain.usecases

import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.data.repository.boilerplate.BoilerPlateRepository
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/07/26.
 */

class GetBoilerPlateUseCase(private val boilerPlateRepository: BoilerPlateRepository) {
    suspend fun execute(): Flow<List<BoilerPlateModel>> = boilerPlateRepository.getMovies()
}