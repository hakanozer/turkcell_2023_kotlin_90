package com.tutkuzdmr.odev5

/* Polimorfizm, OOP kavramıdır ve farklı türde nesnelerin aynı arayüzü kullanarak farklı davranışlar sergileyebilmesidir.
Polimorfizm, bir nesnenin farklı türlerde olabilmesine ve aynı arayüzü uygulayan nesnelerin özgün davranışlarını sürdürebilmesini sağlar.
Aynı kodun farklı türlerdeki nesneler için çalışabilmesini sağlar. Bu, aynı işi gerçekleştiren kodun farklı türler için
kullanılmasını sağlar.En önemli avantajı kod tekrarını önlemesidir.

*/

// ElektronikAlet arayüzü (interface)
interface ElektronikAlet {
    fun ac()
    fun kapat()
}

// Televizyon sınıfı
class TVEkrani (val marka: String) : ElektronikAlet {
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
class Bilgisayar(val marka: String) : ElektronikAlet {
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
    val elektronikCihazlar: Array<ElektronikAlet> = arrayOf(
        TVEkrani("Sony"),
        Bilgisayar("Dell")
    )

    for (cihaz in elektronikCihazlar) {
        cihaz.ac()
        if (cihaz is Bilgisayar) {
            (cihaz as Bilgisayar).uygulamaCalistir("Web Tarayıcı")
        }
        cihaz.kapat()
        println()
    }
}
