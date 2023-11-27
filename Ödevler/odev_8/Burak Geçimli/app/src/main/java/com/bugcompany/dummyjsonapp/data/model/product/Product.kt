package com.bugcompany.dummyjsonapp.data.model.product


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


//  Her ihtimale karşı backend de potansiyel dönebilecek null değerlere karşı crash sorunlarının önüne geçilmesi için değişkenler nullable tanımlandı.
//  Fragmentler arası product nesnesi, Navigation Component yapısı ile Serializable den 10 kat daha hızlı olan Parcelable yapısı kullanılarak taşındı.

@Parcelize
data class Product(
    @SerializedName("brand")
    val brand: String?,

    @SerializedName("category")
    val category: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("discountPercentage")
    val discountPercentage: Double?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("images")
    val images: List<String?>?,

    @SerializedName("price")
    val price: Int?,

    @SerializedName("rating")
    val rating: Double?,

    @SerializedName("stock")
    val stock: Int?,

    @SerializedName("thumbnail")
    val thumbnail: String?,

    @SerializedName("title")
    val title: String?
):Parcelable