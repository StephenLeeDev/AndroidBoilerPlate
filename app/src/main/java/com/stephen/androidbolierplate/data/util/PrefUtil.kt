package com.stephen.androidbolierplate.data.util

import android.content.Context
import android.content.SharedPreferences

/**
 * Written by StephenLeeDev on 2022/07/25.
 */

class PrefUtil(context : Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(
            "boiler-plate-pref",
            Context.MODE_PRIVATE
        )
    }

    fun setUserAccessToken(token: String) {
        sharedPreferences.edit().putString("user_access_token", token).apply()
    }

    fun getUserAccessToken(): String =
        sharedPreferences.getString("user_access_token", "") ?: ""

    fun isHoldingToken(): Boolean =
        getUserAccessToken().isNotEmpty()
}