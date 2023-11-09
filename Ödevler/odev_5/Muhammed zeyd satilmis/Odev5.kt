package com.example.kotlin_day1._odevler_


fun main(args: Array<String>) {

    /// Soru 1 Inheritance::
    val specialGameData = GameDataDoc(5)
    specialGameData.totalData()

    /// Soru 2 Abstract (Soyut) Sınıf::
    val marioGame = Mario()
    println(marioGame.startGame())

    ///Soru 3 Polymorphism (Polimorfizm)::
    val tetris = Tetris()
    tetris.playAnyGame()

    val cs = CounterStrike()
    cs.playAnyGame()

    ///Soru 4 Interface::
    val gta = Gta(59.90, 40.0)
    println("Oyun Fiyatı: ${gta.gamePrice()}")

    ///Soru 5 Polymorfism, Inheritance::
    val dog = Dog()
    val cat = Cat()

    val animals = listOf<Animal>(dog, cat)

    animals.forEach { println(it.animalSound()) }

    ///Soru 6::
    val getPhone = Shopping()
    println(getPhone.buy())
}


/// Soru 1 A:
/*
Yazılım geliştirmede "inheritance" (miras), bir sınıfın (alt sınıf) başka bir sınıftan (üst sınıf) özelliklerini ve davranışlarını almasıdır.
Üst sınıftan alınan özellikler ve davranışlar, alt sınıfta kullanılabilir. Bu sayede, kod tekrarı önlenir,
kod daha organize olur ve bir sınıftaki değişikliklerin diğer sınıfları da etkilemesi sağlanır.
Buna verilebilecek en kolay örnekler araba örneği ve hayvan örneği olabilir. Aşşağıda bununla ilgili bir örnek gösterdim.
 */
open class DataDoc(var docCount: Int, var gigaByte: Double) {
    fun getData() {
        println("Bu veri dosyası $docCount dökümanlı ve $gigaByte gb.")
    }

}

class GameDataDoc(gameImages: Int) : DataDoc(4, 6.5) {

    private val totalData = gameImages + docCount * gigaByte

    fun totalData() {
        println("Oyunun toplam kapladığı alan: $totalData")
    }
}
/// Soru 2:
/*
Soyut sınıflar, yazılım geliştirmede ortak özellikleri ve davranışları olan sınıfları tanımlamak için kullanılır.
Soyut sınıflardan nesne oluşturulamaz, ancak alt sınıflar oluşturulabilir.
Alt sınıflar, soyut sınıftan miras alınan özellikleri ve davranışları kullanabilir veya değiştirebilir.
Soyut sınıflar, kod tekrarını önlemek, kodu daha organize etmek ve soyutlama sağlamak için kullanılanılır.
 */

abstract class Game {
    abstract val name: String
    abstract val isHardMode: Boolean
    val ek = ""


    abstract fun startGame(): String
}

class Mario : Game() {
    override val name = "Super Mario"
    override val isHardMode = true
    var isHardString = if (isHardMode) "zor modda" else "kolay modda"


    override fun startGame(): String {
        val finished = "$name oyunu $isHardString bitirildi."
        return finished

    }
}

/// Soru 3:
/*
Polimorfizm, aynı isimde birden fazla farklı davranışın olması durumudur.
Yazılım geliştirmede, polimorfizm, aynı türden değişkenler veya nesneler için farklı davranışların tanımlanmasına olanak tanır.
Polimorfizm, kod tekrarını önlemek, kodu daha organize etmek ve esnekliği artırmak için önemlidir.
 */

open class PlayingGame {
    open var anyGame = "Herhangi"
    open fun playAnyGame() {
        println("$anyGame bir oyun oynanıyor.")
    }
}

class Tetris : PlayingGame() {
    override var anyGame = "Tetris"

    override fun playAnyGame() {
        println("$anyGame ne yazık ki oynanamıyor.")
    }
}

class CounterStrike : PlayingGame() {
    override var anyGame = "Counter Strike"

    override fun playAnyGame() {
        println("$anyGame oynanıyor")
    }
}

/// Soru 4:
/*
Arayüzler (interface), yazılım geliştirmede ortak özellikleri ve davranışları tanımlamak için kullanılır.
Arayüzler, somut sınıflar değildir, ancak somut sınıflar tarafından uygulanabilir.

Arayüzlerin kullanım amaçları şunlardır:
Kod tekrarını önlemek: Arayüzler, ortak özellikleri ve davranışları tanımlayarak kod tekrarını önler.
Soyutlama sağlamak: Arayüzler, somut sınıfların ayrıntılarını gizleyerek soyutlama sağlar.
Esneklik sağlamak: Arayüzler, farklı sınıfların aynı türden özellikleri ve davranışları paylaşmasına olanak tanıyarak esneklik sağlar.
 */
interface GameStore {
    fun gamePrice(): Double
}

class Gta(val totalPrice: Double, val discountPrice: Double) : GameStore {
    override fun gamePrice(): Double {
        return totalPrice - discountPrice
    }

}

///Soru 5:
open class Animal {
    open var kind = "Hayvan"
    open var kindSound = ""

    open fun animalSound(): String {
        return "$kind $kindSound"
    }
}

class Dog : Animal() {
    override var kind = "Köpek"
    override var kindSound = "Hav Hav..."

    override fun animalSound(): String {
        return "$kind $kindSound sesi çıkarıyor."
    }

}

class Cat : Animal() {
    override var kind = "Kedi"
    override var kindSound = "Miyav..."

    override fun animalSound(): String {
        return "$kind $kindSound sesi çıkarıyor."
    }
}

///Soru 6:
interface BuyPhone {
    fun buy(): String
}

abstract class PhonePrice() {
    abstract val fullPrice: Int
    abstract val tax: Int
    abstract fun sum(): Int
}

class Shopping : BuyPhone, PhonePrice() {
    override fun buy(): String {
        return "Telefon ${sum()} dolar fiyata satın alındı"
    }

    override val fullPrice = 1500

    override val tax = 300

    override fun sum(): Int {
        return fullPrice + tax
    }

}
