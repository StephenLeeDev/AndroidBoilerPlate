package com.stephen.androidbolierplate.data.di.util

import android.content.Context
import com.stephen.androidbolierplate.data.util.PrefUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Written by StephenLeeDev on 2022/07/26.
 */

@Module
@InstallIn(SingletonComponent::class)
object UtilModule {

    @Provides
    @Singleton
    fun providePrefUtil(@ApplicationContext context: Context): PrefUtil {
        return PrefUtil(context)
    }

}