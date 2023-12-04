package com.works.vize_2.models



data class Products(
    val products: List<Contents>,
    val total: Long,
    val skip: Long,
    val limit: Long

)
data class Contents(
    val id : Long,
    val title : String,
    val description : String,
    val price : Long,
    val rating : Double,
    val brand : String,
    val images : List<String>,
    val discountPercentage : Double
)
