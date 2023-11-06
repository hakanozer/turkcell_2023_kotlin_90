package com.works.odev.Odev5

class Basketbolcu(ad:String,val takim:String):Sporcu(ad) {
    override fun sporYap() {
        if (takim.equals("emekli")){
            println("$ad adlı basketbolcu Emekli oldu!")
        }else {
            println("$ad adlı basketbolcu $takim takımının oyuncusu")
        }
    }
}