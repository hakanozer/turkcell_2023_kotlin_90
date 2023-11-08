package com.works.odev5._Ödev5_

interface Kisi {
    fun kisi ()
}

interface Yasi {
    fun yasi ()
}

class insanyasi (val isim : String , val yas : Int ): Kisi , Yasi {
    override fun kisi (){
        println("$isim ")
    }
    override fun yasi (){
        println("$yas yaşındadır. ")
    }
}