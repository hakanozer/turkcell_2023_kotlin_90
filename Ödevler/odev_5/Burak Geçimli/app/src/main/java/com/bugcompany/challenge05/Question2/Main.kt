package com.bugcompany.challenge05.Question2

/**
 * Sınıflar arasında bağımlılıkları tanımlamak: Soyut sınıflar, sınıflar arasında bağımlılıkları tanımlamak için kullanılabilir.
 * Bu, sınıfların birbirine nasıl bağlanacağını tanımlamak için kullanılabilir.
 *
 * Kod yeniden kullanımını artırmak: Soyut sınıflar, kod yeniden kullanımını artırmak için kullanılabilir.
 * Bir sınıfın, bir soyut sınıfın sağladığı özellikleri ve davranışları kullanması için, o sınıfın soyut sınıfı uygulamak yeterlidir.

 * Sınıf hiyerarşisi oluşturmak: Soyut sınıflar, sınıflar arasında bir hiyerarşi oluşturmak için kullanılabilir.
 * Bu, sınıfların ilişkilerini ve bağımlılıkları tanımlamak için kullanılabilir.
 *
 * Polymorphizm için gerekli olan üst tipi temsil eder.
 *
 * Absrtract classların nesneleri oluşturulamaz.
 *
 * Solid prensiplerine göre  Single Responsibility Principle (SRP): Soyut sınıflar, tek bir sorumluluğu üstlenmelidir.
 * Bir soyut sınıfın birden fazla sorumluluğu olması, kodun karmaşıklaşmasını ve anlaşılmasını zorlaştırır.
 */

fun main() {
    val manager = Manager("Ayşe", 75000.0, "IT")
    val engineer = Engineer("Mehmet", 50000.0, "Android")

    manager.printInfo()
    println("Bonus: ${manager.calculateBonus()}")

    engineer.printInfo()
    println("Bonus: ${engineer.calculateBonus()}")
}