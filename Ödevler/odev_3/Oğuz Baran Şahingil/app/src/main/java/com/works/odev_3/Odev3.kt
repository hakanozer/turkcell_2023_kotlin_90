package com.works.odev_3

import java.io.File
import java.io.FileWriter
import java.io.PrintWriter
import java.util.Random

fun main(args: Array<String>) {
    // 1. Soru
    val dosyayeri = "C:\\Users\\bized\\odev3.txt"
    val dosyam = File(dosyayeri)
    val dosya_okuma = dosyam.readLines()
    var pozitif_Sayilar = 0
    var negatif_Sayilar = 0
    var cift_Sayilar = 0
    var tek_Sayilar = 0

    for (i in dosya_okuma){
        val sayi = i.toInt()
        if (sayi>0){
            pozitif_Sayilar++
            if (sayi<0){
                negatif_Sayilar++
            }
        }
        if (sayi%2==0){
            cift_Sayilar++
        }else{
            tek_Sayilar++
        }
    }
    println("""
        Pozitif Sayı $pozitif_Sayilar
        Negatif Sayı $negatif_Sayilar
        Çift Sayı $cift_Sayilar
        Tek Sayı $tek_Sayilar
    """.trimIndent())

    //2. Soru
    File(dosyayeri).writeText("")
    var dosyaici = 0
    try {
        val printWriter = PrintWriter(dosyayeri)
        for (i in -1001..1000){
            val random = kotlin.random.Random.nextInt(500)
            dosyaici=random
        }
        println(dosyaici)
        printWriter.close()
    }catch (e:Exception){
        println("Dosya Hatası")
    }

    //3. Soru
    try {
        val dosya_Okuma2 = File(dosyayeri).readLines()
        val ciftsayi_Dosyasi = File("Çift.txt")
        val teksayi_Dosyasi = File("Tek.txt")
        val cift_Sayilar3 = PrintWriter(ciftsayi_Dosyasi)
        val tek_Sayilar3 = PrintWriter(teksayi_Dosyasi)
        for (i in dosya_Okuma2){
            val sayi3 = i.toInt()
            if (sayi3 % 2 == 0){
                println(cift_Sayilar3)
            }else{
                println(tek_Sayilar3)
            }
        }
        cift_Sayilar3.close()
        tek_Sayilar3.close()
    }catch (e : Exception){
        println("Dosya Hatası")
    }

    //4. Soru

    val dosyayeri4 = "C:\\Users\\Oguz\\kelimeler.txt"
    try {
        val dosyam4 = File(dosyayeri4)
        val satir_Sayisi = dosyam4.readLines().size
        val dosya_okuma4 = dosyam4.readText()
        val kelime_Sayisi = dosya_okuma4.split("\\s+").size
        println("Satır Sayısı : " + satir_Sayisi)
        println("Kelime Sayısı : " + kelime_Sayisi)
    }catch (e : Exception){
        println("Dosya Hatası")
    }

    //5. Soru

    try {
        val dosyam5 = File(dosyayeri4)
        val dosya_Okuma5 = dosyam5.readText()
        val dosyayeri5 = File("kelimeler_terstenyazilis.txt")
        dosyayeri5.createNewFile()
        val dosya5 = FileWriter(dosyayeri5)
        dosya5.write(dosya_Okuma5.reversed())
        dosya5.close()
        println("Dosyanız Hazırdır")

    }catch (e : Exception){
        println("Dosya Hatası")
    }




























}