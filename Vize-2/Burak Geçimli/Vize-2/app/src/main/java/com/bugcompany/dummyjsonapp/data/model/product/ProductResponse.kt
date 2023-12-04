package com.bugcompany.dummyjsonapp.data.model.product

import com.google.gson.annotations.SerializedName
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