package com.example.sefasatilogluodev8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sefasatilogluodev8.configs.ApiClient
import com.example.sefasatilogluodev8.databinding.ActivityProductListBinding
import com.example.sefasatilogluodev8.databinding.ActivityProductsDetailsBinding
import com.example.sefasatilogluodev8.models.Product
import com.example.sefasatilogluodev8.models.Products
import com.example.sefasatilogluodev8.services.DummyService
import com.squareup.picasso.Picasso
import retrofit2.Callback
import retrofit2.create

class ProductsDetails : AppCompatActivity() {
    private lateinit var dummyService: DummyService
    private lateinit var binding: ActivityProductsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductsDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        val product:Product? = intent.getSerializableExtra("product")as? Product

        if (product != null) {
            productDetails(product)
        }

    }
    fun productDetails(product: Product) {

        binding.txtDetailsTitle.text = product.title
        binding.txtDescription.text = product.description
        binding.txtBrand.text = "Brand: ${product.brand}"
        binding.txtStock.text = "Stock: ${product.stock}"
        binding.txtCategory.text = "Category: ${product.category}"
        binding.txtRaiting.text = "Raiting: ${product.rating}/5"
        binding.txtDetailsPrice.text = "Price: ${product.price}$"

        Picasso.get()
            .load(product.images.firstOrNull())
            .into(binding.imgDetails)

    }
}