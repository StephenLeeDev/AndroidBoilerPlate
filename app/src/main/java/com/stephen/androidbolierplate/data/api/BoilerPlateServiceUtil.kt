package com.stephen.androidbolierplate.data.api

import com.stephen.androidbolierplate.data.model.BoilerPlateModel
import com.stephen.androidbolierplate.data.model.PagingModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

interface BoilerPlateServiceUtil {

    @GET("movielist.json")
    suspend fun getMovies(): List<BoilerPlateModel>

    @GET("movielist.json")
    suspend fun getPagingMovies(
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 10,
    ): PagingModel

}