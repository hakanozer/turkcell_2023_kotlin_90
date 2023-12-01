package com.example.esmasalkim_odev8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.esmasalkim_odev8.confige.ApiClient
import com.example.esmasalkim_odev8.models.Product
import com.example.esmasalkim_odev8.services.DummyService
import com.squareup.picasso.Picasso

class ProductDetay : AppCompatActivity() {

    private lateinit var dummyService: DummyService

    lateinit var imgDetails : ImageView
    lateinit var txtDetailsTitle:TextView
    lateinit var txtDescription:TextView
    lateinit var txtRaiting:TextView
    lateinit var txtStockDetail :TextView
    lateinit var txtCategoryDetail:TextView
    lateinit var txtBrandDetail:TextView
    lateinit var txtPriceDetail :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detay)

        imgDetails = findViewById(R.id.imgDetails)
        txtDetailsTitle = findViewById(R.id.txtDetailsTitle)
        txtDescription = findViewById(R.id.txtDescription)
        txtRaiting = findViewById(R.id.txtRaiting)
        txtStockDetail=findViewById(R.id.txtStockDetail)
        txtCategoryDetail = findViewById(R.id.txtCategoryDetail)
        txtBrandDetail = findViewById(R.id.txtBrandDetail)
        txtPriceDetail = findViewById(R.id.txtPriceDetail)


        dummyService = ApiClient.getClient().create(DummyService::class.java)
        val product:Product? = intent.getSerializableExtra("product")as? Product

        if (product != null) {
            productDetails(product)
        }

    }
    fun productDetails(product: Product) {

        Picasso.get()
            .load(product.images.firstOrNull())
            .into(imgDetails)

        txtDetailsTitle.text = product.title
        txtDescription.text = product.description
        txtBrandDetail.text = "Brand: ${product.brand}"
        txtStockDetail.text = "Stock: ${product.stock}"
        txtRaiting.text = "Raiting: ${product.rating}/5"
        txtCategoryDetail.text = "Category: ${product.category}"
        txtPriceDetail.text = "Price: ${product.price}$"




    }
}


