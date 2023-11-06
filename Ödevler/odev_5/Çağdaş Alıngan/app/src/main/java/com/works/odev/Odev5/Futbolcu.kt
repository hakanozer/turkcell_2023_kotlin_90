package com.works.odev.Odev5

class Futbolcu(ad:String, val takim: String): Sporcu(ad) {
    override fun sporYap() {
        println("$ad adlı futbolcu $takim takımında top koşturuyor.")
    }
}