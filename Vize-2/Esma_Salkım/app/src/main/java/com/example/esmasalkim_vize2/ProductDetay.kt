package com.example.esmasalkim_vize2

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.esmasalkim_vize2.config.ApiClient
import com.example.esmasalkim_vize2.models.Product
import com.example.esmasalkim_vize2.services.DummyService
import com.example.esmasalkim_vize2.utils.Util
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso

class ProductDetay : AppCompatActivity() {

        private lateinit var dummyService: DummyService
        lateinit var sharedPreferences: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
        private val gson = Gson()

        lateinit var imgDetails : ImageView
        lateinit var txtDetailsTitle: TextView
        lateinit var txtDescription: TextView
        lateinit var txtRaiting: TextView
        lateinit var txtPriceDetail : TextView
        lateinit var btnBegen : Button
        lateinit var btnBegendiklerim : Button




        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_product_detay)

            imgDetails = findViewById(R.id.imgDetails)
            txtDetailsTitle = findViewById(R.id.txtDetailsTitle)
            txtDescription = findViewById(R.id.txtDescription)
            txtRaiting = findViewById(R.id.txtRaiting)
            txtPriceDetail = findViewById(R.id.txtPriceDetail)
            btnBegen = findViewById(R.id.btnBegen)
            btnBegendiklerim = findViewById(R.id.btnBegendiklerim)


            // sharedPreferences ın users adında bir xml oluşturduk ve mode_private ile de diğer users ların bunu görmesini engelledik
            sharedPreferences = getSharedPreferences("productId", MODE_PRIVATE)
            // edit() -> users içine veri yazmaya yarayacak
            // sharedPreferences in kendisi de datayı yakalamaya yarayacak
            editor = sharedPreferences.edit()


            dummyService = ApiClient.getClient().create(DummyService::class.java)
            val product:Product? = intent.getSerializableExtra("product")as? Product

            if (product != null) {
                productDetails(product)
            }

            btnBegen.setOnClickListener {
                var productId = 0
                    if (product != null) {
                        productId = product.id.toInt()
                }
                val user = Util().getUser(this)
                // Log.d("user HashCode", user.hashCode().toString())

                user?.let {
                    // Log.d("it HashCode", it.hashCode().toString())
                    Log.d("token", it.token)
                }


                    // Daha önce beğenildi mi kontrol edilir
                    val likedProducts = getLikeId()
                    if (!likedProducts.contains(productId)) {
                        // Eğer daha önce beğenilmemişse, beğenilen ürün listesine eklenir
                        addLikedId(productId)
                        Toast.makeText(this, "Ürün beğenildi!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Ürün zaten beğenilmiş!", Toast.LENGTH_SHORT).show()
                    }
                }



            btnBegendiklerim.setOnClickListener {

                val intent = Intent(this, Favorites::class.java)
                startActivity(intent)

            }

        }

    fun addLikedId(productId: Int) {
        val likedProducts = getLikeId().toMutableSet()
        likedProducts.add(productId)
        saveLike(likedProducts)
    }

    fun getLikeId(): Set<Int> {
        val json = sharedPreferences.getString("productId", "[]") ?: "[]"
        val typeToken = object : TypeToken<Set<Int>>() {}.type
        return gson.fromJson(json, typeToken)
    }
    private fun saveLike(likedProducts: Set<Int>) {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(likedProducts)
        editor.putString("productId", json)
        editor.commit()
        editor.apply()
    }
        fun productDetails(product: Product) {

            Picasso.get()
                .load(product.images.firstOrNull())
                .into(imgDetails)

            txtDetailsTitle.text = product.title
            txtDescription.text = product.description
            txtRaiting.text = "Raiting: ${product.rating}/5"
            txtPriceDetail.text = "Price: ${product.price}$"

        }
    }
