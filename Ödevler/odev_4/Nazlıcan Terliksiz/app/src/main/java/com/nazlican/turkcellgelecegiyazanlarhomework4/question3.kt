package com.nazlican.turkcellgelecegiyazanlarhomework4

import java.util.*

data class Kisi(var ad: String, var soyad: String, var tel: String)

fun main() {
    val kisiler = ArrayList<Kisi>()
    val scanner = Scanner(System.`in`)
    var isRunning = true

    while (isRunning) {
        println("\n1 - Tüm Kayıtları Göster")
        println("2 - Yeni Kayıt Ekle")
        println("3 - Kayıt Sil")
        println("4 - Kayıt Güncelle")
        println("5 - Tümünü Temizle")
        println("6 - Kayıt Ara (Ad veya Soyada Göre)")
        println("7 - Kayıt Ara (Telefon Numarasına Göre)")
        println("8 - Çıkış")

        print("\nSeçiminiz: ")
        when (val choice = scanner.nextInt()) {
            1 -> {
                if (kisiler.isEmpty()) {
                    println("Liste boş.")
                } else {
                    println("Tüm Kayıtlar:")
                    for ((index, kisi) in kisiler.withIndex()) {
                        println("${index + 1}. ${kisi.ad} ${kisi.soyad} - ${kisi.tel}")
                    }
                }
            }
            2 -> {
                println("Yeni Kayıt Ekle")
                print("Ad: ")
                val ad = scanner.next()
                print("Soyad: ")
                val soyad = scanner.next()
                print("Telefon: ")
                val tel = scanner.next()
                kisiler.add(Kisi(ad, soyad, tel))
                println("Kayıt eklendi.")
            }
            3 -> {
                if (kisiler.isEmpty()) {
                    println("Liste boş.")
                } else {
                    println("Kayıt Sil")
                    print("Silmek istediğiniz kişinin numarasını girin: ")
                    val index = scanner.nextInt()
                    if (index > 0 && index <= kisiler.size) {
                        kisiler.removeAt(index - 1)
                        println("Kayıt silindi.")
                    } else {
                        println("Geçersiz indeks.")
                    }
                }
            }
            4 -> {
                if (kisiler.isEmpty()) {
                    println("Liste boş.")
                } else {
                    println("Kayıt Güncelle")
                    print("Güncellemek istediğiniz kişinin numarasını girin: ")
                    val index = scanner.nextInt()
                    if (index > 0 && index <= kisiler.size) {
                        val kisi = kisiler[index - 1]
                        print("Yeni ad: ")
                        kisi.ad = scanner.next()
                        print("Yeni soyad: ")
                        kisi.soyad = scanner.next()
                        print("Yeni telefon: ")
                        kisi.tel = scanner.next()
                        println("Kayıt güncellendi.")
                    } else {
                        println("Geçersiz indeks.")
                    }
                }
            }
            5 -> {
                kisiler.clear()
                println("Tüm kayıtlar temizlendi.")
            }
            6 -> {
                if (kisiler.isEmpty()) {
                    println("Liste boş.")
                } else {
                    println("Kayıt Ara (Ad veya Soyada Göre)")
                    print("Aranacak kelimeyi girin: ")
                    val keyword = scanner.next()
                    val filteredList = kisiler.filter { it.ad.contains(keyword, true) || it.soyad.contains(keyword, true) }
                    if (filteredList.isNotEmpty()) {
                        println("Arama Sonuçları:")
                        for ((index, kisi) in filteredList.withIndex()) {
                            println("${index + 1}. ${kisi.ad} ${kisi.soyad} - ${kisi.tel}")
                        }
                    } else {
                        println("Arama sonuç vermedi.")
                    }
                }
            }
            7 -> {
                if (kisiler.isEmpty()) {
                    println("Liste boş.")
                } else {
                    println("Kayıt Ara (Telefon Numarasına Göre)")
                    print("Aranacak telefon numarasını girin: ")
                    val tel = scanner.next()
                    val filteredList = kisiler.filter { it.tel == tel }
                    if (filteredList.isNotEmpty()) {
                        println("Arama Sonuçları:")
                        for ((index, kisi) in filteredList.withIndex()) {
                            println("${index + 1}. ${kisi.ad} ${kisi.soyad} - ${kisi.tel}")
                        }
                    } else {
                        println("Arama sonuç vermedi.")
                    }
                }
            }
            8 -> {
                println("Çıkış yapılıyor...")
                isRunning = false
            }
            else -> println("Hatalı seçim. Lütfen tekrar deneyin.")
        }
    }
}

