package com.works.homeworks._homework

import java.io.File
import kotlin.random.Random

fun main(args: Array<String>) {


    //1. Soru

    val soru1 = "D:\\ödev3\\sayilar.txt" 
    val dosya1 = File(soru1)

    if (dosya1.exists()) {
        var pozitifSayi = 0
        var negatifSayi = 0
        var tekSayi = 0
        var ciftSayi = 0

        dosya1.forEachLine { satir ->
            val sayi = satir.toIntOrNull()
            if (sayi != null) {
                if (sayi > 0) {
                    pozitifSayi++
                } else if (sayi < 0) {
                    negatifSayi++
                }

                if (sayi % 2 == 0) {
                    ciftSayi++
                } else {
                    tekSayi++
                }
            }
        }

        println("Dosyada Toplam:")
        println("- Pozitif Sayı: $pozitifSayi")
        println("- Negatif Sayı: $negatifSayi")
        println("- Tek Sayı: $tekSayi")
        println("- Çift Sayı: $ciftSayi")
    } else {
        println("Hata: Dosya bulunamadı!")
    }


    // 2. Soru

    val soru2 = "D:\\ödev3\\sayilar.txt" 
    val dosya2 = File(soru2)

    if (!dosya2.exists()) {
        println("Hata: Dosya bulunamadı. Önce dosyayı oluşturun.")
        return
    }

    val min = -1000
    val max = 1000
    val sayiAdedi = 500

    try {
        val dosyaYazici = dosya2.bufferedWriter()

        for (i in 1..sayiAdedi) {
            val rastgeleSayi = Random.nextInt(min, max + 1)
            dosyaYazici.write("$rastgeleSayi\n")
        }

        dosyaYazici.close()
        println("Dosya güncellendi ve rastgele sayılar eklendi: $soru2")
    } catch (e: Exception) {
        println("Hata: Dosyaya yazılırken bir sorun oluştu. Hata: ${e.message}")
    }


    // 3.Soru

    val dosya3 = "D:\\ödev3\\sayilar.txt"
    val cDosyasi = "D:\\ödev3\\C.txt"
    val tDosyasi = "D:\\ödev3\\T.txt"

    val ciftSayilar = mutableListOf<Int>()
    val tekSayilar = mutableListOf<Int>()

   
    File(dosya3).forEachLine {
        val sayi = it.toIntOrNull()
        if (sayi != null) {
            if (sayi % 2 == 0) {
                ciftSayilar.add(sayi)
            } else {
                tekSayilar.add(sayi)
            }
        }
    }

   
    File(cDosyasi).printWriter().use { dosya ->
        ciftSayilar.forEach { dosya.println(it) }
    }

    println("Cift sayılar C.txt dosyasına yazıldı.")

   
    File(tDosyasi).printWriter().use { dosya ->
        tekSayilar.forEach { dosya.println(it) }
    }

    println("Tek sayılar T.txt dosyasına yazıldı.")


    // 4. Soru

    val dosya4 = "C:\\Users\\berin\\OneDrive\\Masaüstü\\dump.txt"

    var satirSayisi = 0
    var kelimeSayisi = 0
    var sessizHarfSayisi = 0
    var sesliHarfSayisi = 0

    File(dosya4).forEachLine { satir ->
        satirSayisi++
        val kelimeler = satir.split(" ")
        kelimeSayisi += kelimeler.size

        for (kelime in kelimeler) {
            for (harf in kelime) {
                if (harf.isLetter()) {
                    if (harf.isLetter() && "aeiouAEIOU".contains(harf)) {
                        sesliHarfSayisi++
                    } else {
                        sessizHarfSayisi++
                    }
                }
            }
        }
    }

    println("Satır Sayısı: $satirSayisi")
    println("Kelime Sayısı: $kelimeSayisi")
    println("Sessiz Harf Sayısı: $sessizHarfSayisi")
    println("Sesli Harf Sayısı: $sesliHarfSayisi")


    // 5. Soru

    val girisDosya5 = "C:\\Users\\berin\\OneDrive\\Masaüstü\\dump.txt"
    val cikisDosya5 = "C:\\Users\\berin\\OneDrive\\Masaüstü\\dump_rev_1.txt"

    try {
        val girisDosya = File(girisDosya5)
        val cikisDosya = File(cikisDosya5)

        if (girisDosya.exists()) {
            val girisIcerik = girisDosya.readText()
            val tersCevrilmisIcerik = girisIcerik.reversed()

            cikisDosya.writeText(tersCevrilmisIcerik)

            println("Dosya ters çevrilip $cikisDosya5 dosyasına yazıldı.")
        } else {
            println("Giriş dosyası bulunamadı.")
        }
    } catch (e: Exception) {
        println("Hata oluştu: ${e.message}")
    }


    // 6. Soru

    val girisDosya6 = "C:\\Users\\berin\\OneDrive\\Masaüstü\\dump.txt"
    val cikisDosya6 = "C:\\Users\\berin\\OneDrive\\Masaüstü\\dump_rev_2.txt"

    try {
        val girisDosya = File(girisDosya6)
        val cikisDosya = File(cikisDosya6)

        if (girisDosya.exists()) {
            val satirlar = girisDosya.readLines()
            val tersCevrilmisSatirlar = satirlar.map { tersCevirKelimeSiraKoruma(it) }

            cikisDosya.writeText(tersCevrilmisSatirlar.joinToString("\n"))

            println("Dosya kelime sırası bozulmadan ters çevrilip $cikisDosya6 dosyasına yazıldı.")
        } else {
            println("Giriş dosyası bulunamadı.")
        }
    } catch (e: Exception) {
        println("Hata oluştu: ${e.message}")
    }
}

fun tersCevirKelimeSiraKoruma(metin: String): String {
    val kelimeler = metin.split(" ")
    val tersCevrilmisKelimeler = kelimeler.map { it.reversed() }
    return tersCevrilmisKelimeler.joinToString(" ")
}



    // 7. Soru

fun soru7() {
    val dosyaYolu7 = "C:\\Users\\berin\\OneDrive\\Masaüstü\\dump.txt"

    try {
        val dosya7 = File(dosyaYolu7)

        if (dosya7.exists()) {
            val icerik = dosya7.readText()
            val kelimeler = icerik.split("\\s+".toRegex())

            val kelimeSayilari = hashMapOf<String, Int>()
            for (kelime in kelimeler) {
                val temizlenmisKelime = kelime.replace(Regex("[^a-zA-Z0-9]"), "")
                kelimeSayilari[temizlenmisKelime] =
                    kelimeSayilari.getOrDefault(temizlenmisKelime, 0) + 1
            }

            var enUzunKelime = ""
            var enKisaKelime = kelimeSayilari.keys.first()

            for ((kelime, _) in kelimeSayilari) {
                if (kelime.length > enUzunKelime.length) {
                    enUzunKelime = kelime
                }
                if (kelime.length < enKisaKelime.length) {
                    enKisaKelime = kelime
                }
            }

            println("Her kelimenin geçiş sayısı:")
            for ((kelime, sayi) in kelimeSayilari) {
                println("$kelime: $sayi")
            }

            println("En uzun kelime: $enUzunKelime (${enUzunKelime.length} harf)")
            println("En kısa kelime: $enKisaKelime (${enKisaKelime.length} harf)")
        } else {
            println("Giriş dosyası bulunamadı.")
        }
    } catch (e: Exception) {
        println("Hata oluştu: ${e.message}")
    }


    // 8. Soru

    fun soru8(klasor: File): Long {
        var toplamBoyut = 0L

        if (klasor.isDirectory) {
            val dosyalar = klasor.listFiles()

            if (dosyalar != null) {
                for (dosya in dosyalar) {
                    if (dosya.isFile) {
                        toplamBoyut += dosya.length()
                    } else if (dosya.isDirectory) {
                        toplamBoyut += soru8(dosya)
                    }
                }
            }
        }

        return toplamBoyut
    }

    fun soru8() {
        println("Klasör yolunu giriniz. ")
        val klasor8 = readLine() ?: return

        val baslangicKlasor = File(klasor8)
        if (!baslangicKlasor.exists() || !baslangicKlasor.isDirectory) {
            println("Belirtilen klasör bulunamadı veya geçerli bir klasör değil.")
        } else {
            val toplamBoyut = soru8(baslangicKlasor)
            val toplamBoyutMB = toplamBoyut / 1024 / 1024
            println("Toplam klasör boyutu: $toplamBoyutMB MB")
        }
    }



    // 9. Soru

    fun dosyalariAra(klasor: File, arananKelime: String) {
        if (klasor.isDirectory) {
            val dosyalar = klasor.listFiles()

            if (dosyalar != null) {
                for (dosya in dosyalar) {
                    if (dosya.isFile && dosya.name.contains(arananKelime, ignoreCase = true)) {
                        println("Dosya Adı: ${dosya.name}")
                        println("Bulunduğu Klasör: ${klasor.absolutePath}")
                        println("Boyut: ${dosya.length()} byte\n")
                    } else if (dosya.isDirectory) {
                        dosyalariAra(dosya, arananKelime)
                    }
                }
            }
        }
    }

    fun soru9() {
        println("Aranacak kelimeyi giriniz. ")
        val arananKelime = readLine() ?: return

        println("Başlangıç klasör yolunu giriniz. ")
        val klasorYolu = readLine() ?: return

        val baslangicKlasor = File(klasorYolu)
        if (!baslangicKlasor.exists() || !baslangicKlasor.isDirectory) {
            println("Belirtilen klasör bulunamadı veya geçerli bir klasör değil.")
        } else {
            println("Arama Sonuçları:")
            dosyalariAra(baslangicKlasor, arananKelime)
        }
    }


}


