package com.appsroved.muhammed_zeyd_satilmis_vize2.models

import java.io.Serializable

data class ProductsModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
) : Serializable
