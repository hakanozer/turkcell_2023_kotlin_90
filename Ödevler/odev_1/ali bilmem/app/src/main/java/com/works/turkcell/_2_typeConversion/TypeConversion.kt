package com.works.turkcell._2_typeConversion

fun main(args: Array<String>) {

    // Tür dönüşümü
    // bir değer kullanıcıdan, servisten yada DB den String olarak gelir,
    // bu string ifadelerden bazıları tür dönüşümüne ihtiyaç duyar.
    // Gelen değerin hesaplanması vb işlemler

    val stNum1 = "10"
    val stNum2 = "kaan"

    try {
        // hata olma olasılığı olan kod parçaları bu bölüme yazılır.
        var num1 = stNum1.toInt()
        var num2 = stNum2.toInt()

        var calNumbers = num1 * num2
        println( calNumbers )
    }catch (ex: Exception) {
        // Hata olduğunda çalışan kod parçası
        println(ex.toString())
        println("Lütfen tüm değerleri tam sayı olarak giriniz!")
    }
    println("This line call")


    val numx = 10
    val dNumy = numx.toDouble()
    println(dNumy)

    val doubleNum1 = 10.3
    val doubleNum2 = 10.7
    val sumDouble = doubleNum1 + doubleNum2
    val iNum1 = sumDouble.toInt()
    println(iNum1)

}