package com.example.hw8_urun_tantm_uygulamas.model

import com.google.gson.annotations.SerializedName

data class LoginInformation(
    @SerializedName("username") val username:String?,
    @SerializedName("password") val password:String?,


)
