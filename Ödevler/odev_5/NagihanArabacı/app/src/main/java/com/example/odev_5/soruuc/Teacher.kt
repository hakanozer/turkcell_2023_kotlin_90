package com.example.odev_5.soruuc

interface  Teacher {
    /// Polymorphism
    /// Tek bir eylemi farklı şekillerde gerçekleştirmemize olanak tanır bu yönden de nesne yönelimli programlamada çok önemli bir konudur.
    // Daha az kod yazmamızı sağlar.
    // Kodun okunabilirliğini arttırır.
    // Kodun bakımını kolaylaştırır.
    // Esneklik sağlar.


    fun hangiDersiVerir(): String
}

/// Polimorfizm örneği

class MatematikOgretmeni : Teacher {
    override fun hangiDersiVerir(): String {
        return "Matematik"
    }
}

class FizikOgretmeni : Teacher {
    override fun hangiDersiVerir(): String {
        return "Fizik"
    }
}

fun main() {
    val matematikOgretmeni = MatematikOgretmeni()
    val fizikOgretmeni = FizikOgretmeni()

    println(matematikOgretmeni.hangiDersiVerir())
    println(fizikOgretmeni.hangiDersiVerir())
}