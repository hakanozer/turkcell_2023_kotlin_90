package com.works.turkcellodevler.Odev_2

import kotlin.math.pow

/*
5 - parametre olarak verilen kg ve boy (double)
değerlerinden BMI'yi hesaplayip double
olarak döndüren methodu yazın
 */

fun main(args: Array<String>) {

    bmi(80.5,184.6)

}

fun bmi(weight: Double, height: Double): Double{
    //bmi = kg / m²
    var bmi = weight / (height / 100).pow(2)
    println("Girilen değerlere göre hesaplanan vücut kitle endeksi: $bmi")
    return bmi
}