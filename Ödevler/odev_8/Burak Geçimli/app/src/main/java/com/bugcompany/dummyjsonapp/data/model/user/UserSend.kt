package com.bugcompany.dummyjsonapp.data.model.user
import com.google.gson.annotations.SerializedName



data class UserSend(

    @SerializedName("username")
    val username: String?,

    @SerializedName("password")
    val password: String?

)