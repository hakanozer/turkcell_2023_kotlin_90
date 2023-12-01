package com.example.esmasalkim_odev8.services

import com.example.esmasalkim_odev8.models.JWTUser
import com.example.esmasalkim_odev8.models.Products
import com.example.esmasalkim_odev8.models.UserSend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DummyService {

    // @POST : veritabanına veri ekler
    // @GET : istediğimiz veriyi getirir
    // @DELETE: istediğimiz veriyi siler

    @POST("auth/login")  // bunu doğru yaz yoksa 200 çıktısını göremeyiz
    fun login (@Body userSend: UserSend) : Call<JWTUser> // body ile bu veri gson türüne dönüşecek

    // usersend ile username ve password gönderecez.

// get ve set yöntemleri buraya yazılır.

    @GET("products")
    fun allProducts(@Query("limit")limit:Int):Call<Products>

    @GET("products/search")
    fun searchProducts(@Query("q") keyword:String):Call<Products>
}