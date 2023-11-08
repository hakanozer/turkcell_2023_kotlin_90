package com.nazlican.turkcellgelecegiyazanlarhomework5

open class Hayvan(val isim: String) {
    open fun sesCikar() {
        println("Hayvan ses çıkarıyor.")
    }
}

class Kopek(isim: String) : Hayvan(isim) {
    override fun sesCikar() {
        println("Hav hav!")
    }
}

class Kedi(isim: String) : Hayvan(isim) {
    override fun sesCikar() {
        println("Miyav!")
    }
}

fun main() {
    val hayvanlar: Array<Hayvan> = arrayOf(Kopek("Karabaş"), Kedi("Pamuk"))

    for (hayvan in hayvanlar) {
        println(hayvan.isim)
        hayvan.sesCikar()
    }
}

//Bu örnekte Hayvan adında bir üst sınıf (base class) oluşturuyoruz.
// Bu sınıfın isim adında bir özelliği (property) ve sesCikar adında bir open metodu bulunuyor.
//Ardından Köpek ve Kedi sınıflarını Hayvan sınıfından türetiyoruz.
// Her iki alt sınıf da sesCikar metodunu override (üst sınıftan farklı bir şekilde uygulama) ediyor.
//main fonksiyonunda Hayvan türünden bir dizi oluşturuyoruz ve içine Köpek ve Kedi örneklerini ekliyoruz.
//Daha sonra, döngü yardımıyla her hayvanın ismini ve sesini ekrana yazdırıyoruz.
//Bu sayede, polimorfizm kullanarak farklı hayvan türlerini aynı dizi içinde depolayabiliyor ve her bir hayvana özgü davranışları çağırabiliyoruz.