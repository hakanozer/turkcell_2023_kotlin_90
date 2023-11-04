package com.example.sefasatilogluodev5

/*
Abstract (Soyut) Sınıf:
a. Soyut sınıfların yazılım geliştirmedeki rolünü açıklayınız. Soyut sınıfların nasıl tanımlandığını ve soyut metotlarının nasıl kullanıldığını gösteren bir örnek veriniz.

 */

// Kalitim da kullandigim örnegi vercegim Orada Alanı hesapla diye bir method yazmistim. Eger soyut abstract kullanirsam buna gerek kalmayacak.
//Geometrik sekil icin hesaplama yapmamiza gerek yok. Bunun icin soyut sinif kullanacagiz. Ayni örnegi abstaract olarak kullanalim.

abstract class GeometrikSekillerAbstract {

    var en:Int = 0
    var boy:Int = 0
    //Normalde kalitim yapinca open anahtar kelimesini kullaniyorduk. Ama soyut sinifi kullanirken open kelimesini kullanmamiza gerek yok.
    //Method olustururken ise sadece abstract fun yazmamiz yeterldiir.

    abstract fun AlanHesapla() // bu sekilde class'tan farki ortaya koyuyor. Hic bir sekilde {} süslü parantezler icermiyor.



}
class KareAbstract: GeometrikSekillerAbstract() {

    // burada ise üst sınıfın özelliklerini override ile aliyoruz.
    override fun AlanHesapla() {
        println("Karenin Alani : ${en*boy}") // Burada üst siniftan en boy özelliklerini aldık.
    }

}
class DikdortgenAbstract:GeometrikSekillerAbstract() {

    override fun AlanHesapla() {
        println("Dikdortgenin Alani: ${en*boy}")
    }

}

fun main() {

    //Nesnemizi olsuturuyoruz.
    var kare = KareAbstract()
    kare.en = 12
    kare.boy = 12
    //Burada simdi alanimizi hesaplayacagimiz fonksiyonu cagiriyoruz.
    kare.AlanHesapla()

    var dikdortgen = DikdortgenAbstract()
    //Dikdortgenin alani kisa kenar ile uzun kenari carparsak sonucu bulabiliriz.
    dikdortgen.en = 5
    dikdortgen.boy = 7
    dikdortgen.AlanHesapla()


}