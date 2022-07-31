package com.stephen.androidbolierplate.domain.usecases

import androidx.paging.PagingData
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.domain.repository.boilerplate.BoilerPlateRepository
import kotlinx.coroutines.flow.Flow

/**
 * Written by StephenLeeDev on 2022/07/30.
 */

class GetPagingUseCase(private val boilerPlateRepository: BoilerPlateRepository) {
    suspend fun execute(): Flow<PagingData<BoilerPlateModel>> =
        boilerPlateRepository.getPagingMovies()

}