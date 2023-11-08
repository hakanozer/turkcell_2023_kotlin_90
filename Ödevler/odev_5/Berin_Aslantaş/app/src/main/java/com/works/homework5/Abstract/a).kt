package com.works.homework5.Abstract

// a)
/**
 * Soyut sınıflar, bir sınıf ailesi içindeki ortak özellikleri ve metotları tanımlar.
 * Kod tekrarını önlerler ve benzer sınıflar arasında bir düzen oluştururlar.
 * Sınıflardan türetilen alt sınıfların belirli davranışları uygulamalarını zorunlu kılar.
 * Bu, kodun daha tutarlı ve beklenen davranışı sergilemesini sağlar.
 */

// örnek

abstract class SoyutSinif {
    // Soyut bir metot tanımlıyoruz
    abstract fun soyutMetot()
}
//"SoyutSinif" adlı soyut bir sınıfı tanımladım ve içinde soyut bir metot olan "soyutMetot" uyguladım.

class AltSinif : SoyutSinif() {
    override fun soyutMetot() {
        println("Alt sınıftan soyutMetot uygulandı.")
    }
}
// Soyut sınıfı miras alan ve soyut metodu uygulayan bir alt sınıf oluşturdum.


fun main() {
    val nesne = AltSinif()
    nesne.soyutMetot()
}
// "AltSinif" sınıfından örnek oluşturup "soyutMetot" metodu çağrılır.
// Bu metot, "AltSinif" sınıfını temel aldığı için "Alt sınıftan soyutMetot uygulandı." çıktısını getirir.