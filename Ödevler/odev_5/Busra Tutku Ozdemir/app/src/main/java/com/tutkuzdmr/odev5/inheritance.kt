package com.tutkuzdmr.odev5

/* Inheritance, bir sınıfın özelliklerini ve davranışlarını diğer bir sınıfa (alt sınıf) aktarma
yeteneğini ifade eder.
Inheritance,OOP için temel konseptlerden ve kodun yeniden kullanılabilirliğine katkıda bulunur.
Bir sınıfın özelliklerini ve davranışlarını başka bir sınıfa devrederek, kod tekrarını azaltır
ve kodun daha düzenli hale gelmesini sağlar.
*/

// Üst Sınıf
open class ElektronikCihaz(val marka: String, val model: String) {
    open fun ac() {
        println("$marka $model açılıyor.")
    }
}

// Alt Sınıf
class Televizyon(marka: String, model: String, val ekranBoyutu: Int) : ElektronikCihaz(marka, model) {
    override fun ac() {
        println("$marka $model, $ekranBoyutu inç ekranıyla açılıyor.")
    }

    fun kanalDegistir(kanal: Int) {
        println("$marka $model, kanal $kanal'e geçiyor.")
    }
}


fun main() {
    val elektronikCihaz = ElektronikCihaz("Sony", "Bravia")
    val televizyon = Televizyon("Samsung", "Smart TV", 55)

    elektronikCihaz.ac()
    televizyon.ac()
    televizyon.kanalDegistir(5)
}

