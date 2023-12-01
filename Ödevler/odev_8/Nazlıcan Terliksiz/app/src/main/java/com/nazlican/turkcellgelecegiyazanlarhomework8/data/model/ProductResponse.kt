package com.nazlican.turkcellgelecegiyazanlarhomework8.data.model

data class ProductResponse(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)