package com.stephen.androidbolierplate.data.di.networking.chat

import com.stephen.androidbolierplate.BuildConfig
import com.stephen.androidbolierplate.data.api.chat.ChatServiceUtil
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
object ChatModule {

    @Provides
    @Singleton
    fun provideChatServiceUtil(okHttpClient: OkHttpClient): ChatServiceUtil {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChatServiceUtil::class.java)
    }

}