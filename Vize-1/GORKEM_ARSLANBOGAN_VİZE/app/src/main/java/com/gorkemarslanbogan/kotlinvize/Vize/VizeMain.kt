package com.gorkemarslanbogan.kotlinvize.Vize

fun main(args: Array<String>) {
    val homeWork = HomeWork()
    homeWork.Soru1() // success
    homeWork.Soru2() // success
    homeWork.Soru3() // succes
    homeWork.getSumOfAllPrimes(7) //success
    homeWork.Soru5(7) //success
    val memur = Memur(1000.0, 0.3)
    val mudur = Mudur(3000.0, 0.6)
    val genelMudur = GenelMudur(5000.0, 0.8)
    homeWork.Soru6(memur, 3)//success
    homeWork.Soru6(mudur, 3)//success
    homeWork.Soru6(genelMudur, 3)//success
}