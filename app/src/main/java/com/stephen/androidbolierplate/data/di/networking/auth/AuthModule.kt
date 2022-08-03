package com.stephen.androidbolierplate.data.di.networking.auth

import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.data.api.auth.AuthServiceUtil
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
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthServiceUtil(okHttpClient: OkHttpClient): AuthServiceUtil {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthServiceUtil::class.java)
    }

}