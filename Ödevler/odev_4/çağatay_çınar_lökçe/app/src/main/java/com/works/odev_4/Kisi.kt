package com.works.odev_4

import java.util.Scanner

open class Kisi(var ad: String,var soyad: String,var tel: String) {
    val kisiList = mutableListOf<Kisi>()

    fun menu(){
        while(true){
            println("""
            1 - Tüm Kayıtları Göster
            2 - Yeni Kayıt Ekle
            3 - Kayıt Sil
            4 - Kayıt Güncelle
            5 - Tümünü Temizle
            6 - Kayıt Ara (Ad veya Soyada Göre)
            7 - Kayıt Ara (Telefon Numarasına Göre)
            8 - Çıkış
        """.trimIndent())
            val secim = readlnOrNull()?.toInt()

            if (secim != null) {
                if (secim>8 || secim<1){
                    println("Yanlış seçim yaptınız.")
                }
            }

            when(secim){

                1->{
                    kisiList.forEach { println("${kisiList.indexOf(it)}. eleman:\n ${it.ad} ${it.soyad} ${it.tel}") }
                }

                2 -> {
                    println("Lütfen ad girin:")
                    val ad = readln()
                    println("Lütfen soyad girin:")
                    val soyad = readln()
                    println("Lütfen telefon numarası girin:")
                    val tel = readln()
                    kisiList.add(Kisi(ad, soyad, tel))
                }

                3 -> {
                    println("Silmek istediğiniz değeri giriniz:")
                    val rmIndex = readln().toInt()
                    kisiList.removeAt(rmIndex)
                }

                4 -> {
                    println("Değiştirmek istediğiniz indexi giriniz.")
                    val chIndex = readln().toInt()
                    println("Lütfen ad girin:")
                    val ad = readln()
                    println("Lütfen soyad girin:")
                    val soyad = readln()
                    println("Lütfen telefon numarası girin:")
                    val tel = readln()
                    kisiList[chIndex] = Kisi(ad, soyad, tel)
                }

                5 -> {
                    println("Listedeki tüm kişiler silinecek emin misiniz? 1)Evet   2)Hayır")
                    val delSecim = readln().toInt()
                    if (delSecim == 1){
                        kisiList.clear()
                        println("Listedeki tüm kişiler silinmiştir.")
                    }
                }

                6 -> {
                    println("Aramak istediğiniz kisinin adını girin:")
                    val ad = readln()
                    println("Soyadını girin:")
                    val soyad = readln()
                    kisiList.filter { it.ad.equals(ad) && it.soyad.equals(soyad) }.forEach { println("${it.ad} ${it.soyad} ${it.tel}") }
                }

                7 -> {
                    println("Aramak istediğiniz telefon numarasını girin:")
                    val tel = readln()
                    kisiList.filter { it.tel.equals(tel) }.forEach { println("${it.ad} ${it.soyad} ${it.tel}") }
                }

                8 -> {
                    println("Programdan çıkış yapıldı.")
                    break
                }

            }
        }
    }






}