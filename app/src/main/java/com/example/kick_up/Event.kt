package com.example.kick_up

data class Event(
    val startDate: String,
    val endDate: String?, // может быть null
    val month: String,
    val nameEvent: String,
    val status: String,
    //val image: Int,
    val team: String
)
