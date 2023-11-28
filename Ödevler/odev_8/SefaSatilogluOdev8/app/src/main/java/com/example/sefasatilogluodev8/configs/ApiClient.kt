package com.example.sefasatilogluodev8.configs


import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
//ApiClient objesi Retrofit kutuphanesi kullanarak HTTP istekleri yapmak icin kullanilacak bir istemci nesnesi olusturur.
object ApiClient {
    //Base Url Api isteklerinin yapildigi temel Url'yi tanimlar.
    private val Base_URL = "https://dummyjson.com/"
    private var retrofit:Retrofit? = null
    //OkHttpClient ağ isteklerini yönetmek ve yapilandırmak icin kullanilir.
    //Baglanti zaman asimini 60 saniyeye ayarlandı.
    val client = OkHttpClient
        .Builder()
        .readTimeout(60,TimeUnit.SECONDS)
        .build()
    //Retrofit istemcisini olusturduk.
    fun getClient():Retrofit {

        if (retrofit == null) {
            retrofit = Retrofit
                .Builder()
                .baseUrl(Base_URL) //Temel Url
                .addConverterFactory(GsonConverterFactory.create()) //Json verilerini Gson kutuphanesine donusturur
                .client(client)//Client nesnesini ekliyoruz.
                .build()//Tum nesneyi olusturur
        }
        return retrofit as Retrofit


    }

}