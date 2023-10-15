package com.example.alimertkireccidev3.Sorular

import java.io.File

fun main(args: Array<String>) {
        // İlk olarak, önceki soruda oluşturduğum "yeni_1.txt" adresini vermem lazım!!!
        val dosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\yeni_1.txt"
        val dosya = File("C:\\Users\\Barbaros\\Documents\\NotePad++\\yeni_1.txt")
        if (!dosya.exists()) {
            println("Dosya bulunamadı: $dosyaYolu")
            return
        }
        val icerik = dosya.readLines()
        // C.txt dosyasına çift sayılarını yazdırma komutu
        val cDosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\C.txt"
        File(cDosyaYolu).bufferedWriter().use { writer ->
            for (satir in icerik) {
                val sayi = satir.toInt()
                if (sayi % 2 == 0) {
                    writer.write("$sayi\n")
                }
            }
        }
        // T.txt dosyasına tek sayılarını yazdırma komutu
        val tDosyaYolu = "C:\\Users\\Barbaros\\Documents\\NotePad++\\T.txt"
        File(tDosyaYolu).bufferedWriter().use { writer ->
            for (satir in icerik) {
                val sayi = satir.toInt()
                if (sayi % 2 != 0) {
                    writer.write("$sayi\n")
                }
            }
        }
        println("Çift sayılar C.txt 'Ye aktarıldı!")
        println("Tek sayılar T.txtYe aktarıldı!")
    }
