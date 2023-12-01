package com.example.esmasalkim_odev8.models

data class UserSend(
    // username ve password bu şekilde yazılmalı yoksa çalışmaz. sunucuda bu şekilde yazılı. yoksa veriyi göndermez
    val username: String,
    val password : String
)