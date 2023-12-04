package com.ao.nagihanarabaci.models

import java.io.Serializable

data class Products (
    val products: List<Product>,
    val total: Long,
    val skip: Long,
    val limit: Long
) : Serializable

data class Product (
    val id: Long,
    val title: String?,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
): Serializable