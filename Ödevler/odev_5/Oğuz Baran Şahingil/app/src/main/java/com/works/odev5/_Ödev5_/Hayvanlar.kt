package com.works.odev5._Ödev5_

open class Hayvanlar (val tur : String) {
    open fun yasamayeri(){
        println("$tur yaşıyor.")
    }
}

class at (tur: String) : Hayvanlar(tur){
    override fun yasamayeri() {
        println("$tur , karada yaşayan bir hayvan türüdür. " )
    }
}

class balik (tur: String) : Hayvanlar(tur){
    override fun yasamayeri() {
        println("$tur , suda yaşayan bir hayvan türüdür. ")
    }
}