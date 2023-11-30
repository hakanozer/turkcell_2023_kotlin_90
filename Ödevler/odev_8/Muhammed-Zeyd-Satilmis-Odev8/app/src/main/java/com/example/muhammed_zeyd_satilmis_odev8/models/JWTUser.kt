package com.example.muhammed_zeyd_satilmis_odev8.models

data class JWTUser(
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String
)
