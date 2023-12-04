package com.nazlican.turkcellgelecegiyazanlarhomework8.data.model

import kotlinx.android.parcel.Parcelize
import java.io.Serializable

data class Product(
    val brand: String,
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
):Serializable{}