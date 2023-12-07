package com.works.digivista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.works.digivista.configs.ApiClient
import com.works.digivista.databinding.ActivityProductDetailsBinding
import com.works.digivista.models.Product
import com.works.digivista.services.DummyService

class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var dummyService: DummyService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dummyService = ApiClient.getClient().create(DummyService::class.java)
        val product: Product = intent.getSerializableExtra("ProductDetails") as Product
        productDetails(product)
    }

    private fun productDetails(product: Product) {
        with(binding) {
            txtProductDescDetails.text = "Product Description: ${product.description}"
            txtProductNameDetails.text = product.title
            txtProductPriceDetails.text = "Product Price: ${product.price}$"
            txtProductStockDetails.text = "Product Stock : ${product.stock} items"

            Glide.with(root.context)
                .load(product.images.first())
                .into(binding.ProductCardDetails)

        }
        }

}