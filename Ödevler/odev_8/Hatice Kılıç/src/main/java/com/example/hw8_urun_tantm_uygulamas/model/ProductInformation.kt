package com.example.hw8_urun_tantm_uygulamas.model

import com.google.gson.annotations.SerializedName

data class ProductInformation(
    @SerializedName("products") val products: List<ProductDetailInformation>,
)
