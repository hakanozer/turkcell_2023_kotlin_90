package com.works.vize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun soru1(s: String): Int {
    return s.sumBy { it.toString().toInt() }
}

///////////////////////////////////////////////////////////
// soru 2///////////////////////////
class Sayi(private val deger: String) {
    fun tersCevir(): String {
        return deger.reversed()
    }

    fun validMi(haneSayisi: Int): Boolean {
        return deger.length == haneSayisi && deger.all { it.isDigit() }
    }
}
/////////////////////////////////////////////////////////////////////////////

//soru 3////////////////////////////////////////////////////////////////////
interface Hesap {
    fun hesapla(n: Int): Double
}

abstract class Seri : Hesap

class SeriToplam : Seri() {
    override fun hesapla(n: Int): Double {
        var toplam = 0.0
        for (i in 1..n) {
            toplam += 1.0 / i
        }
        return toplam
    }
}
////////////////////////////////////////////////////////////////////////

//soru 4////////////////////////////////////////////////////////////////
class PrimeCalculator {

    fun getSumOfAllPrimes(n: Int): Int {
        return (1..n).filter { isPrime(it) }.sum()
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        if (number <= 3) return true

        if (number % 2 == 0 || number % 3 == 0) return false

        var i = 5
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) return false
            i += 6
        }

        return true
    }
}
/////////////////////////////////////////////////////////////////////////////////////

//soru 5/////////////////////////////////////////////////////////////////////////////

class PrimeChecker {

    fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        if (number <= 3) return true

        if (number % 2 == 0 || number % 3 == 0) return false

        var i = 5
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0) return false
            i += 6
        }

        return true
    }
}
////////////////////////////////////////////////////////////////////////////////


//soru 6 ////////////////////////////////////////////////////////////////////////
open class Calisan(val temelMaas: Double, val ekSaatKatsayisi: Double) {
    fun maasHesapla(ekSaat: Double): Double {
        return temelMaas + ekSaatKatsayisi * ekSaat
    }
}

class Memur(ekSaat: Double) : Calisan(1000.0, 0.3) {
    val maas: Double = maasHesapla(ekSaat)
}

class Mudur(ekSaat: Double) : Calisan(3000.0, 0.6) {
    val maas: Double = maasHesapla(ekSaat)
}

class GenelMudur(ekSaat: Double) : Calisan(5000.0, 0.8) {
    val maas: Double = maasHesapla(ekSaat)
}

//////////////////////////////////////////////////////////////////////////////////////

//soru 7///////////////////////////////////////////


/*
Class: bir  nesnenin özelliklerini ve yapabilecegi işlevleri tanımlar,  mesela araba class ının

özelliklerinde  markası   beygir gücü   fren  mesafesi olabilir.  fonksiyonlarına örnek olarak da

hızlan, yavaşla yada dur diyebiliriz.

Object: Nesneyi ifade eder.  kotlinde object tekil nesneler oluşturmak için kullanılabilir.  object singleton gibi

Abstract:  Soyutlamadır ,  örnegin    soyut sınıflar   , soyut metodlar  gibi .  soyutlama kod tekrarını azaltmaktadır.

Interface:   sınıflara belirli bir davranışı uygulamaya zorlar.
 public interface Hayvan {
  void sesCikar();
}    mesela burada  bu  interface  tüm hayvanların ses çıkarabilmesini gerektirmektedir.

*/

//soru 8 ////////////////////////////////////////////////////////////////////////////////////////////////////////

/*

Acces Modifiers:  Erişilebilirligi kontrol ediyor .  örnek olarak public , private , protected .

public    her yerden erişilebilir ,  private  sadece tanımlandıgı sınıftan erişilebilir ,

protected  aynı sınıftan ya da o sınıftan türetilen sınıflardan erişilebilir.

acces modifier sayesinde hatalar önlenebilir.  kodun yanlışlıkla değiştirilmesinin önüne geçilebilir .

*/


fun main() {
    println("4 haneli sayı gitiniz:")
    val input = readLine()!!

    if (input.length == 4 && input.all { it.isDigit() }) {
        val sum = soru1(input)
        println("toplam : $sum")
    } else {
        println("4 haneli  girmediniz.")
    }
///////////////////////////////////////////////////////////////////////////////////
    println(" 5 haneli  sayı girin:")
    val girilenSayi = Sayi(readLine()!!)

    if (girilenSayi.validMi(5)) {
        val reversed = girilenSayi.tersCevir()
        println(" tersi: $reversed")
    } else {
        println(" 5 haneli  girmediniz .")
    }
//////////////////////////////////////////////////////////////////////////////////////

    println(" N sayısı girin:")
    val n = readLine()!!.toInt()

    val seri = SeriToplam()
    val sonuc = seri.hesapla(n)
    println("1'den $n'e kadar  toplam: $sonuc")

/////////////////////////////////////////////////////////////////////////////////////////

    val primeCalculator = PrimeCalculator()
    println("Prime için  bir  N sayısı girin:")
    val deger = readLine()!!.toInt()

    val sumOfPrimes = primeCalculator.getSumOfAllPrimes(deger)
    println("  asal sayı   toplamı: $sumOfPrimes")
///////////////////////////////////////////////////////////////////////////////////////

    val primeChecker = PrimeChecker()
    println(" bir sayı girin:")
    val number = readLine()!!.toInt()

    if (primeChecker.isPrime(number)) {
        println("$number bir asal sayı.")
    } else {
        println("$number bir asal sayı değil.")
    }

///////////////////////////////////////////////////////////////////////////////////////////

    println("Memur için ek saat girin:")
    val memurEkSaat = readLine()!!.toDouble()
    val memur = Memur(memurEkSaat)
    println("Memur maaş: ${memur.maas} TL")

    println("Müdür için ek saat girin:")
    val mudurEkSaat = readLine()!!.toDouble()
    val mudur = Mudur(mudurEkSaat)
    println("Müdür maaş: ${mudur.maas} TL")

    println("Genel Müdür için ek saat girin:")
    val genelMudurEkSaat = readLine()!!.toDouble()
    val genelMudur = GenelMudur(genelMudurEkSaat)
    println("Genel Müdür maaş: ${genelMudur.maas} TL")

}



