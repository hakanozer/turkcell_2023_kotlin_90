package com.works.homework4

import java.util.ArrayList
import java.util.Scanner


data class Kisi(val ad: String, val soyad: String, val tel: String)


fun main() {

    val kisiler = ArrayList<Kisi>()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("Lütfen seçiniz:")
        println("1 - Tüm Kayıtları Göster")
        println("2 - Yeni Kayıt Ekle")
        println("3 - Kayıt Sil")
        println("4 - Kayıt Güncelle")
        println("5 - Tümünü Temizle")
        println("6 - Kayıt Ara (Ad veya Soyada Göre)")
        println("7 - Kayıt Ara (Telefon Numarasına Göre)")
        println("8 - Çıkış")

        when (scanner.nextInt()) {
            1 -> {
                if (kisiler.isEmpty()) {
                    println("Henüz kayıt yok.")
                } else {
                    kisiler.forEachIndexed { index, kisi ->
                        println("Kayıt $index: ${kisi.ad} ${kisi.soyad} - Tel: ${kisi.tel}")
                    }
                }
            }

            2 -> {
                println("Adınızı giriniz:")
                val ad = scanner.next()
                println("Soyadınızı giriniz:")
                val soyad = scanner.next()
                println("Telefon numarasını giriniz:")
                val tel = scanner.next()
                kisiler.add(Kisi(ad, soyad, tel))
                println("Yeni kayıt eklendi!")
            }

            3 -> {
                if (kisiler.isEmpty()) {
                    println("Kayıt mevcut değil!")
                } else {
                    println("Silmek istediğiniz kaydın sıra numarasını giriniz:")
                    val index = scanner.nextInt()
                    if (index in 0 until kisiler.size) {
                        kisiler.removeAt(index)
                        println("Kayıt silindi.")
                    } else {
                        println("Geçersiz sıra numarası girdiniz.")
                    }
                }
            }

            4 -> {
                if (kisiler.isEmpty()) {
                    println("Kayıt yok.")
                } else {
                    println("Güncellemek istediğiniz kaydın sıra numarasını giriniz:")
                    val index = scanner.nextInt()
                    if (index in 0 until kisiler.size) {
                        println("Yeni adı giriniz:")
                        val ad = scanner.next()
                        println("Yeni soyadı giriniz:")
                        val soyad = scanner.next()
                        println("Yeni telefon numarasını giriniz:")
                        val tel = scanner.next()
                        kisiler[index] = Kisi(ad, soyad, tel)
                        println("Kayıt güncellendi!")
                    } else {
                        println("Geçersiz sıra numarası girdiniz!")
                    }
                }
            }

            5 -> {
                kisiler.clear()
                println("Tüm kayıtlar temizlendi!")
            }

            6 -> {
                println("Aranacak adı veya soyadı giriniz:")
                val aranan = scanner.next()
                val bulunanKisiler = kisiler.filter {
                    it.ad.contains(aranan, ignoreCase = true) || it.soyad.contains(
                        aranan,
                        ignoreCase = true
                    )
                }
                if (bulunanKisiler.isNotEmpty()) {
                    bulunanKisiler.forEachIndexed { index, kisi ->
                        println("Sonuç $index: ${kisi.ad} ${kisi.soyad} - Tel: ${kisi.tel}")
                    }
                } else {
                    println("Sonuç bulunamadı.")
                }
            }

            7 -> {
                println("Aranacak telefon numarasını giriniz:")
                val aranan = scanner.next()
                val bulunanKisiler = kisiler.filter { it.tel.contains(aranan) }
                if (bulunanKisiler.isNotEmpty()) {
                    bulunanKisiler.forEachIndexed { index, kisi ->
                        println("Sonuç $index: ${kisi.ad} ${kisi.soyad} - Tel: ${kisi.tel}")
                    }
                } else {
                    println("Sonuç bulunamadı.")
                }
            }

            8 -> {
                println("Uygulamadan çıkılıyor...")
                return
            }

            else -> println("Hatalı seçim, lütfen tekrar deneyiniz!")
        }
    }
}