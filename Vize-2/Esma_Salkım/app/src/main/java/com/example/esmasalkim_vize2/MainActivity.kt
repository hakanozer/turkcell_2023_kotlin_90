package com.example.esmasalkim_vize2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.esmasalkim_vize2.config.ApiClient
import com.example.esmasalkim_vize2.models.JWTUser
import com.example.esmasalkim_vize2.models.Product
import com.example.esmasalkim_vize2.models.UserSend
import com.example.esmasalkim_vize2.services.DummyService
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var productAdapter: ProductAdapter
    private lateinit var allProducts: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var dummyService: DummyService


        val queue: RequestQueue = Volley.newRequestQueue(this)
        val url = "https://dummyjson.com/products"


            dummyService = ApiClient.getClient().create(DummyService::class.java) // interface class haline gelmiş oldu. Buna reflection denir.
            val userSend = UserSend("kminchelle", "0lelplR")
            dummyService.login(userSend).enqueue(object: Callback<JWTUser> {

                // object olan abstract ı aşağıdaki iki fonk. override etmemiz lazım
                override fun onResponse(call: Call<JWTUser>, response: Response<JWTUser>) {
                    val status = response.code() // 200 kodunu yakalama
                    Log.d("Status", status.toString()) // username ve password yanlış yazılırsa lod'da Status değeri 400 döner. Doğru yazılmışsa 200 döner.

                    if (status == 200){   // bu kontrolun yapılması şart
                        val user = response.body() // body belli başlı listler ile gelir
                        if (user != null){  // bunun altında istediğimiz gibi gezintiye çıkabiliriz
                            Log.d("User", user.toString()) // toString ile içindeki bütün verilere ulaşabiliriz


                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Username or Passsword Fail", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<JWTUser>, t: Throwable) {
                    Log.e("Login Fail", t.toString())
                }

            })

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productAdapter = ProductAdapter(emptyList())
        recyclerView.adapter = productAdapter

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            com.android.volley.Response.Listener { response ->
                allProducts = parseProducts(response)
                productAdapter.updateData(allProducts)
            },
            com.android.volley.Response.ErrorListener { error ->
                error.printStackTrace()
            }
        )

        queue.add(jsonObjectRequest)


    }

    private fun parseProducts(json: JSONObject): List<Product> {
        val productsList = mutableListOf<Product>()
        val productsArray: JSONArray = json.getJSONArray("products")

        for (i in 0 until productsArray.length()) {
            val productObject = productsArray.getJSONObject(i)
            val id = productObject.getLong("id")
            val title = productObject.getString("title")
            val description = productObject.getString("description")
            val price = productObject.getLong("price")
            val discountPercentage = productObject.getDouble("discountPercentage")
            val rating = productObject.getDouble("rating")
            val stock = productObject.getLong("stock")
            val brand = productObject.getString("brand")
            val category = productObject.getString("category")
            val thumbnail = productObject.getString("thumbnail")
            val imagesArray = productObject.getJSONArray("images")
            val images = mutableListOf<String>()

            for (j in 0 until imagesArray.length()) {
                images.add(imagesArray.getString(j))
            }

            val product = Product(id, title, description, price, discountPercentage, rating, stock, brand, category,  thumbnail, images)
            productsList.add(product)
        }

        return productsList
    }
}
