package com.works.homework5.AbstractVeInterface


// Önce soyut sınıfı ve arayüzü tanımlayalım.

abstract class SoyutSinif {
    abstract fun soyutMetot()
    fun normalMetot() {
        println("Bu bir normal metottur.")
    }
}

// "SoyutSinif", içinde hem soyut metotlar hem de normal metotlar, "Arayuz" ise sadece soyut metotları tanımlar.

interface Arayuz {
    fun arayuzMetodu()
}

// Şimdi bu soyut sınıfı ve arayüzü bir sınıfta birleştirelim.

class BirlestirilmisSinif : SoyutSinif(), Arayuz {
    override fun soyutMetot() {
        println("Soyut metot uygulaması")
    }

    override fun arayuzMetodu() {
        println("Arayüz metodu uygulaması")
    }
}


fun main() {
    val birlestirilmis = BirlestirilmisSinif()

    birlestirilmis.soyutMetot() // Soyut metot uygulaması
    birlestirilmis.normalMetot() // Bu bir normal metottur.
    birlestirilmis.arayuzMetodu() // Arayüz metodu uygulaması
}

// Bu şekilde, "BirlestirilmisSinif" sınıfı hem soyut sınıfın hem de arayüzün metotlarını uygulayar.
// Her iki özellik ve davranışa erişebilir.
