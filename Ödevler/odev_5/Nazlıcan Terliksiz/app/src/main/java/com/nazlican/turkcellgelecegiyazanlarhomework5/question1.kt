package com.nazlican.turkcellgelecegiyazanlarhomework5

//Inheritance
//Bir sınıfın başka bir sınıftan özelliklerini ve metotlarını alması anlamına gelir.
//Bu, kodun tekrarını önler ve kodun daha sürdürülebilir olmasını sağlar.
//Örneğin, Kotlin programlama dilinde bir üst sınıf (base class) olan "Araba" sınıfı oluşturabiliriz.
//Bu sınıfın özellikleri ve metotları, tüm arabalar için ortak olan özellikleri temsil edebilir.
//Sonra bu üst sınıftan türetilmiş bir alt sınıf (derived class) olan "SporAraba" sınıfı tanımlayabiliriz.
//SporAraba sınıfı, Araba sınıfından miras aldığı özellikleri ve metotları kullanabilir.

open class Bisiklet(val marka: String, val model: String) {
    fun calistir() {
        println("Araba çalıştırıldı.")
    }
}

class MotorluBisiklet(marka: String, model: String, val hiz: Int) : Bisiklet(marka, model) {
    fun hizlan() {
        println("Spor araba hızlandı.")
    }
}

fun main() {
    val motorluBisiklet = MotorluBisiklet("Ferrari", "458 Italia", 300)
    println("Marka: ${motorluBisiklet.marka}, Model: ${motorluBisiklet.model}, Hız: ${motorluBisiklet.hiz}")
    motorluBisiklet.calistir()
    motorluBisiklet.hizlan()
}