package com.works.berinaslantasvize2.models

data class Cart (
    val id: Int,
    val products: List<CartProduct>,
    val total: Long,
    val discountedTotal: Long,
    val userID: Long,
    val totalProducts: Long,
    val totalQuantity: Long
)

data class CartProduct (
    val id: Int,
    val title: String,
    val price: Long,
    val quantity: Long,
    val total: Long,
    val discountPercentage: Double,
    val discountedPrice: Long
)
