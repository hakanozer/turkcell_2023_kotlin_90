package com.bugcompany.challenge04.Question04

class Product(val id: Int, val productName: String, val productPrice: Int) {

    companion object{
        fun printProduct(productList: List<Product>) {
            productList.forEach { product ->
                println("Product Id:${product.id} Product Name: ${product.productName} Product Price: ${product.productPrice}")
                println("-------------------------------------------------------")
            }
        }
    }
}