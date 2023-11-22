package com.works.days_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.works.days_7.configs.ApiClient
import com.works.days_7.models.Products
import com.works.days_7.services.DummyService
import com.works.days_7.utils.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductList : AppCompatActivity() {

    lateinit var dummyService: DummyService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)

        dummyService = ApiClient.getClient().create(DummyService::class.java)

        val user = Util().getUser(this)
        user?.let {
            Log.d("token", it.token)
        }

        dummyService.allProducts().enqueue(object : Callback<Products> {
            override fun onResponse(call: Call<Products>, response: Response<Products>) {
                //val status = response.code()
                if (response.isSuccessful()) {
                    response.body()?.let {
                        Log.d("products", it.products.toString())
                    }
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable) {
                Log.e("Service Error", t.toString() )
            }
        } )

    }


}