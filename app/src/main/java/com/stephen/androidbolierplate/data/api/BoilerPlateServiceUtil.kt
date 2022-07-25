package com.stephen.androidbolierplate.data.api

import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import retrofit2.http.GET

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

interface BoilerPlateServiceUtil {

    @GET("movielist.json")
    suspend fun getMovies(): List<BoilerPlateModel>

}