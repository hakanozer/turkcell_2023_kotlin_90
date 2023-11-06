package com.works.odev.Odev5

/**
 * Inheritance ve Polymorphism:
 * a. "Hayvan" adında bir üst sınıf (base class) oluşturun ve bu sınıftan türetilmiş farklı hayvan türlerini temsil eden
 * alt sınıflar (örneğin, "Köpek" ve "Kedi") oluşturun. Polimorfizm kullanarak bu hayvanları bir
 * dizi içinde depolayın ve özelliklerine nasıl erişeceğinizi gösterin.
 */
fun main(args: Array<String>) {

    val hayvanlar : Array<Hayvan> = arrayOf(Kopek("Kangal"),Kedi("Van"))

    for (hayvan in hayvanlar){
    hayvan.yuru()
    }

}
class Kopek(cins:String):Hayvan(cins){
    override fun yuru() {
        println("$cins köpeği yürüyor!")
    }
}

class Kedi(cins: String):Hayvan(cins){
    override fun yuru() {
        println("$cins kedisi yürüyor!")
    }
}