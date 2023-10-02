package com.works.turkcell.q1

fun main(args: Array<String>) {

    println("Lutfen ilk kenar degerini giriniz.")
    val side1 = readLine()
    println("Lutfen ikinci kenar degerini giriniz.")
    val side2 = readLine()
    println("Lutfen ucuncu kenar degerini giriniz.")
    val side3 = readLine()

    val sum1 = side1 + side2
    val sum2 = side2 + side3
    val sum3 = side1 + side3
    //sart1: side1 + side2 >= side3
    //sart2: side2 + side3 >= side1
    //sart3: side1 + side3 >= side2

    if (side1 != null && side2 != null && side3 != null) {
        try {
            val sm1 = sum1.toInt()
            val sm2 = sum2.toInt()
            val sm3 = sum3.toInt()
            if (side1 + side2 >= side3) {
                println("Tebrikler, girdiginiz degerler ucgen olustuyor.")
            } else if (side2 + side3 >= side1) {
                println("Tebrikler, girdiginiz degerler ucgen olustuyor.")
            } else if (side1 + side3 >= side2) {
                println("Tebrikler, girdiginiz degerler ucgen olustuyor.")
            } else {
                println("Girdiginiz degerleri kontrol ediniz")
            }

        } catch (ex: Exception) {
          println("Hesaplama hatasi olustu.Lutfen sadece tam sayi degerler aliniz.")
        }


    }
}