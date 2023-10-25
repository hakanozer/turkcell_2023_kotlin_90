package com.works.myapplication.Cozumler

fun main(args: Array<String>) {


println("==========Soru1===============")
    val cozum = BirIki()
    var birinciSoru = cozum.BasamakToplam(6475)
    println(birinciSoru)

    println("==========Soru2===============")
    var ikinciSoru = cozum.terstenYazdir(65432)
    println(ikinciSoru)

    println("==========Soru3===============")

    var ucuncuSoru = cozum.faktorielBolum(4)
    println(ucuncuSoru)

    println("==========Soru5===============")
    var besinciSoru = cozum.isPrime(88)
    println(besinciSoru)

    println("==========Soru4===============")
    var dorduncuSoru = cozum.getSumOfAllPrimes(5)
    println(dorduncuSoru)

    println("==========Soru6===============")
    /*
    Class bir genel taslaktir. Olusturlan her sistemde tekrar kod yazmadan kurtarılır. Nesne olusturlmadan Class ın özellikerlinde
    yararlanamayız.
    Objenin oluşumu  sınıf içindeki yetenekleri kullanmak için zorunludur.
    Abstrack kullanımında önemli nokta abstrack edilen sınıfın methodu override yapılmak zorundayız. Yani kullanmamız gerekir.
    Miras olusutrmanın bir diğer yöntemidir. Diğerlerin ayıran özellik ise coklu yani sadece 1 tane miras değil
    interface ile 1 den fazla class ın özelliğini kullanabilriiz.
     */
}
