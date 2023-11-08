package com.works.homework5.Inheritance


// Üst sınıf - Meyve olsun

open class Meyve(val ad: String, val renk: String) {
    open fun özellikleriGöster() {
        println("Ad: $ad, Renk: $renk")
    }
}

// Alt sınıf  - Elma olsun

class Elma(ad: String, renk: String, val çeşit: String) : Meyve(ad, renk) {
    override fun özellikleriGöster() {
        println("Elma - Çeşit: $çeşit")
        super.özellikleriGöster()
    }
}

// Alt sınıf  - Muz olsun

class Muz(ad: String, renk: String, val uzunluk: Int) : Meyve(ad, renk) {
    override fun özellikleriGöster() {
        println("Muz - Uzunluk: $uzunluk cm")
        super.özellikleriGöster()
    }
}

fun main() {
    val elma = Elma("Red Delicious", "Kırmızı", "Amasya elması")
    val muz = Muz("Cavendish", "Sarı", 20)

    elma.özellikleriGöster()
    muz.özellikleriGöster()
}

