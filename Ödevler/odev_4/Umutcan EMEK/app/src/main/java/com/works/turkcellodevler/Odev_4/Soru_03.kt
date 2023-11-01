package com.works.turkcellodevler.Odev_4

/*
3. Kisi Diye Bir Nesneniz Olsun Ve ad, soyad, tel Özellikleri Olsun

Uygulamanızda Kullanıcıya Aşağıdaki Menuyu Göstereceksiniz :

1 - Tüm Kayıtları Göster
2 - Yeni Kayıt Ekle
3 - Kayıt Sil
4 - Kayıt Güncelle
5 - Tümünü Temizle
6 - Kayıt Ara (Ad veya Soyada Göre)
7 - Kayıt Ara (Telefon Numarasına Göre)
8 - Çıkış


Uygulamanız Sonsuz Döngü İçerisinde Yukarıdaki Menüyü Gösterecek
Kullanıcı 1-8 Dışında Bir Değer Girerse, Hatalı Seçim Diye Mesaj Gösterip Tekrar Menuyu
Gösterecek

Kisi Instance'larını Bir List'te Tutacaksınız. Ve Bu ArrayList Üzerinde Çalışacaksınız.

 */

data class Kisi(val ad: String, val soyad: String, val tel: String)

fun main() {
    val kisiler = mutableListOf<Kisi>()
    var devamEdilsin = true

    while (devamEdilsin) {
        println("Lütfen bir işlem seçin:")
        println("1 - Tüm Kayıtları Göster")
        println("2 - Yeni Kayıt Ekle")
        println("3 - Kayıt Sil")
        println("4 - Kayıt Güncelle")
        println("5 - Tümünü Temizle")
        println("6 - Kayıt Ara (Ad veya Soyada Göre)")
        println("7 - Kayıt Ara (Telefon Numarasına Göre)")
        println("8 - Çıkış")

        val secim = readLine()?.toIntOrNull() ?: 0

        when (secim) {
            1 -> {
                if (kisiler.isNotEmpty()) {
                    kisiler.forEachIndexed { index, kisi ->
                        println("Kayıt $index: ${kisi.ad} ${kisi.soyad}, Tel: ${kisi.tel}")
                    }
                } else {
                    println("Kayıt bulunmamaktadır.")
                }
            }
            2 -> {
                println("Yeni Kayıt Ekle")
                print("Ad: ")
                val ad = readLine() ?: ""
                print("Soyad: ")
                val soyad = readLine() ?: ""
                print("Tel: ")
                val tel = readLine() ?: ""
                kisiler.add(Kisi(ad, soyad, tel))
                println("Yeni kayıt eklendi.")
            }
            3 -> {
                if (kisiler.isNotEmpty()) {
                    println("Kayıt Sil")
                    println("Silinecek kaydın sıra numarasını girin:")
                    val silinecekIndex = readLine()?.toIntOrNull()
                    if (silinecekIndex != null && silinecekIndex >= 0 && silinecekIndex < kisiler.size) {
                        kisiler.removeAt(silinecekIndex)
                        println("Kayıt silindi.")
                    } else {
                        println("Geçersiz sıra numarası.")
                    }
                } else {
                    println("Silinecek kayıt bulunmamaktadır.")
                }
            }
            4 -> {
                if (kisiler.isNotEmpty()) {
                    println("Kayıt Güncelle")
                    println("Güncellenecek kaydın sıra numarasını girin:")
                    val guncellenecekIndex = readLine()?.toIntOrNull()
                    if (guncellenecekIndex != null && guncellenecekIndex >= 0 && guncellenecekIndex < kisiler.size) {
                        print("Yeni Ad: ")
                        val yeniAd = readLine() ?: ""
                        print("Yeni Soyad: ")
                        val yeniSoyad = readLine() ?: ""
                        print("Yeni Tel: ")
                        val yeniTel = readLine() ?: ""
                        kisiler[guncellenecekIndex] = Kisi(yeniAd, yeniSoyad, yeniTel)
                        println("Kayıt güncellendi.")
                    } else {
                        println("Geçersiz sıra numarası.")
                    }
                } else {
                    println("Güncellenecek kayıt bulunmamaktadır.")
                }
            }
            5 -> {
                kisiler.clear()
                println("Tüm kayıtlar temizlendi.")
            }
            6 -> {
                println("Ad veya Soyad ile Kayıt Ara")
                print("Aranacak Ad veya Soyad: ")
                val arananAdSoyad = readLine() ?: ""
                val bulunanKisiler = kisiler.filter { it.ad.contains(arananAdSoyad, ignoreCase = true) || it.soyad.contains(arananAdSoyad, ignoreCase = true) }
                if (bulunanKisiler.isNotEmpty()) {
                    println("Arama sonuçları:")
                    bulunanKisiler.forEachIndexed { index, kisi ->
                        println("Sonuç $index: ${kisi.ad} ${kisi.soyad}, Tel: ${kisi.tel}")
                    }
                } else {
                    println("Aranan kriterlere uygun kayıt bulunamadı.")
                }
            }
            7 -> {
                println("Telefon Numarası ile Kayıt Ara")
                print("Aranacak Telefon Numarası: ")
                val arananTel = readLine() ?: ""
                val bulunanKisiler = kisiler.filter { it.tel.contains(arananTel) }
                if (bulunanKisiler.isNotEmpty()) {
                    println("Arama sonuçları:")
                    bulunanKisiler.forEachIndexed { index, kisi ->
                        println("Sonuç $index: ${kisi.ad} ${kisi.soyad}, Tel: ${kisi.tel}")
                    }
                } else {
                    println("Aranan telefon numarasına uygun kayıt bulunamadı.")
                }
            }
            8 -> {
                devamEdilsin = false
                println("Çıkış yapılıyor.")
            }
            else -> {
                println("Hatalı seçim. Lütfen 1-8 arasında bir işlem seçin.")
            }
        }
    }
}

