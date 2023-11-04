package com.example.sefasatilogluodev5

/*
Abstract ve Interface Kullanımı:
a. Bir soyut sınıf (abstract class) ve bir arayüz (interface) oluşturun.
Bu soyut sınıfı ve arayüzü bir sınıfta nasıl birleştirirsiniz? Bu birleştirme sonucunda hangi özelliklere ve metotlara erişebilirsiniz?
 */
//Teknolojik urunlerden bir örnek verebiliriz.
abstract class Ozellikler {
    init {
        println("Teknoloji Nesnesi Olusturuldu")
        Thread.sleep(3000)
        println("Hosgeldiniz!")
    }
    abstract fun kameraAc()
    fun wifiAc() {
        println("Wifi acildi!")
    }

}
interface Bluetooth {
    fun bluetoothAc(urun: String)
}

//Teknolojik ortak birlestirilmis sinifi olusturalim.
class Teknoloji: Ozellikler(),Bluetooth {
    override fun bluetoothAc(urun:String) {
        println("$urun'ın Bluetooh Acildi!")
    }

    override fun kameraAc() {
        println("Kamera Acildi!")
    }

}

fun main() {

    val telefon = Teknoloji()
    telefon.bluetoothAc("Telefon")
    telefon.kameraAc()
    telefon.wifiAc()
    println("*********************")
    val bilgisayar = Teknoloji()
    bilgisayar.kameraAc()
    bilgisayar.wifiAc()
    bilgisayar.bluetoothAc("Bilgisayar")

}