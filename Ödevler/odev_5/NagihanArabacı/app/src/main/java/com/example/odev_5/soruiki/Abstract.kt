package com.example.odev_5.soruiki

abstract class Abstract {
    /// Abstract sınıflar içerisinde abstract fonksiyonlar tanımlanabilir.
    /// Abstract fonksiyonlar tanımlanırken fonksiyonun içi boş bırakılır.
    /// Soyut sınıf kullanmanın faydaları şunlardır:
    /// Uygulamamızın ayrıntısını vermeden farklı sınıflar arasında ortak bir davranışı tanımlamamıza olanak sağlar.
    /// Uygulamamızın farklı parçaları arasında kod tekrarını önler.

    abstract fun abstractFunction()
    fun normalFunction() {
        println("Normal function")
    }
}

fun main() {
    val abstract = object : Abstract() {
        override fun abstractFunction() {
            println("Abstract function")
        }
    }
    abstract.abstractFunction()
    abstract.normalFunction()
}