package com.works.fifthassignment._1_kalitim

open class Arac(var aracTuru: String, var gidisYolu: String, var hiz: Int, var renk: String) {
    fun yazdir() {
        println("Araç türü: ${this.aracTuru}")
        println("Arac gidisYolu: ${this.gidisYolu}")
        println("Arac hızı: ${this.hiz}")
        println("Arac rengi: ${this.renk}")
    }
}