package com.works.begendigimurunleruygulamasi

data class Urunler(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)