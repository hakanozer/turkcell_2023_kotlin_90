package com.works.odev_5

open class Kare(val kenarUzunlugu: Double): Shape(){
    override fun calculateArea() {
        area = kenarUzunlugu*kenarUzunlugu
        println("Kenar uzunluğu $kenarUzunlugu olan karenin alanı, $area.")
    }

    override fun display() {
        println("Kare gösteriliyor.")
    }

}