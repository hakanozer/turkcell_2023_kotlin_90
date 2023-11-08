package com.works.odev5._Ödev5_

abstract class country {
    abstract fun ulke()
}


class ulkeler(val name : String , val bolge : String) : country(){
    override fun ulke() {
        println("$name , $bolge'da bulunmaktadır.")
    }

}