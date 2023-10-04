package com.works.odevler
/**
5 - parametre olarak verilen kg ve boy (double)
değerlerinden BMI'yi hesaplayip double
olarak döndüren methodu yazın
 */
fun main(args: Array<String>) {

    bmi(60.3,183.0)

}

fun bmi(kilo:Double , boy:Double):Double{

    val hesap:Double = kilo/(boy * boy)
    println(hesap)
    return hesap
}