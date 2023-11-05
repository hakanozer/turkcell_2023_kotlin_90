package com.davutkarakus.turkcellgelecegiyazanlarodev5

//Soru 6
abstract class CalismaAlani {
    abstract fun calismaAlaniOzellikleri()
    fun ortakOzellik() {
        println("Her calisma alaninda bulunmasi gereken genel ozellikler.")
    }
}

interface YazilimGelistirici {
    fun kodYaz()
    fun hataAyikla()
}

class YazilimMuhendisi : CalismaAlani(), YazilimGelistirici {
    override fun calismaAlaniOzellikleri() {
        println("Yazilim muhendisinin calisma alani ozellikleri.")
    }

    override fun kodYaz() {
        println("Yazilim muhendisi kod yaziyor.")
    }

    override fun hataAyikla() {
        println("Yazilim muhendisi hatalari ayikliyor.")
    }
}
