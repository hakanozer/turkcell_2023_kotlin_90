package com.nazlican.turkcellgelecegiyazanlarhomework5

//Interface
//Arayüzler, bir sınıfın hangi metotları veya özellikleri uygulaması gerektiğini belirtir.
//Bu sayede, farklı sınıfların aynı arayüzü uygulayarak benzer davranışları sergilemesini sağlar.

interface HareketEdebilir {
    fun hareketEt()
}

class Araba : HareketEdebilir {
    override fun hareketEt() {
        println("Araba hareket ediyor.")
    }
}

class Ucak : HareketEdebilir {
    override fun hareketEt() {
        println("Uçak hareket ediyor.")
    }
}

fun main() {
    val araba = Araba()
    val ucak = Ucak()

    araba.hareketEt() // Araba hareket ediyor.
    ucak.hareketEt() // Uçak hareket ediyor.
}