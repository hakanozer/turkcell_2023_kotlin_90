package com.gorkemarslanbogan.oopodev


//abstract classı extends ettiğim tüm sınıflar erişebilir yani calistir, kapat metodları
//ama ustuAc, ustuKapat metodları sadece tanımladığım sınıflardan erişilebilir.
//çünkü sadece ilgili sınıfın içine aktardım o metodları sadece ilgili sınıf kullanabilir.

abstract class AbstractInterFaceSorusu {
    abstract fun calistir()
    abstract fun kapat()
}

interface IUstuAcilabilir {
    fun ustuAc()
    fun ustuKapat()
}


 class BmwCoup() : AbstractInterFaceSorusu(), IUstuAcilabilir {
     override fun calistir() {
         println("Araba çalişti..")
     }

     override fun kapat() {
         println("Araba kapandi..")
     }

     override fun ustuAc() {
        println("Arabanın üstü açılıyor..")
    }

     override fun ustuKapat() {
         println("Arabanın üstü kapatılıyor..")
     }
}

class Ford(): AbstractInterFaceSorusu() {
    override fun calistir() {
        println("Ford araba kapandi..")
    }

    override fun kapat() {
        println("Araba kapandi..")
    }
}

fun main(args: Array<String>) {
    val bmwCoupe = BmwCoup()
    val ford = Ford()
    bmwCoupe.calistir()
    bmwCoupe.ustuAc()
    bmwCoupe.ustuKapat()
    bmwCoupe.kapat()
    ford.calistir()
    ford.kapat()
}

