package com.stephen.androidbolierplate.data.model.auth


import com.google.gson.annotations.SerializedName

data class SignInResponseModel(
    @SerializedName("access_token")
    val accessToken: String
)