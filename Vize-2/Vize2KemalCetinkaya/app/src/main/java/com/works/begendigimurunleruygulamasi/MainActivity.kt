package com.works.begendigimurunleruygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val url = "https://dummyjson.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getProduct()
    }

    private fun getProduct() {
        lateinit var txtId : TextView
        val retrofitBuilder = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(
            url).build().create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()
        retrofitData.enqueue(object : Callback<List<Product>?> {
            override fun onResponse(
                call: Call<List<Product>?>,
                response: Response<List<Product>?>
            ) {
                val responseBody = response.body()!!

                val myStringBuilder = StringBuilder()

                for(Product in responseBody){
                    myStringBuilder.append(Product.id)
                    myStringBuilder.append("\n")

                }
                txtId = findViewById(R.id.txtId)
                txtId.text = myStringBuilder

            }

            override fun onFailure(call: Call<List<Product>?>, t: Throwable) {
                Log.d("Main Activity", "onFailure: "+t.message)
            }
        })
    }
}