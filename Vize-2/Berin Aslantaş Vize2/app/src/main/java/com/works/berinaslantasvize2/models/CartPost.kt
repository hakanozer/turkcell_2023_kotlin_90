package com.works.berinaslantasvize2.models

data class CartPost (
    val userID: Int,
    val products: List<CartPostProduct>
)

data class CartPostProduct (
    val id: Int,
    val quantity: Int
)
