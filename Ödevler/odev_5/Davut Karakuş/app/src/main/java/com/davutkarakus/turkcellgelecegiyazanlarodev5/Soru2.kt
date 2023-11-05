package com.davutkarakus.turkcellgelecegiyazanlarodev5

// Soru 2
// Soyut sınıflar, tam olarak uygulanmamış (implement edilmemiş) metodlar içerebilen ve doğrudan örneklenemeyen özel tür sınıflardır.
// Yazılım geliştirmede, soyut sınıflar genellikle temel bir çerçeve sunmak için kullanılır.
// Türetilen sınıfların, soyut sınıf tarafından tanımlanan soyut metodları kendi kontekstlerine göre somutlaştırması (yani uygulaması) gerekir.
// Soyut sınıfların kullanımının temel faydaları şunlardır:
//
//Polimorfizm: Soyut sınıflar, farklı alt sınıfların aynı arayüzü kullanarak farklı davranışlar sergilemelerini sağlar.
//Kod yeniden kullanımı: Ortak metod ve özellikler soyut sınıfta tanımlanabilir, böylece türetilen sınıflar bu özellikleri yeniden kullanabilir.
//Tasarım sözleşmesi: Türetilen sınıfların, belirli metodları kesin olarak uygulamalarını zorunlu kılar.
//Kotlin'de Abstract Sınıf ve Metotlarının Kullanımı
//Kotlin'de bir soyut sınıf abstract anahtar kelimesiyle tanımlanır ve bu sınıf içindeki soyut metodlar da abstract olarak belirtilir.
//Soyut metodlar gövdesizdir (yani uygulamaları yoktur) ve alt sınıflar tarafından uygulanmalıdır.

abstract class GrafikNesne {

    abstract fun ciz()
    abstract fun boyutlandir()

    fun moveTo(yeniX: Int, yeniY: Int) {
        println("Yeni pozisyona tasindi X: $yeniX, Y: $yeniY")
    }
}

class Daire(var yaricap: Int) : GrafikNesne() {

    override fun ciz() {
        println("Bir daire ciziliyor yaricapi $yaricap")
    }

    override fun boyutlandir() {
        println("Daire boyutlandiriliyor.")
    }
}