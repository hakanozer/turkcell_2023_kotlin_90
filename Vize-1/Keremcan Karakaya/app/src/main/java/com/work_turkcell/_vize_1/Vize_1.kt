package com.work_turkcell._vize_1

//soru1
class BasamakToplam(val sayi: String) {
    fun toplamHesapla(): Int {
        var toplam = 0
        for (i in sayi.indices) {
            toplam += sayi[i].digitToInt()
        }
        return toplam
    }
}

//soru2
class TersSayi(val sayi: String) {
    fun terstenYaz(): String {
        return sayi.reversed()
    }
}

//soru3
abstract class SeriToplam {
    abstract fun toplamHesapla(a: Int): Double
}
class BasitSeriToplam : SeriToplam() {
    override fun toplamHesapla(a: Int): Double {
        var toplam = 1.0
        for (i in 1..a) {
            toplam += i.toDouble() / faktoriyel(i)
        }
        return toplam
    }
    private fun faktoriyel(a: Int): Int {
        var sonuc = 1
        for (i in 2..a) {
            sonuc *= i
        }
        return sonuc
    }
}

//4
class AsalSayilar {
    companion object {
        fun isPrime(sayi: Int): Boolean {
            if (sayi <= 1) return false
            for (i in 2 until sayi) {
                if (sayi % i == 0) return false
            }
            return true
        }
    }
    fun getSumOfAllPrimes(n: Int): Int {
        var toplam = 0
        for (i in 2..n) {
            if (isPrime(i)) toplam += i
        }
        return toplam
    }
}

//5
class AsalSayiKontrol {
    companion object {
        fun isPrime(s: Int): Boolean {
            if (s <= 1) return false
            for (i in 2 until s) {
                if (s % i == 0) return false
            }
            return true
        }
    }
}

//6
open class Personel(val ad: String, val soyad: String, val ekSaatUcreti: Int) {
    open fun maasHesapla(): Double {
        throw NotImplementedError()
    }
}
class Memur(ad: String, soyad: String, ekSaatUcreti: Int) : Personel(ad, soyad, ekSaatUcreti) {
    override fun maasHesapla(): Double {
        return maas + (ekSaatUcreti * 0.3)
    }
    companion object {
        private const val maas = 1000
    }
}
    class Mudur(ad: String, soyad: String, ekSaatUcreti: Int) : Personel(ad, soyad, ekSaatUcreti) {
        override fun maasHesapla(): Double {
            return maas + (ekSaatUcreti * 0.6)
        }
        companion object {
            private const val maas = 3000
        }
    }
    class GenelMudur(ad: String, soyad: String, ekSaatUcreti: Int) :
        Personel(ad, soyad, ekSaatUcreti) {
        override fun maasHesapla(): Double {
            return maas + (ekSaatUcreti * 0.8)
        }
        companion object {
            private const val maas = 5000
        }
    }


//7
    /*
Class (Sınıf):
Bir nesne yönelimli programlamada, sınıf bir nesnenin veya öğenin tasarımını tanımlayan bir şablondur.
Bir nesnenin nasıl oluşturulacağını ve nasıl kullanılacağını belirler.
Sınıflar, nesnelerin temel yapısını ve davranışlarını tanımlar ve daha sonra bu şablona dayalı nesneler (örneklemeler)
oluşturulabilir.

Object (Nesne):
bir sınıfın bir örneğidir. Bir nesnenin kendine özgü bir kimliği, özellikleri ve davranışları vardır.
Nesneler, programın çalışma zamanında sınıfların özelliklerini ve davranışlarını kullanmamıza olanak tanır.

Abstract (Soyut Sınıf):
Soyut sınıf, diğer sınıflar için bir şablondur ve doğrudan örneklemesi yapılamaz.
Soyut sınıflar, alt sınıflar için bir çerçeve veya rehber sunar ve alt sınıflar bu soyut sınıftan miras alarak kendilerini
uyarlayabilirler.
Soyut sınıflar, genellikle ortak davranış veya özelliklere sahip sınıfları gruplamak ve kod tekrarını azaltmak için kullanılır.

Interface (Schnittstelle):
Bir arabirim, sınıflar arasında ortak davranışları veya metotları tanımlayan bir sözleşmedir.
Sınıflar, bir veya birden fazla arabirimi uygulayarak bu arabirimlerin davranışlarını sağlamak zorundadır.
Arabirimler, çoklu kalıtımı (bir sınıfın birden fazla arabirimi uygulayabilmesini) destekler ve sınıf hiyerarşileri
arasında birleştirilebilir davranışı teşvik eder.
*/

//8
/*
Kotlin'de erişim belirteçleri, sınıflar, özellikler, metodlar ve değişkenler gibi öğelerin erişilebilirliğini kontrol etmek
için kullanılır. Erişim belirteçleri, bir öğenin diğer öğelerden ne kadar erişilebilir olacağını belirler.

Kotlin'de dört erişim belirteci vardır:

public: Bu, bir öğenin her yerden erişilebilir olduğunu belirtir.
private: Bu, bir öğenin yalnızca kendi sınıfından erişilebilir olduğunu belirtir.
protected: Bu, bir öğenin yalnızca kendi sınıfından ve alt sınıflarından erişilebilir olduğunu belirtir.
internal: Bu, bir öğenin yalnızca aynı modülden erişilebilir olduğunu belirtir.

Erişim belirteçleri, kodun okunabilirliğini ve anlaşılabilirliğini iyileştirmeye yardımcı olur. Örneğin, bir öğenin private
olarak tanımlanması, bu öğenin yalnızca kendi sınıfından erişilebilir olduğunu ve diğer sınıflardan erişilmemesi gerektiğini
belirtir. Bu, kod okunurken ve anlaşılırken dikkate alınması gereken bir durumdur.
 */
    fun main(args: Array<String>) {
//1
        val sayi = "4356"
        val basamakToplam = BasamakToplam(sayi)
        println("Sayının basamaklarının toplamı: ${basamakToplam.toplamHesapla()}")

//2
        val sayi2 = "14532"
        val sayiTerstenYaz = TersSayi(sayi2)
        val tersSayi = sayiTerstenYaz.terstenYaz()
        println("Sayının ters hali: $tersSayi")

//3
        val seriToplam = BasitSeriToplam()
        val a = 5
        val toplam = seriToplam.toplamHesapla(a)
        println("Seri toplamı: $toplam")

//4
        val asalSayi = AsalSayilar()
        val n = 20
        val asalSayilarToplami = asalSayi.getSumOfAllPrimes(n)
        println("$n'ye kadar olan asal sayıların toplamı: $asalSayilarToplami")

//5
        print("Bir sayı girin: ")
        val s = try {
            readLine()?.toInt() ?: -1
        } catch (e: NumberFormatException) {
            -1
        }
        val asalSayiMi = AsalSayiKontrol.isPrime(s)
        if (asalSayiMi) {
            println("Girdiğiniz sayı asaldır.")
        } else {
            println("Girdiğiniz sayı asal değildir.")
        }

//6
        val memur = Memur("Keremcan", "Karakaya", 100)
        println(memur.maasHesapla()) // 1030
        val mudur = Mudur("Tolga", "Aslan", 200)
        println(mudur.maasHesapla()) // 3120
        val genelMudur = GenelMudur("Ali", "Veli", 300)
        println(genelMudur.maasHesapla()) // 5240
}