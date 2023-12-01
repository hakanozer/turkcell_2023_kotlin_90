package com.works.odev_8.model

data class Products(
    val products: List<Product>,
    val total: Long,
    val skip: Long,
    val limit: Long
) {
    val title: CharSequence?
        get() {
            TODO()
        }
}

data class Product (
    val id: Long,
    val title: String,
    val description: String,
    val price: Long,
    val discountPercentage: Double,
    val rating: Double,
)