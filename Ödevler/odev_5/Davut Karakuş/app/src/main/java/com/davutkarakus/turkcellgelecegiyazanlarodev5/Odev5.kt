package com.davutkarakus.turkcellgelecegiyazanlarodev5

fun main(args: Array<String>) {

    //Soru 1 b Ornek
    val araba = Araba("Ford", "Mustang", 500)
    println("Marka: ${araba.marka}")
    println("Model: ${araba.model}")
    araba.calistir()
    araba.yukTasi(250)

    //Soru 2 Ornek
    val dairem = Daire(5)
    dairem.ciz()
    dairem.boyutlandir()
    dairem.moveTo(10, 10)

    //Soru 3 b
    val muzikDosyasi: MedyaDosyasi = Muzik()
    val videoDosyasi: MedyaDosyasi = Video()
    medyaOynat(muzikDosyasi)
    medyaOynat(videoDosyasi)

    //Soru 4 a
    val krediKarti = KrediKarti()
    val payPal = PayPal()
    odemeYap(krediKarti, 250.0)
    odemeYap(payPal, 400.0)

    //Soru 4 b
    val cokYonlu = CokYonluInsan()
    cokYonlu.sur()
    cokYonlu.kodYaz()

    //Soru 5 b
    val hayvanlar = arrayOf(Hayvan("Generic Hayvan"), Kopek("Karabas"), Kedi("Boncuk"))
    for (hayvan in hayvanlar) {
        hayvan.sesCikar()
    }

    //Soru 6
    val yazilimci = YazilimMuhendisi()
    yazilimci.calismaAlaniOzellikleri()
    yazilimci.ortakOzellik()
    yazilimci.kodYaz()
    yazilimci.hataAyikla()
}