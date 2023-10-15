package com.works.odevler

/**
 * #4. İçindeki dump.txt Dosyasını
 * Masaüstüne Çıkartın.
 *
 * Uygulamaya Bu Dosyayı Okuttuğunuz Zaman,
 * Bu Dosyada Kaç Satır, Kaç Kelime Var,
 * Harflerin Kaçı Sessiz, Kaçı Sesli Bu Bilgileri Konsola Yazan Bir Uygulama Yazın
 */
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main(args: Array<String>) {
    val dosyaYolu = "dump.txt"

        val dosya = File(dosyaYolu)


            val dosyaOkuyucu = BufferedReader(FileReader(dosya))
            var sesliHarfSayisi = 0
            var sessizHarfSayisi = 0

            var satir: String?




            val metin = dosya.readText()
            val kelimeler = metin.split(Regex("\\s+"))
            val kelimeSayisi = kelimeler.size
            println("Dosyadaki kelime sayısı: $kelimeSayisi")

            val satirlar = metin.split(Regex("\\^"))
            val satirSayisi = satirlar.size
            println("satirSayisi $satirSayisi")


            while (dosyaOkuyucu.readLine().also { satir = it } != null) {
                for (harf in satir.orEmpty()) {
                    if (harf.isLetter()) {
                        if (harf in "aeioöüuAEİÖÜIOU") {
                            sesliHarfSayisi++
                        } else {
                            sessizHarfSayisi++
                        }
                    }
                }
            }

            dosyaOkuyucu.close()

            println("Dosyada toplam $sesliHarfSayisi sesli harf bulunuyor.")
            println("Dosyada toplam $sessizHarfSayisi sessiz harf bulunuyor.")

}