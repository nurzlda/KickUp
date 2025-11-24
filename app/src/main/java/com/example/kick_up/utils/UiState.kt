package com.example.kick_up.utils

sealed class UiState<T> (
    val data:T? = null,
    val msg: String? = null
){
    class Loading<T>: UiState<T>()
    class Success<T>(data:T?): UiState<T>(data = data)
    class Error<T>(msg: String?): UiState<T>(msg = msg)
}