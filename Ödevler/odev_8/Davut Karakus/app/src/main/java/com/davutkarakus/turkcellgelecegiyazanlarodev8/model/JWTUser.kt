package com.davutkarakus.turkcellgelecegiyazanlarodev8.model

data class JWTUser (
    val id: Long,
    val username: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val image: String,
    val token: String
) {
}