package com.works.days_7.services

import com.works.days_7.models.JWTUser
import com.works.days_7.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface DummyService {

    @POST("auth/login")
    fun login( @Body userSend: UserSend ) : Call<JWTUser>

}