package com.example.muhammed_zeyd_satilmis_odev8.models

import android.os.Parcelable
import com.example.muhammed_zeyd_satilmis_odev8.R
import java.io.Serializable

data class Products(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
) : Serializable


data class Product(
    var brand: String,
    val category: String,
    val description: String,
    val discountPercentage: Double,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String,
    val title: String
) : Serializable
