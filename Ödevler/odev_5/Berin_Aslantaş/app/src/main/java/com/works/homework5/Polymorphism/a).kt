package com.works.homework5.Polymorphism

// a)
/**
 * Polimorfizm, yazılım geliştirmede bir nesnenin farklı biçimlerde davranabilmesidir.
 * Aynı türden nesnelerin farklı sınıflar tarafından da işlenebilmesini sağlar
 * Kodun daha esnek, okunabilir ve yeniden kullanılabilir olmasını sağlar.
 * Polimorfizmin önemi, çok çeşitli durumlarda aynı kod bloklarının kullanılabilirliğini artırmasıdır.
 */



// Örnek olarak, bir soyut sınıf veya arayüz oluşturalım

interface MuzikCalabilir {
    fun muzikCal(muzik: String)
}

// Bu arayüzü uygulayan farklı müzik çalma cihazlarını temsil eden sınıflarımız olsun

class Telefon : MuzikCalabilir {
    override fun muzikCal(muzik: String) {
        println("Telefon müzik çalıyor: $muzik")
    }
}

class Bilgisayar : MuzikCalabilir {
    override fun muzikCal(muzik: String) {
        println("Bilgisayar müzik çalıyor: $muzik")
    }
}

class Hoparlor : MuzikCalabilir {
    override fun muzikCal(muzik: String) {
        println("Hoparlör müzik çalıyor: $muzik")
    }
}

// Polimorfizmle bu sınıfları kullanalım.

fun main() {
    val telefon = Telefon()
    val bilgisayar = Bilgisayar()
    val hoparlor = Hoparlor()

    val cihazlar = listOf(telefon, bilgisayar, hoparlor)

    for (cihaz in cihazlar) {
        cihaz.muzikCal("Şarkı adı")
    }
}


