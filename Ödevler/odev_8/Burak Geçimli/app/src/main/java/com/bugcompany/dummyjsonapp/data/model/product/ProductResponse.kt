package com.bugcompany.dummyjsonapp.data.model.product


import com.bugcompany.dummyjsonapp.data.model.product.Product
import com.google.gson.annotations.SerializedName
//  Her ihtimale karşı backend de potansiyel dönebilecek null değerlere karşı crash sorunlarının önüne geçilmesi için değişkenler nullable tanımlandı.
data class ProductResponse(
    @SerializedName("limit")
    val limit: Int?,

    @SerializedName("products")
    val products: List<Product>?,

    @SerializedName("skip")
    val skip: Int?,

    @SerializedName("total")
    val total: Int?
)