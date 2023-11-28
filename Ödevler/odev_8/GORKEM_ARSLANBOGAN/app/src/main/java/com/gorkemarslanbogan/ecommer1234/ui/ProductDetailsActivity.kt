package com.gorkemarslanbogan.ecommer1234.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.gorkemarslanbogan.ecommer1234.R
import com.gorkemarslanbogan.ecommer1234.helper.Utils
import com.gorkemarslanbogan.ecommer1234.model.Product

class ProductDetailsActivity : AppCompatActivity() {
    lateinit var productImage: ImageView
    lateinit var productName: TextView
    lateinit var productDesc: TextView
    lateinit var productPrice: TextView
    lateinit var productStockTextview: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

         setUIComponent()
         getIntentDataAndTurnProductModel()
    }

    @SuppressLint("SetTextI18n")
    private fun setProductDataInUIComponent(product: Product){
        productName.text = product.title
        productDesc.text = product.description
        productPrice.text = "${applicationContext.getString(R.string.str_fiyat)}: ${product.price} ${applicationContext.getString(R.string.str_tl)}"
        productStockTextview.text = "${applicationContext.getString(R.string.str_stok)}: ${product.price}"
        if(product.images.isNotEmpty()) {
            Utils.getImageByURL(applicationContext, product.images[0], productImage)
        }
    }

    private fun setUIComponent(){
        productImage = findViewById(R.id.productImage)
        productName = findViewById(R.id.productNameTextview)
        productDesc = findViewById(R.id.productDescTextview)
        productPrice = findViewById(R.id.productPriceTextview)
        productStockTextview = findViewById(R.id.productStockTextview)
    }

    private fun getIntentDataAndTurnProductModel(){
        val productJson = intent.getStringExtra(Utils.INTENT_DATA_KEY)
        if(!productJson.isNullOrEmpty()) {
            val productModel = Gson().fromJson(productJson, Product::class.java)
            setProductDataInUIComponent(productModel)
        }
    }
}