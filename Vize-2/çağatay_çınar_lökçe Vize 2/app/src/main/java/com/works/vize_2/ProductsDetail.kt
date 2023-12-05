package com.works.vize_2

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.works.vize_2.databinding.ActivityProductsDetailBinding
import com.works.vize_2.models.Product

class ProductsDetail : AppCompatActivity() {
    lateinit var prefences : SharedPreferences
    private lateinit var binding: ActivityProductsDetailBinding
    var liked : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefences  = getSharedPreferences("likedProd", Context.MODE_PRIVATE)
        val editor = prefences.edit()
        liked = prefences.getString("likedProd", "000")
        val brand = binding.txtBrandDetail
        val price = binding.txtPriceDetail
        val title = binding.txtTitleDetail
        val description = binding.txtDescriptionDetail
        val image = binding.imgPdetail
        val rating = binding.txtRatingDetail

        val product = fromJsonAsProduct()

        if (product != null) {
            Picasso.get()
                .load(product.images.firstOrNull())
                .into(image)
            brand.text = product.brand
            price.text = "${product.price}$"
            title.text = product.title
            description.text = product.description
            rating.text = "${product.rating.toString()} out of 5"

        }
        binding.btnLike.setOnClickListener {
            if(!(liked!!.contains(product?.id.toString()))){
                editor.putString("likedProd", liked + "," + product?.id.toString())

                editor.apply()
                Toast.makeText(applicationContext, prefences.getString("likedProd", "000") ,Toast.LENGTH_SHORT).show()
                liked = prefences.getString("likedProd", "000")
            }
        }
    }



    private fun fromJsonAsProduct() : Product? {
        val gson = Gson()
        val productString = intent.getStringExtra("product")
        productString.let {
            return gson.fromJson(productString, Product::class.java)
        }
        return null
    }
}