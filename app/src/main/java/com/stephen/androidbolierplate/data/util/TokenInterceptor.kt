package com.stephen.androidbolierplate.data.util

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

class TokenInterceptor(private val prefUtil: PrefUtil) : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val builder: Request.Builder = original.newBuilder()
        try {
            if (prefUtil.getUserAccessToken().isNotEmpty()) {
                builder.addHeader(
                    "Authorization",
                    "Bearer ${prefUtil.getUserAccessToken()}"
                )
            }
        } catch (ignored: Exception) {}
        val request: Request = builder.build()
        return chain.proceed(request)
    }
}