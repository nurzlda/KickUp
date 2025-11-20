package com.example.kick_up.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("name") val name: String,
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("token") val token: String
)