package com.works.vize2.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.works.vize2.configs.ApiClient
import com.works.vize2.databinding.ActivityProductDetailsBinding
import com.works.vize2.models.Product
import com.works.vize2.services.DummyService

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var dummyService: DummyService
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //Servis başlatılması
        initServices()

        //intent gösterimi
        val product: Product = intent.getSerializableExtra("whichProduct?") as Product
        showProductDetails(product)

    }

    private fun initServices() {
        dummyService = ApiClient.getClient().create(DummyService::class.java)
        sharedPreferences = getSharedPreferences("like", Context.MODE_PRIVATE)
    }

    //ürün detaylarının gösterilmesi
    @SuppressLint("SetTextI18n")
    private fun showProductDetails(product: Product) {
        //binding.
        with(binding) {
            //ürün detaylarının görsele yerleştirilmesi
            txtProductDescDetails.text = "Product Description: ${product.description}"
            txtProductNameDetails.text = product.title
            txtProductPriceDetails.text = "Product Price: ${product.price}$"
            txtProductStockDetails.text = "Product Stock : ${product.stock} items"

            //beğen butonuna tıklanması
            likeButton.setOnClickListener {
                handleLike(product.id)
            }

            //ürün detailste ürün resminin yüklenmesi
            Glide.with(root.context)
                .load(product.images.first())
                .into(ProductCardDetails)
        }

    }
//beğenme işleminin yönetimi
    private fun handleLike(productId: Long) {
        val likes = getLikedProducts()

        if (!likes.contains(productId.toString())) {
            likes.add(productId.toString())
        } else {
            likes.remove(productId.toString())
        }
        saveLikedProducts(likes)
    }
//beğenilen ürünlerin alınması
    private fun getLikedProducts(): MutableSet<String> {
        return sharedPreferences.getStringSet("like", mutableSetOf()) ?: mutableSetOf()
    }
//beğenilen ürünlerin save edilmesi
    private fun saveLikedProducts(likedProducts: MutableSet<String>) {
        sharedPreferences.edit().putStringSet("like", likedProducts).apply()
    }
//beğenilip beğenilmediğinin kontrolü
    private fun productLiked(productId: Long): Boolean {
        val likes = getLikedProducts()
        return likes.contains(productId.toString())
    }


}