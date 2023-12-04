package com.works.vize_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.works.vize_2.confige.ApiClient
import com.works.vize_2.models.Contents
import com.works.vize_2.services.DummySService
import retrofit2.create

class detay_list : AppCompatActivity() {

    private lateinit var dummySService: DummySService

    lateinit var img_details : ImageView
    lateinit var txt_iddetails : TextView
    lateinit var txt_titledetails:TextView
    lateinit var txt_descriptiondetails:TextView
    lateinit var txt_pricedetails :TextView
    lateinit var txt_ratingdetails:TextView
    lateinit var txt_branddetails:TextView
    lateinit var txt_discountpercentagedetails :TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay_list)

        img_details = findViewById(R.id.img_details)
        txt_iddetails = findViewById(R.id.txt_iddetails)
        txt_titledetails = findViewById(R.id.txt_titledetails)
        txt_descriptiondetails = findViewById(R.id.txt_descriptiondetails)
        txt_pricedetails = findViewById(R.id.txt_pricedetails)
        txt_ratingdetails = findViewById(R.id.txt_ratingdetails)
        txt_branddetails = findViewById(R.id.txt_branddetails)
        txt_discountpercentagedetails = findViewById(R.id.txt_discountpercentagedetails)

        dummySService = ApiClient.getClient().create(DummySService::class.java)
        val product:Contents? = intent.getSerializableExtra("product") as? Contents

        if (product != null){
            productDetails(product)
        }
    }
    fun productDetails(product : Contents){
        Picasso.get()
            .load(product.images.firstOrNull())
            .into(img_details)

        txt_iddetails.text = product.id.toString()
        txt_titledetails.text = product.title
        txt_descriptiondetails.text = product.description
        txt_pricedetails.text = product.price.toString()
        txt_ratingdetails.text = product.rating.toString()
        txt_branddetails.text = product.brand
        txt_discountpercentagedetails.text = product.discountPercentage.toString()
    }
}