package com.stephen.androidbolierplate.data.di.networking

import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import com.stephen.androidbolierplate.data.repository.boilerplate.BoilerPlateRepository
import com.stephen.androidbolierplate.data.repository.boilerplate.BoilerPlateRepositoryImpl
import com.stephen.androidbolierplate.data.util.PrefUtil
import com.stephen.androidbolierplate.data.util.TokenInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

@Module
@InstallIn(SingletonComponent::class)
object BoilerPlateModule {

    @Provides
    @Singleton
    fun provideBoilerPlateServiceUtil(prefUtil: PrefUtil): BoilerPlateServiceUtil {
        val okHttpClient = OkHttpClient.Builder().apply {
            connectTimeout(5, TimeUnit.SECONDS)
            readTimeout(5, TimeUnit.SECONDS)
            writeTimeout(5, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            addInterceptor(TokenInterceptor(prefUtil))
        }.build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoilerPlateServiceUtil::class.java)
    }

    @Provides
    @Singleton
    fun provideCheckCalendarRepository(boilerPlateServiceUtil: BoilerPlateServiceUtil) : BoilerPlateRepository {
        return BoilerPlateRepositoryImpl(boilerPlateServiceUtil)
    }

}