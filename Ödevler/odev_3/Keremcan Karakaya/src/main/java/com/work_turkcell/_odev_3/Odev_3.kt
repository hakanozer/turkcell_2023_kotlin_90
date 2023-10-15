package com.work_turkcell._odev_3
import java.io.File
import java.util.Random

fun main (args: Array<String>) {
    soru1()
    soru2()
    soru3()
    soru4()
    soru5()
    soru6()
    soru7()
    soru8()
    soru9()
}

//1
fun soru1() {
    val dosyaAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dosya.txt"
    val dosyaKapsam = File(dosyaAd).readLines().map { it.toInt() }
    val pozitifSayi = dosyaKapsam.count { it > 0 }
    val negatifSayi = dosyaKapsam.count { it < 0 }
    val tekSayi = dosyaKapsam.count { it % 2 != 0 }
    val ciftSayi = dosyaKapsam.count { it % 2 == 0 }

    println("Pozitif Sayılar: $pozitifSayi")
    println("Negatif Sayılar: $negatifSayi")
    println("Tek Sayılar: $tekSayi")
    println("Çift Sayılar: $ciftSayi")
}

//2
fun soru2(){
    val dosyaAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dosya.txt"
    val dosya = File(dosyaAd)
    val random = Random()
    val dosyaKapsam = StringBuilder()

    for (i in 1..500) {
        val rastgeleSayi = (Random().nextInt(2001) - 1000)
        dosyaKapsam.append("$rastgeleSayi\n")
    }
    dosya.writeText(dosyaKapsam.toString())
    println("500 tane random sayıyla dolduruldu.")
    soru1()
}

//3
fun soru3(){
    val inputDosyaAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dosya.txt"
    val ciftDosyaAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\Cift.txt"
    val tekDosyaAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\Tek.txt"

    val inputDosya = File(inputDosyaAd)
    val ciftDosya = File(ciftDosyaAd)
    val tekDosya = File(tekDosyaAd)

    val inputDosyaKapsam = inputDosya.readLines().map { it.toInt() }
    val ciftSayilar = mutableListOf<Int>()
    val tekSayilar = mutableListOf<Int>()

    for (sayi in inputDosyaKapsam) {
        if (sayi % 2 == 0) {
            ciftSayilar.add(sayi)
        } else {
            tekSayilar.add(sayi)
        }
    }
    for (ciftSayi in ciftSayilar) {
        ciftDosya.appendText("$ciftSayi\n")
    }
    for (tekSayi in tekSayilar) {
        tekDosya.appendText("$tekSayi\n")
    }
    println("Çift sayılar Cift.txt dosyasına yazıldı.")
    println("Tek sayılar Text.txt dosyasına yazıldı.")
}

//4
fun soru4() {
    val dosyaAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dump.txt"
    val dosya = File(dosyaAd)
    val dosyaKapsam = dosya.readText()

    val satirSayisi = dosyaKapsam.lines().size
    val kelimeler = dosyaKapsam.split(Regex("\\s+"))
    val kelimeSayisi = kelimeler.size

    val sessizHarfSayi = mutableListOf(0)
    val sesliHarfSayi = mutableListOf(0)

    for (harf in dosyaKapsam) {
        val harfDuzelt = harf.toLowerCase()
        if (harfDuzelt.isLetter()) {
            if (harfDuzelt in "bcçdfgğhjklmnprsştvyz") {
                sessizHarfSayi[0]++
            } else if (harfDuzelt in "aeiouıüö") {
                sesliHarfSayi[0]++
            }
        }
    }
    println("Dosyada toplam $satirSayisi satır bulunmaktadır.")
    println("Dosyada toplam $kelimeSayisi kelime bulunmaktadır.")
    println("Toplam ${sessizHarfSayi[0]} sessiz harf ve ${sesliHarfSayi[0]} sesli harf bulunmaktadır.")
}

//soru5
fun soru5(){
    val dump= "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dump.txt"
    val reverseDumpDosya = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dump_rev_1.txt"
    val dumpDosya = File(dump)
    val reverseDosya = File(reverseDumpDosya)

    if (!dumpDosya.exists()) {
        println("Dosya bulunamadı.")
        return
    }
    val kaynakKapsam = dumpDosya.readText()
    val tersKapsam = kaynakKapsam.reversed()
    reverseDosya.writeText(tersKapsam)
}

//6
fun soru6(){
        val dump = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dump.txt"
        val reverseDumpDosya = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dump_rev_2.txt"
        val dumpDosya = File(dump)
        val reverseDosya = File(reverseDumpDosya)

        if (!dumpDosya.exists()) {
            println("Kaynak dosya bulunamadı.")
            return
        }
        val kaynakKapsam = dumpDosya.readText()
        val kelime = kaynakKapsam.split(Regex("\\s+"))
        val tersKelime = kelime.map { it.reversed() }
        val tersKapsam = tersKelime.joinToString(" ")
        reverseDosya.writeText(tersKapsam)
}

//7
fun soru7() {
    val dumpAd = "C:\\Users\\kerem\\OneDrive\\Masaüstü\\dump.txt"
    val dump = File(dumpAd)

    if (!dump.exists()) {
        println("Dosya bulunamadı.")
        return
    }
    val dosyaKapsam = dump.readText()
    val kelimeler = dosyaKapsam.split(Regex("\\s+"))

    val kelimeTekrar = mutableMapOf<String, Int>()
    var enUzunKelime: String? = null
    var enKisaKelime: String? = kelimeler.firstOrNull()

    for (kelime in kelimeler) {
        if (kelime.isNotBlank()) {
            kelimeTekrar[kelime] = kelimeTekrar.getOrDefault(kelime, 0) + 1
            if (enUzunKelime == null || kelime.length > enUzunKelime.length) {
                enUzunKelime = kelime
            }
            if (enKisaKelime == null || kelime.length < enKisaKelime.length) {
                enKisaKelime = kelime
            }
        }
    }
    println("Her kelimenin tekrarı:")
    for ((kelime, tekrar) in kelimeTekrar) {
        println("$kelime: $tekrar")
    }
    println("En uzun kelime: $enUzunKelime, Uzunluğu: ${enUzunKelime?.length}")
    println("En kısa kelime: $enKisaKelime, Uzunluğu: ${enKisaKelime?.length}")
}

//8
fun soru8() {
    println("Klasör yolunu girin:")
    val klasorYolu = readLine()
    if (klasorYolu != null) {
        val klasor = File(klasorYolu)
        if (klasor.exists() && klasor.isDirectory) {
            val toplamBoyut = klasorBoyutunuHesapla(klasor)
            println("Klasörün toplam boyutu: $toplamBoyut byte")
            val kiloByte = toplamBoyut / 1024.0
            val megaByte = kiloByte / 1024.0
            val gigaByte = megaByte / 1024.0
            println("Klasörün Toplam Boyutu (KiloByte): ${"%.2f KB".format(kiloByte)}")
            println("Klasörün Toplam Boyutu (MegaByte): ${"%.2f MB".format(megaByte)}")
            println("Klasörün Toplam Boyutu (GigaByte): ${"%.2f GB".format(gigaByte)}")
        } else {
            println("Geçerli bir klasör yolunu girmediğinizden işlem yapılamadı.")
        }
    }
}
fun klasorBoyutunuHesapla(klasor: File): Long {
    if (klasor.isFile) {
        return klasor.length()
        }
    var toplamBoyut: Long = 0
    val dosyalar = klasor.listFiles()
    if (dosyalar != null) {
        for (dosya in dosyalar) {
            toplamBoyut += klasorBoyutunuHesapla(dosya)
            }
        }
    return toplamBoyut
}

//9
fun soru9(){
    println("Lütfen aramak istediğiniz kelimeyi girin:")
    val arananKelime = readLine()

    if (arananKelime != null) {
        val klasorYolu = "C:\\Users\\kerem\\OneDrive\\Masaüstü"
        val klasor = File(klasorYolu)
        if (klasor.exists() && klasor.isDirectory) {
            val bulunanDosyalar = ArrayList<File>()
            arananKelimeBul(klasor, arananKelime, bulunanDosyalar)
            println("Toplamda ${bulunanDosyalar.size} dosya bulundu.")

            for (dosya in bulunanDosyalar) {
                println("Dosya Adı: ${dosya.name}")
                println("Klasör: ${dosya.parent}")
                println("Boyut: ${dosya.length()} byte")
                println()
            }
        } else {
            println("Geçerli bir klasör yolunu girmediğinizden işlem yapılamadı.")
        }
    }
}
fun arananKelimeBul(klasor: File, arananKelime: String, bulunanDosyalar: MutableList<File>) {
    val dosyalar = klasor.listFiles()
    if (dosyalar != null) {
        for (dosya in dosyalar) {
            if (dosya.isFile) {
                if (dosya.readText().contains(arananKelime, ignoreCase = true)) {
                    bulunanDosyalar.add(dosya)
                }
            } else if (dosya.isDirectory) {
                arananKelimeBul(dosya, arananKelime, bulunanDosyalar)
            }
        }
    }
}