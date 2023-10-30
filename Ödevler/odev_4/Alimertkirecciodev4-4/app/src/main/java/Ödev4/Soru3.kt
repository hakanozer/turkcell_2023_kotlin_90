fun main(args: Array<String>) {
    val TelefonRehberi = ArrayList<Pair<String, String>>()

    while (true) {
        println("Telefon Rehberi Uygulaması")
        println("1 - Tüm Kayıtları Göster")
        println("2 - Yeni Kayıt Ekle")
        println("3 - Kayıt Sil")
        println("4 - Kayıt Güncelle")
        println("5 - Tümünü Temizle")
        println("6 - Kayıt Ara (Ad veya Soyada Göre)")
        println("7 - Kayıt Ara (Telefon Numarasına Göre)")
        println("8 - Çıkış")

        print("Seçiminizi girin: ")
        val Secilecekler = readLine()

        when (Secilecekler) {
            "1" -> {
                if (TelefonRehberi.isEmpty()) {
                    println("Rehberde Kişi Bulunmamaktadır.")
                } else {
                    println("Rehberdeki Kayıtlar:")
                    TelefonRehberi.forEachIndexed { index, (ad, soyad) ->
                        println("${index + 1}. $ad $soyad")
                    }
                }
            }
            "2" -> {
                print("İsim girin: ")
                val ad = readLine() ?: ""
                print("Soyisim girin: ")
                val soyad = readLine() ?: ""
                val EnSonkisi = Pair(ad, soyad)
                TelefonRehberi.add(EnSonkisi)
                println("Yeni kayıt Girildi.")
            }
            "3" -> {
                println("Silinecek kişinin sıra numarasını girin:")
                val siraNumarasi = readLine()?.toIntOrNull() ?: -1
                if (siraNumarasi in 1..TelefonRehberi.size) {
                    TelefonRehberi.removeAt(siraNumarasi - 1)
                    println("Kayıt silindi.")
                } else {
                    println("Geçersiz sıra numarası.")
                }
            }
            "4" -> {
                println("Güncellenecek kişinin sıra numarasını girin:")
                val siraNumarasi = readLine()?.toIntOrNull() ?: -1
                if (siraNumarasi in 1..TelefonRehberi.size) {
                    print("Yeni adınızı girin: ")
                    val yeniAd = readLine() ?: ""
                    print("Yeni soyadınızı girin: ")
                    val yeniSoyad = readLine()?: ""
                    val guncellenmisKisi = Pair(yeniAd, yeniSoyad)
                    TelefonRehberi[siraNumarasi - 1] = guncellenmisKisi
                    println("Kayıt güncellendi.")
                } else {
                    println("Geçersiz sıra numarası.")
                }
            }
            "5" -> {
                TelefonRehberi.clear()
                println("Rehber temizlendi.")
            }
            "6" -> {
                print("Aranacak adı veya soyadı girin: ")
                val anahtarKelime = readLine() ?: ""
                val sonuclar = TelefonRehberi.filter { (ad, soyad) ->
                    ad.contains(anahtarKelime, true) || soyad.contains(anahtarKelime, true)
                }
                if (sonuclar.isEmpty()) {
                    println("Aranan kişi bulunamadı.")
                } else {
                    println("Aranan kişiler:")
                    sonuclar.forEachIndexed { index, (ad, soyad) ->
                        println("${index + 1}. $ad $soyad")
                    }
                }
            }
            "7" -> {
                println("Aranacak telefon numarasını girin: ")
                val telefonArama = readLine() ?: ""
                val sonuclar = TelefonRehberi.filter { (ad, soyad) ->
                    ad == telefonArama || soyad == telefonArama
                }
                if (sonuclar.isEmpty()) {
                    println("Aranan kişi bulunamadı.")
                } else {
                    println("Aranan kişiler:")
                    sonuclar.forEachIndexed { index, (ad, soyad) ->
                        println("${index + 1}. $ad $soyad")
                    }
                }
            }
            "8" -> {
                println("Çıkış Yapılmaktadırç...")
                return
            }
            else -> println("Hatalı seçim. Lütfen 1-8 arasında bir seçenek girin.")
        }
    }
}