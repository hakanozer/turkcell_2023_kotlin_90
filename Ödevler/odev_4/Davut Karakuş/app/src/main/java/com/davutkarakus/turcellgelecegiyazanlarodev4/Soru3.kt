package com.davutkarakus.turcellgelecegiyazanlarodev4

class Soru3 {
    fun menuYap() {
        val kisiListesi = mutableListOf<Kisi>()

        while (true) {
            println("""
            Menu:
            1 - Tum Kayitlari Goster
            2 - Yeni Kayit Ekle
            3 - Kayit Sil
            4 - Kayit Guncelle
            5 - Tumunu Temizle
            6 - Kayit Ara (Ad veya Soyada Gore)
            7 - Kayit Ara (Telefon Numarasina Gore)
            8 - Cikis
        """.trimIndent())

            when (readLine()?.toIntOrNull()) {
                1 -> kisiListesi.forEach { println(it) }
                2 -> {
                    println("Adinizi girin:")
                    val ad = readLine().orEmpty()
                    println("Soyadinizi girin:")
                    val soyad = readLine().orEmpty()
                    println("Telefon numaranizi girin:")
                    val tel = readLine().orEmpty()
                    kisiListesi.add(Kisi(ad, soyad, tel))
                    println("Kayit eklendi!")
                }
                3 -> {
                    println("Silmek istediginiz kisinin telefon numarasini girin::")
                    val tel = readLine().orEmpty()
                    val kisi = kisiListesi.find { it.tel == tel }
                    if (kisi != null) {
                        kisiListesi.remove(kisi)
                        println("${kisi.ad} silindi")
                    }else {
                        println("Bu telefon numarasina sahip kayit bulunamadi!")
                    }
                }
                4 -> {
                    println("Guncellemek istediginiz kisinin telefon numarasini girin:")
                    val eskiTel = readLine().orEmpty()
                    val kisi = kisiListesi.find { it.tel == eskiTel }
                    if (kisi != null) {
                        println("Yeni adinizi girin:")
                        val yeniAd = readLine().orEmpty()
                        println("Yeni soyadinizi girin:")
                        val yeniSoyad = readLine().orEmpty()
                        println("Yeni telefon numaranizi girin:")
                        val yeniTel = readLine().orEmpty()
                        kisiListesi.remove(kisi)
                        kisiListesi.add(Kisi(yeniAd, yeniSoyad, yeniTel))
                        println("Kayit guncellendi!")
                    } else {
                        println("Bu telefon numarasina sahip kayit bulunamadi!")
                    }
                }
                5 -> {
                    kisiListesi.clear()
                    println("Tum kayitlar temizlendi!")
                }
                6 -> {
                    println("Aramak istediginiz kisinin adini veya soyadini girin:")
                    val ara = readLine().orEmpty()
                    val sonuclar = kisiListesi.filter { it.ad.contains(ara, true) || it.soyad.contains(ara, true) }
                    sonuclar.forEach { println(it) }
                }
                7 -> {
                    println("Aramak istediginiz kisinin telefon numarasini girin:")
                    val tel = readLine().orEmpty()
                    val sonuc = kisiListesi.find { it.tel == tel }
                    println(sonuc ?: "Bu telefon numarasina sahip kayit bulunamadi!")
                }
                8 -> {
                    println("Cikiyor...")
                    return
                }
                else -> println("Hatali secim! Lutfen 1-8 arasinda bir secenek girin.")
            }
        }
    }
}