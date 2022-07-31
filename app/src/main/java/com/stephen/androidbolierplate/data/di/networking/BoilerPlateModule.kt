package com.stephen.androidbolierplate.data.di.networking

import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.data.api.BoilerPlateServiceUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/07/31.
 */

@Module
@InstallIn(SingletonComponent::class)
object BoilerPlateModule {

    @Provides
    @Singleton
    fun provideBoilerPlateServiceUtil(okHttpClient: OkHttpClient): BoilerPlateServiceUtil {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoilerPlateServiceUtil::class.java)
    }

}