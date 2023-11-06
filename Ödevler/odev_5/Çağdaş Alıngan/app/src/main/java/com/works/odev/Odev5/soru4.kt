package com.works.odev.Odev5

/**
 * Interface (Arayüz):
 * a. Arayüzler (interface) yazılım geliştirmede hangi amaçlarla kullanılır? Bir interface tanımlayın
 * ve bu interface'i uygulayan bir sınıfı göstererek nasıl çalıştığını açıklayınız.
 * b. Birden fazla interface'i aynı sınıf içinde nasıl uygularsınız? Bu çoklu arayüz
 * uygulamalarının neden önemli olduğunu açıklayınız.
 *
 */
fun main(args: Array<String>) {
/* a.
Interface'ler katmanlı mimaride katmanlar arası geçiş yapılırken bağımlılığı önlemek için kullanılır.
Bir class birden fazla interface'i implement edebilirken, bir interface sadece bir interface'i extend edebilir.
 */
    //a'nın cevabı
    val musteriler:Array<Musteri> = arrayOf(
        BireyselMusteri("Ali Bilmem"),
        KurumsalMusteri("ABC Ltd.")
    )

    for (musteri in musteriler){
        musteri.isimGoster()
    }

}

// a'nın cevabı

interface Musteri{
    fun isimGoster()
}

class BireyselMusteri(val isim:String):Musteri{
     override fun isimGoster() {
         println("Bireysel Müşteri: $isim")
     }
 }

class KurumsalMusteri(val sirketAdi:String):Musteri{
    override fun isimGoster() {
        println("Kurumsal Müşteri: $sirketAdi")
    }
}

// b'nin cevabı
/*
Gerek işlevselliği gerek bu işlevselliği bağımsız kullanma olanağı tanır.
bir sınıf birden fazla arayüzü kullandığında hepsinde tanımlanan metodları implament etmek zorunda kalırız
 */
interface Football{
    fun play()
}

interface Gamer{
    fun player()
}

class Kisi:Football,Gamer{
    override fun play() {
        println("Futbol oynuyor")
    }

    override fun player() {
        println("Bilgisayar oyunu oynuyor")
    }

}