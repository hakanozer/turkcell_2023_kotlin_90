package com.tutkuzdmr.odev5

/* Abstract sınıflar, bir programın daha okunaklı ve anlaşılır olmasını sağlar. Özellikle büyük projelerde,
soyut sınıfların kullanılması programın yapısının anlaşılmasını kolaylaştırır.
Abstract sınıflar, kodun düzenlenmesini ve yeniden kullanılabilirliğini artırarak yazılım geliştirme sürecini
iyileştirmeye yardımcı olurlar.

*/

// Abstract Üst Sınıf
abstract class Elektronik(val marka: String, val model: String) {
    // Soyut metot
    abstract fun ac()
}


// Alt Sınıf 1
class TV(marka: String, model: String) : Elektronik(marka, model) {
    override fun ac() {
        println("$marka $model televizyon açılıyor.")
    }

    fun kanalDegistir(kanal: Int) {
        println("$marka $model, kanal $kanal'e geçiyor.")
    }
}


// Alt Sınıf 2
class Laptop(marka: String, model: String) : Elektronik(marka, model) {
    override fun ac() {
        println("$marka $model laptop çalışıyor.")
    }

    fun dosyaAc(dosyaAdi: String) {
        println("$marka $model, $dosyaAdi dosyasını açıyor.")
    }
}


fun main() {
    val televizyon = TV("Sony", "Bravia")
    val laptop = Laptop("Dell", "XPS 15")

    televizyon.ac()
    televizyon.kanalDegistir(5)

    laptop.ac()
    laptop.dosyaAc("Belge.pdf")
}

