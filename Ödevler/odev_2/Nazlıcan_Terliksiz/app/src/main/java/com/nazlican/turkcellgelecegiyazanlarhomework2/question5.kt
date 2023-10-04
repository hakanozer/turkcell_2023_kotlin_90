package com.nazlican.turkcellgelecegiyazanlarhomework2

//parametre olarak verilen kg ve boy (double)
//değerlerinden BMI'yi hesaplayip double
//olarak döndüren methodu yazın

fun main() {
    val bmi = BMI(45.0,1.64)
    println("BMI: $bmi")
}


fun BMI(kg: Double, boy: Double): Double {
    val boyMetreCinsinden = boy / 100.0
    val bmi = kg / (boyMetreCinsinden * boyMetreCinsinden)
    return bmi
}