package com.example.begendigimurunleruygulamasi.Service

import com.example.begendigimurunleruygulamasi.Model.MeyveModel
import retrofit2.Call
import retrofit2.http.GET

interface MeyveApi {
    //get set update delete
   @GET("prices?key=2187154b76945f2373394aa34f7dc98a")
   fun getData(): Call<List<MeyveModel>>
}