package com.example.kick_up.data.repo

import com.example.kick_up.data.model.UserResponse

interface UserRepository {
    suspend fun register(email: String, password: String, name: String): UserResponse
    suspend fun login(email: String, password: String): UserResponse
}