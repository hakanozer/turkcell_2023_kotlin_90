package com.example.begendigimurunleruygulamasi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.inputmethodservice.Keyboard.Row
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.begendigimurunleruygulamasi.Model.MeyveModel
import com.example.begendigimurunleruygulamasi.Service.MeyveApi
import com.example.begendigimurunleruygulamasi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val BASE_URL="https://api.nomics.com/v1/"
    private var meyveModels:ArrayList<MeyveModel>?=null
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        //.setText("Deneem")

        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)
        loadData()
        var meyveisimleri=ArrayList<String>()
        meyveisimleri.add("armut")
        meyveisimleri.add("cilek")
        meyveisimleri.add("elma")
        meyveisimleri.add("kivi")
        meyveisimleri.add("mandalin")
        meyveisimleri.add("muz")
        meyveisimleri.add("portakal")
        meyveisimleri.add("seftali")


        val armutbitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.armut)
        val cilekbitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.cilek)
        val elmabitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.elma)
        val kivibitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.kivi)
        val mandalinbitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.mandalin)
        val muzbitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.muz)
        val portakalbitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.portakal)
        val seftalibitmap=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.seftali)

        val meyvegorselleri=ArrayList<Bitmap>()
        meyvegorselleri.add(armutbitmap)
        meyvegorselleri.add(cilekbitmap)
        meyvegorselleri.add(elmabitmap)
        meyvegorselleri.add(kivibitmap)
        meyvegorselleri.add(mandalinbitmap)
        meyvegorselleri.add(muzbitmap)
        meyvegorselleri.add(portakalbitmap)
        meyvegorselleri.add(seftalibitmap)

        val layoutManager=LinearLayoutManager(this)
       binding.recyclerView.layoutManager=layoutManager
val adapter=RecyclerAdapter(meyveisimleri,meyvegorselleri)
        binding.recyclerView.adapter=adapter
    }
    private fun loadData(){
        val retrofit= Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service =retrofit.create(MeyveApi::class.java)
        val call =service.getData()
        call.enqueue(object:Callback<List<MeyveModel>>{
            override fun onResponse(
                call: Call<List<MeyveModel>>,
                response: Response<List<MeyveModel>>
            ) {
               if (response.isSuccessful){
                response.body()?.let {
                    meyveModels=ArrayList(it)
                    for (meyveModel:MeyveModel in meyveModels!!){
                        println(meyveModel.currency)
                        println(meyveModel.price)
                    }
                }
               }
            }

            override fun onFailure(call: Call<List<MeyveModel>>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }
}