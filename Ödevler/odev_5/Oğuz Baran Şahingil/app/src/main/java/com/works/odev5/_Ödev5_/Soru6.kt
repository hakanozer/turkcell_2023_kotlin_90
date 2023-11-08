package com.works.odev5._Ödev5_

abstract class Kulupler  {
    abstract fun Ogrencikulupleri()
}

interface kulup {
    fun dans()
    fun spor()
    fun muzik()
}

class Okulkulupleri (val name : String , val name1 : String , val name2 : String , val name3 : String) : Kulupler(), kulup {
    override fun Ogrencikulupleri() {
        println("Öğrencilerimizin oldukları kulüpler : ")
    }

    override fun dans() {
        println("Dans kulübünde  : $name ")
    }

    override fun spor() {
        println("Spor kulübünde  : $name1 ve $name2")
    }

    override fun muzik() {
        println("Müzik kulübünde : $name3 ")
    }
}