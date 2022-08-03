package com.stephen.androidbolierplate.data.model.user


import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("company")
    val company: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("profile_url")
    val profileUrl: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_name")
    val userName: String
) {

    fun getNameWithCompany(): String = "$position @${company}"

}