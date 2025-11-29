package com.example.kick_up.data.api

import com.example.kick_up.data.model.LoginDto
import com.example.kick_up.data.model.UserDto
import com.example.kick_up.data.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/Users/register")
    suspend fun register(@Body userDto: UserDto): UserResponse

    @POST("api/Users/login")
    suspend fun login(@Body loginDto: LoginDto): UserResponse
}