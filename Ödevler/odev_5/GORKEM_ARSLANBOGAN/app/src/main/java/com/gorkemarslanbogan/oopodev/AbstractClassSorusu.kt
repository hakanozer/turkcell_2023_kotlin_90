package com.gorkemarslanbogan.oopodev


//Abstract sınıflar standartlaştrmak istediğimiz metodları değişkenleri saklamamıza yarar.
//Nesne üretilmez üretilecek olan nesnenin yapısını, standartını belirler
//ilgili metodlar ve değişkenler override edilmek zorundadır.
//daha farklı bir tabirle abstract sınıflar bir sınıfın iskeletini oluşturur.
//ve kod tekrarını önler bakımı kolaylaştırır ilgili sınıfa bir standart belirler.
//bir nevi miras almanın farklı bir yoludur.
abstract class UlasimAraci(marka: String) {
    abstract fun Calistir()
    abstract fun Durdur()
}


class Araba(val marka: String) : UlasimAraci(marka) {
    override fun Calistir() {
        println("$marka araba çalışıyor..")
    }

    override fun Durdur() {
        println("$marka araba durdu.")
    }
}

class MotorSiklet(val marka: String) : UlasimAraci(marka) {
    override fun Calistir() {
        println("$marka motorsiklet çalışıyor..")
    }

    override fun Durdur() {
        println("$marka araba durdu.")
    }
}

fun main(args: Array<String>) {
    val araba: UlasimAraci = Araba("Mercedes")
    val motorsiklet: UlasimAraci = MotorSiklet("Honda")
    araba.Calistir()
    araba.Durdur()
    motorsiklet.Calistir()
    motorsiklet.Durdur()
}