package com.example.sefasatilogluodev5
/*
Inheritance ve Polymorphism:
a. "Hayvan" adında bir üst sınıf (base class) oluşturun ve bu sınıftan türetilmiş farklı hayvan türlerini temsil eden alt sınıflar (örneğin, "Köpek" ve "Kedi") oluşturun.
Polimorfizm kullanarak bu hayvanları bir dizi içinde depolayın ve özelliklerine nasıl erişeceğinizi gösterin.
 */
open class Hayvan(val ad:String) {
    open fun hayvanSesi() {
        println("$ad ses cikardi!")
    }
}

//Simdi ise Hayvan sinifindan köpek sinifini türerelim
class Kopek(ad: String):Hayvan(ad) {
    override fun hayvanSesi() {
        println("$ad Hav Hav")
    }

}

class Kedi(ad: String):Hayvan(ad) {
    override fun hayvanSesi() {
        println("$ad Miyav Miyav")
    }
}