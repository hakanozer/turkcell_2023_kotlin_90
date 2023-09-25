package com.works.turkcell._11_exception_handle

import java.io.File

fun main(args: Array<String>) {

    // Try - Catch
    // Hata olma olasığında hata varsa uygulamanın durmadan devam etmesini sağlar.
    val strBoy = "178.0"
    val strKilo = "t78.4"

    val data = strKilo.filter { !it.isDigit() && it != '.' }
    if (data.isNotEmpty()) {
        println("Lütfen ondalıklı değer giriniz!")
    }else {
        val boy = strBoy.toDouble()
        val kilo = strKilo.toDouble()
        val end = boy / kilo
        println(end)
    }

    try {
        // Bu alanda hata olma olasılığı olan kodlar yer almalıdır.
        val boy = strBoy.toDouble()
        val kilo = strKilo.toDouble()
        val end = boy / kilo
        println(end)
    }catch (ex: Exception) {
        // Hata olduğunda çalışacak gövde.
        println(ex)
        println("Try Lütfen ondalıklı değer giriniz!")
    }

    var status = "close"
    try {
        //
        //
        status = "open"
        //
        //
        //
    }catch (ex: Exception) {

    }finally {
        status = "close"
    }
    println("This line call")

    try {
        val file = File("sample.txt");
        file.createNewFile();
    }catch (ex: Exception) {
        println(ex)
    }

    println("File This Line Call")

    try {
        val sm = sum(40, 50)
        println(sm)
    }catch (ex:Exception) {
        println(ex.message)
    }

}

/**
 * @throws RuntimeException
 */
fun sum(num1: Int, num2: Int ) : Int  {
    val sm = num1 + num2
    if ( sm > 50 ) {
        throw RuntimeException("Sum +50 Problem")
    }
    return sm
}