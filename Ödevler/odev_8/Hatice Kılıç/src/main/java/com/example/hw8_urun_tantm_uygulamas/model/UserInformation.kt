package com.example.hw8_urun_tantm_uygulamas.model

import com.google.gson.annotations.SerializedName

data class UserInformation(
    @SerializedName("id") val id:Int?,
    @SerializedName("username") val username: String?,
)
