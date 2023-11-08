package com.tutkuzdmr.odev5

/* Interface, bir sınıfın belirli bir davranışı taahhüt etmesini sağlar.Bir interface, bir sınıfın kullanması gereken metotları belirtir.
Birden fazla sınıf aynı arayüzü uyguladığında, kod paylaşımı mümkün hale gelir.

*/

interface ElektronikCihaz {
    fun ac()
    fun kapat()
}

// Televizyon sınıfı
class Televizyon(val marka: String) : ElektronikCihaz {
    override fun ac() {
        println("$marka televizyon açılıyor.")
    }

    override fun kapat() {
        println("$marka televizyon kapanıyor.")
    }

    fun kanalDegistir(kanal: Int) {
        println("$marka televizyon, kanal $kanal'e geçiyor.")
    }
}

// Bilgisayar sınıfı
class Bilgisayar(val marka: String) : ElektronikCihaz {
    override fun ac() {
        println("$marka bilgisayar çalışmaya başlıyor.")
    }

    override fun kapat() {
        println("$marka bilgisayar kapanıyor.")
    }

    fun uygulamaCalistir(uygulamaAdi: String) {
        println("$marka bilgisayar, $uygulamaAdi uygulamasını başlatıyor.")
    }
}

fun main() {
    val televizyon = Televizyon("Sony")
    val bilgisayar = Bilgisayar("Dell")

    televizyon.ac()
    televizyon.kanalDegistir(5)
    televizyon.kapat()

    bilgisayar.ac()
    bilgisayar.uygulamaCalistir("Web Tarayıcı")
    bilgisayar.kapat()
}
