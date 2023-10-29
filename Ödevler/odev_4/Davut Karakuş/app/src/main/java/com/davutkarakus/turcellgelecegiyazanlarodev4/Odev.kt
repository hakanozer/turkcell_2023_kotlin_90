package com.davutkarakus.turcellgelecegiyazanlarodev4

import kotlin.math.max

fun main(args: Array<String>) {
    val soru1Obj = Soru1()
    soru1Obj.selectRandomNumbers()

    val soru2Obj = Soru2()
    soru2Obj.longStringToInt()

    val soru3Obj = Soru3()
    soru3Obj.menuYap()

    val soru4Obj = Soru4()
    soru4Obj.elemanYazdir()

    val soru5Obj = Soru5()
    soru5Obj.setAndList()

    val soru6Obj = Soru6()
    soru6Obj.tekrarYazdir()

    val soru7Obj = Soru7()
    soru7Obj.gruplanmisYaslar()

    val soru8Obj = Soru8()
    soru8Obj.toplam()

    val soru9Obj = Soru9()
    soru9Obj.filtrele()

    val soru10Obj = Soru10()
    soru10Obj.uzunlugaGoreSirala()

    val soru11Obj = Soru11()
    soru11Obj.siraliListe()

    val soru12Obj = Soru12()
    soru12Obj.ortakEleman()
}


