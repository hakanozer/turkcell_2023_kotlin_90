package com.works.odevler


import java.io.File


/**
 *#3. 2. Soruda Oluşturduğunuz Dosyayı Açıp Okuyan, Input Dosyasının Bulunduğu Klasore
 * C.txt Adında Bir Dosya Oluşturup, Input Dosyasının İçindeki Cift Sayıları Yazan,
 * T.txt Adında Bir Dosya Olusturup, Tek Sayıları Yazan Bir Uygulama Yazın
 */

fun main(args: Array<String>) {
    val dosyaAdi = "sayılar.txt"

    val ciftSayilar = "C.txt"
    val tekSayilar = "T.txt"

    val inputDosya = File(dosyaAdi)
    val cift = File(ciftSayilar)
    val tek = File(tekSayilar)

    val oku = inputDosya.bufferedReader()
    val yazCift = cift.bufferedWriter()
    val yazTek = tek.bufferedWriter()

    while (true) {
        val satir = oku.readLine() ?:break
        val sayi = satir.toInt()

            if (sayi % 2 == 0) {
                yazCift.write(sayi.toString())
                yazCift.newLine()
            } else {
                yazTek.write(sayi.toString())
                yazTek.newLine()
            }
    }

    oku.close()
    yazCift.close()
    yazTek.close()

    println("tek ve çift sayılar ayrı dosyalara eklendi")



}