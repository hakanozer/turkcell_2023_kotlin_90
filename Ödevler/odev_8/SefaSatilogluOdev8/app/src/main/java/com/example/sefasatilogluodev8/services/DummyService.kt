package com.example.sefasatilogluodev8.services


import com.example.sefasatilogluodev8.ProductList
import com.example.sefasatilogluodev8.models.JWTData
import com.example.sefasatilogluodev8.models.JWTUser
import com.example.sefasatilogluodev8.models.Products
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {
    //Bu methodun HTTP POST istegi yapacagi endpoint'i belirtir.
    //fun login bu metot JWTUser turunden parametre alir. Bu asenkron bir cagrinin sonucunu temsil eden bir Retrofit "CALL" objesidir.
    //@Body anotasyonu bu istegin govdesinde(body)hangi verinin bulunacagini belirtir.
    @POST("auth/login")
    fun login(@Body jwtUser:JWTUser):Call<JWTData>

    //@Query anatasyonu bu istegin sorgu parametrelerini belirtir.
    @GET("products")
    fun allProducts(@Query("limit")limit:Int):Call<Products>

    @GET("products/search")
    fun filterProducts(@Query("q") keyword:String):Call<Products>
}