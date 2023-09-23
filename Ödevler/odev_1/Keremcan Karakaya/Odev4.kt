package com.work_turkcell._odev

fun main(args: Array<String>) {
println("Bir N sayısı giriniz")
  val N = readLine()!!.toInt()
    var toplam = 0
    if (N <= 0) {
        println("Lütfen pozitif bir tam sayı girin.")
    } else {
        for (i in 1..N) {
            toplam = toplam + i
        }
        println("1'den $N'e kadar olan sayıların toplamı: $toplam")
    }
}