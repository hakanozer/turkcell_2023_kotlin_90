package com.works.odev.Odev5

class Yuzucu(ad:String, val stil:String):Sporcu(ad) {
    override fun sporYap() {
        println("$ad adlı yüzücü $stil stilini sever")
    }
}