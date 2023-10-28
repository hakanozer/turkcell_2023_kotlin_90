package com.gorkemarslanbogan.myapplication.Odev4

import java.math.BigInteger
import kotlin.random.Random


interface IHomeWork{
    fun Soru1()
    fun Soru2()
    fun Soru3()
    fun Soru4(listem: List<Int>)
    fun Soru5()
    fun Soru6(listem: List<Int>, aranacakDeger: Int): Int
    fun Soru7()
    fun Soru8(listem: List<Int>)
    fun <T> Soru9(listem: List<T>) : List<T>
    fun Soru10()
    fun Soru11(listem: List<Int>)
    fun Soru12()
}


class HomeWork : UserProcessAbstractClass(), IHomeWork{
    override fun Soru1() {
        var oncekiItem = -1
        var sayac = 1
        val random = Random
        while (sayac <= 6){
            val randomSayi = random.nextInt(1,50)
            if(randomSayi != oncekiItem) {
                oncekiItem = randomSayi
                EkranaYazdir("$sayac. sayı: $randomSayi")
                sayac++
            }
        }
    }

    override fun Soru2() {
        try {
            val sayi1 = BigInteger("23456789876543234567890987654567890")
            val sayi2 = BigInteger("99999999999988888888882222222688981")
            val toplam = sayi1 + sayi2
            EkranaYazdir("Toplam: $toplam")
        }catch (exception: Exception) {
            EkranaYazdir("Toplama işlemi yapılırken hata oluştu. \n Hata mesajı: ${exception.message}")
            exception.printStackTrace()
        }
    }

    override fun Soru3() {
        KisilerYonetimi()
    }

    override fun Soru4(listem: List<Int>) {
        listem.forEach {
            EkranaYazdir("Değer: $it")
        }
    }

    override fun Soru5() {
        val intSet = hashSetOf(1,2,20,900,100,16,45)
        val intList = mutableListOf(1,2,3,4,5,10,20,30,80,16)
        for (i in intSet){
            if(i !in intList){
                intList.add(i)
            }
        }
        intList.forEach {
            EkranaYazdir("Sayilar: $it")
        }
    }

    override fun Soru6(listem: List<Int>, aranacakDeger: Int): Int {
        val result = listem.count { it == aranacakDeger }
        if(result > 0)
        EkranaYazdir("Toplam: $result tane var")
        return result
    }

    override fun Soru7() {
        val yasList = arrayListOf(21,18,20,24,30,26,17,16,19,32,36,31,33)
        val yasMap = mutableMapOf<String,List<Int>>()
        yasMap["18-24"] = yasList.filter { it in 18..24 }
        yasMap["25-36"] = yasList.filter { it in 25..36 }
        yasMap["diğer yaş grupları"] = yasList.filter { it !in 18..24 && it !in 25..36 }
        yasMap.forEach{
            EkranaYazdir("Yaş grupları: ${it.key} ${it.value} ")
        }
    }

    override fun Soru8(listem: List<Int>) {
        val sum = listem.filter { (it > 0) }.sum()
        EkranaYazdir("Toplam Sayı $sum")
    }

    override fun <T> Soru9(listem: List<T>): List<T> {
        val liste = listem.filterNotNull()
        liste.forEachIndexed { index, any ->
        EkranaYazdir("$index. $any")
        }
        return liste
    }



    override fun Soru10() {
        val stringList =  arrayListOf("Deneme", "Kotlin", "Turkcell", "Bootcamp", "Ödev", "Gorkem", "Arslanbogan")
        val enUzunKelime =  stringList.maxByOrNull { it.length }
        val enKisaKelime =  stringList.minByOrNull { it.length }
        EkranaYazdir("En uzun kelime $enUzunKelime")
        EkranaYazdir("En kısa kelime $enKisaKelime")
    }

    override fun Soru11(listem: List<Int>) {
        listem.sorted().forEachIndexed { index, i ->
            EkranaYazdir("Sayı ${index + 1}: $i")
        }
    }

    override fun Soru12() {
        val intSet = hashSetOf(1, 2, 20, 900, 100, 16, 45, 60)
        val intSet2 = hashSetOf(1, 16, 45, 60, 950, 100, 2, 80)
        for (i in intSet) {
            if(i in intSet2) {
                EkranaYazdir("Ortak Eleman $i")
            }
        }
    }
}