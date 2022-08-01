package com.stephen.androidbolierplate.data.di.networking.user

import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.data.api.user.UserServiceUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/08/01.
 */

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    @Provides
    @Singleton
    fun provideUserServiceUtil(okHttpClient: OkHttpClient): UserServiceUtil {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserServiceUtil::class.java)
    }

}