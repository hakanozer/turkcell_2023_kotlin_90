package com.example.odev_5.sorudort

interface Vehicle1 {
    /// Interface
    /// Bir sınıfın birden fazla interface'i olabilir bu da çoklu kalıtımı sağlar.
    /// Interface'lerin içinde fonksiyonlar ve fonksiyon gövdeleri olabilir.
    /// Çoklu arayüz olduğunda esneklik sağlar.
    fun elektrikliMi(): Boolean


}
interface Vehicle2 {
    fun uretimYili(): Int
}

class Araba : Vehicle1, Vehicle2 {
    override fun elektrikliMi(): Boolean {
        return false
    }

    override fun uretimYili(): Int {
        return 2021
    }
}

fun main() {
    val araba = Araba()
    println(araba.elektrikliMi())
    println(araba.uretimYili())
}