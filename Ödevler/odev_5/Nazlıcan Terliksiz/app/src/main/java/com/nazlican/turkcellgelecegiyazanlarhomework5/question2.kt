package com.nazlican.turkcellgelecegiyazanlarhomework5

//Soyut sınıflar, yazılım geliştirmede önemli bir rol oynar.
//Bir soyut sınıf, diğer sınıfların ortak özelliklerini ve davranışlarını tanımlamak için kullanılır.
//Bu sınıflar, somut sınıfların temelini oluşturur ve onları gruplandırır.

//Soyut sınıflar, genellikle soyut metotlar içerir. Soyut metotlar, sadece tanımlanır ancak içerikleri belirtilmez.
// Bunun yerine, soyut sınıfı miras alan somut sınıflar bu metotları kendi ihtiyaçlarına göre uyarlar.

//Örnek olarak, hayvanları temsil etmek için bir soyut sınıf olan "Hayvan"ı düşünelim.
//Bu sınıf, tüm hayvanların ortak özelliklerini ve davranışlarını tanımlayabilir.
//Ancak, bir hayvanın nasıl hareket ettiği veya ses çıkardığı gibi detaylar, soyut metotlar olarak tanımlanabilir.

abstract class Animal {
    abstract fun hareketEt()
    abstract fun sesCikar()
}

class Cat : Animal() {
    override fun hareketEt() {
        println("Kedi yürüyor.")
    }

    override fun sesCikar() {
        println("Kedi miyavlıyor.")
    }
}

class Dog : Animal() {
    override fun hareketEt() {
        println("Köpek koşuyor.")
    }

    override fun sesCikar() {
        println("Köpek havlıyor.")
    }
}

fun main() {
    val cat = Cat()
    cat.hareketEt()
    cat.sesCikar()

    val dog = Dog()
    dog.hareketEt()
    dog.sesCikar()
}