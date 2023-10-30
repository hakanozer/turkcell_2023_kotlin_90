package com.works.odev.Ödev4

import java.util.Scanner

/**
 * 3. Kisi Diye Bir Nesneniz Olsun Ve ad, soyad, tel Özellikleri Olsun
 *
 * Uygulamanızda Kullanıcıya Aşağıdaki Menuyu Göstereceksiniz :
 *
 * 1 - Tüm Kayıtları Göster
 * 2 - Yeni Kayıt Ekle
 * 3 - Kayıt Sil
 * 4 - Kayıt Güncelle
 * 5 - Tümünü Temizle
 * 6 - Kayıt Ara (Ad veya Soyada Göre)
 * 7 - Kayıt Ara (Telefon Numarasına Göre)
 * 8 - Çıkış
 *
 *
 * Uygulamanız Sonsuz Döngü İçerisinde Yukarıdaki Menüyü Gösterecek
 * Kullanıcı 1-8 Dışında Bir Değer Girerse, Hatalı Seçim Diye Mesaj Gösterip Tekrar Menuyu
 * Gösterecek
 *
 * Kisi Instance'larını Bir List'te Tutacaksınız. Ve Bu ArrayList Üzerinde Çalışacaksınız.
 */

fun main(args: Array<String>) {
    val kisiler = ArrayList<Kisi>()
    val scanner = Scanner(System.`in`)


        while (true) {
            println(
                """
        |1 - Tüm Kayıtları Göster
        |2 - Yeni Kayıt Ekle
        |3 - Kayıt Sil
        |4 - Kayıt Güncelle
        |5 - Tümünü Temizle
        |6 - Kayıt Ara (Ad veya Soyada Göre)
        |7 - Kayıt Ara (Telefon Numarasına Göre)
        |8 - Çıkış
    """.trimMargin()
            )


            when (scanner.nextInt()) {
                1 -> {
                    if (kisiler.isEmpty()) {
                        println("Kayıtlı kişi bulunmamaktadır.")
                    } else {
                        println("Kayıtlı Kişiler:")
                        kisiler.forEach { println("${it.ad} - ${it.soyad} - ${it.tel}") }
                    }
                    println("######################3")
                }

                2 -> {
                    println("Ad:")
                    val ad = scanner.next()
                    println("Soyad:")
                    val soyad = scanner.next()
                    println("Telefon:")
                    val tel = scanner.next()
                    kisiler.add(Kisi(ad,soyad,tel))
                    println("Yeni kayıt eklendi")

                }

                3 -> {
                    println("Silinecek kişinin sırasını girin:")
                    val index = scanner.nextInt()
                    if (index >= 0 && index < kisiler.size) {
                        kisiler.removeAt(index)
                        println("Kayıt silindi.")
                    } else {
                        println("Geçersiz giriş.")
                    }

                }

                4 -> {

                    println("kişi sırasını giriniz:")
                    val index = scanner.nextInt()
                    if (index >= 0 && index < kisiler.size) {
                        println("Yeni kişi ad:")
                        val yeniKisiAd = scanner.next()
                        println("Yeni kişi soyad:")
                        val yeniKisiSoyad = scanner.next()
                        println("Yeni kişi telefon:")
                        val yeniKisiTel = scanner.next()
                        kisiler[index] = Kisi(yeniKisiAd, yeniKisiSoyad, yeniKisiTel)
                        println("Güncellendi")
                    }

                }

                5 -> {
                    kisiler.clear()
                    println("Tüm kayıtlar temizlendi")

                }

                6 -> {

                    println("Aramak istediğiniz kişinin adını giriniz:")
                    val aranan = scanner.next()
                    val bulunan = kisiler.filter { it.ad == aranan }
                    if (bulunan.isEmpty()) {
                        println("Aradığınız isimde bir kişi bulunamadı.")
                    } else {
                        bulunan.forEach { println("Aranan kişinin bilgileri: ${it.ad} - ${it.soyad} - ${it.tel}") }
                    }
                }

                7 -> {
                    println("Aranan kişinin telefon numarasını giriniz:")
                    val aranan = scanner.next()
                    val bulunan = kisiler.filter { it.tel == aranan }

                    if (bulunan.isEmpty()) {
                        println("Aradığınız isimde bir kişi bulunamadı.")
                    } else {
                        bulunan.forEach { println("Aranan kişinin bilgileri :${it.ad} - ${it.soyad} - ${it.tel}") }
                    }
                }

                8 -> return
                else -> println("Hatalı Seçim.")

            }

        }
}