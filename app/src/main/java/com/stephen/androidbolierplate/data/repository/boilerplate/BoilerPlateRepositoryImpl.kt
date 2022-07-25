package com.stephen.androidbolierplate.data.repository.boilerplate

import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

class BoilerPlateRepositoryImpl(private val boilerPlateServiceUtil: BoilerPlateServiceUtil) : BoilerPlateRepository {

    override suspend fun getMovies(): Flow<List<BoilerPlateModel>> {
        return flow { emit(boilerPlateServiceUtil.getMovies()) }.flowOn(Dispatchers.IO)
    }

}