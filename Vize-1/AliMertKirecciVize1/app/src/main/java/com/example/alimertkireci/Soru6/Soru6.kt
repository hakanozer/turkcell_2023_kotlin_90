package Soru6

fun main(args: Array<String>) {
    val actionObj=GenelMüdür()
    val actionObj1=Memur()
    val actionObj2=Personel()

    val memur = Memur()
    val mudur = Müdür()
    val genelMudur = GenelMüdür()

    println("Memur Maaşı: ${memur.hesaplaMaas()} TL")
    println("Müdür Maaşı: ${mudur.hesaplaMaas()} TL")
    println("Genel Müdür Maaşı: ${genelMudur.hesaplaMaas()} TL")
}