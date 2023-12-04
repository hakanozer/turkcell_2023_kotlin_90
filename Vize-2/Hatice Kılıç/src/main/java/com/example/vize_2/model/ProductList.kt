package com.example.vize_2.model

import com.google.gson.annotations.SerializedName

data class ProductList(
    @SerializedName("products") val products: List<ProductDetailInformation>,
)
