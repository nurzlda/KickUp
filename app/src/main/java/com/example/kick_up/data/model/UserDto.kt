package com.example.kick_up.data.model

import com.google.gson.annotations.SerializedName

data class UserDto (
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("name") val name: String
)