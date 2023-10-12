package com.gorkemarslanbogan.kotlinodev3.Odev

import android.icu.text.StringPrepParseException
import androidx.core.text.isDigitsOnly
import java.io.*
import kotlin.random.Random

class FileProcess {

    companion object{
        val dumpFilePath = "C:/Users/HP/Desktop/dump.txt"
        val odevFilePath = "C:/Users/HP/Desktop/odev.txt"
        val desktopPath = "C:/Users/HP/Desktop/"
    }

    private fun fileIsHave(file: File) : Boolean {
        return !file.exists()
    }

    private fun createNewFile(fileName: String) {
        try {
            val file = File(fileName)
            if(fileIsHave(file)) {
                file.createNewFile()
            }else {
                EkranaYazdir("Bu dosya adında bir dosya mevcut!")
            }
        }catch (fileExcepiton: Exception){
            fileExcepiton.printStackTrace()
            EkranaYazdir("Hata: ${fileExcepiton.message}")
        }
    }

    private fun writeFile(fileName: String, list: List<String>?) {
        try {
            val file = File(fileName)
            val writer = file.bufferedWriter()
            if(list != null) {
                for(i in list) {
                    writer.write(i)
                    writer.newLine()
                }
            }else {
                EkranaYazdir("Hata: Yazdırılacak Dosya Bulunamadı!")
            }
            writer.close()
        }catch (e:Exception) {
            e.printStackTrace()
            EkranaYazdir("Hata: ${e.message}")
        }
    }

    private fun fileReader(fileName: String) : String {
        val stringBuilder = StringBuilder()
        try {
            val file = FileReader(fileName)
            val reader = BufferedReader(file)
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }
            reader.close()
            return stringBuilder.toString()
        } catch (e: Exception) {
            println("Hata: Dosya okuma hatası: ${e.message}")
        }
        return stringBuilder.toString()
    }

    fun Soru1(fileName: String, flag: Int = 0): HashMap<String, ArrayList<String>>{
        //flag 0 ise (1. soru) için çağırılmıştır değilse başka bir soru için çağırılmıştır fonksiyon.
        val hashMap = HashMap<String, ArrayList<String>>()
        hashMap["Çift Sayılar"] = ArrayList()
        hashMap["Tek Sayılar"] = ArrayList()
        hashMap["Pozitif Sayılar"] = ArrayList()
        hashMap["Negatif Sayılar"] = ArrayList()
        try{
            val file = File(fileName)
            val fileReader = FileReader(fileName)
            val reader = BufferedReader(fileReader)
            var line : String?
            while(reader.readLine().also { line = it } != null) {
                    val sayi = (line?.toIntOrNull() ?: 0)
                    if (sayi % 2 == 0) {
                        hashMap["Çift Sayılar"]?.add(sayi.toString())
                    }
                    if (sayi % 2 != 0) {
                    hashMap["Tek Sayılar"]?.add(sayi.toString())
                    }
                    if (sayi > 0) {
                        hashMap["Pozitif Sayılar"]?.add(sayi.toString())
                    } else if (sayi < 0) {
                        hashMap["Negatif Sayılar"]?.add(sayi.toString())
                    }
            }
            if(flag == 0){
                EkranaYazdir("Tek Sayılar: ${hashMap["Tek Sayılar"]?.size}")
                EkranaYazdir("Çift Sayılar: ${hashMap["Çift Sayılar"]?.size}")
                EkranaYazdir("Pozitif Sayılar: ${hashMap["Pozitif Sayılar"]?.size}")
                EkranaYazdir("Negatif Sayılar: ${hashMap["Negatif Sayılar"]?.size}")
            }
        }catch (fileExcepiton: Exception){
            fileExcepiton.printStackTrace()
            EkranaYazdir("Hata: ${fileExcepiton.message}")
        }
        return hashMap
    }

    fun Soru2(fileName: String) {
        val numbers = arrayListOf<String>()
        for(i in 1..500 ) {
            val randomNumber = Random.nextInt(-1000, 1000)
            numbers.add(randomNumber.toString())
        }
        writeFile(fileName,numbers)
    }


    fun Soru3(fileName: String) {
        var path = "C:/Users/HP/Desktop/"
        val response =  Soru1(fileName, 1)
        createNewFile(path+"C.txt")
        createNewFile(path+"T.txt")
        writeFile(path+"C.txt", response["Çift Sayılar"])
        writeFile(path+"T.txt", response["Tek Sayılar"])
        val cSize = response["Çift Sayılar"]?.size
        val tSize = response["Tek Sayılar"]?.size
        EkranaYazdir("Çift sayılar $cSize")
        EkranaYazdir("Tek sayılar $tSize")
    }

    fun Soru4() {
        try {
            val fileResponse = fileReader(dumpFilePath)
            val satirSayisi = fileResponse.split("\n").size
            var sesliHarfSayisi = 0
            var sessizHarfSayisi = 0
            val kelimeler = fileResponse.split(" ").filter { it.isNotBlank() }
            kelimeler.forEach { s ->
                s.forEach {
                    if(it.isLetter()){
                        if(it in "aeiouAEIOU"){
                            sesliHarfSayisi++
                        }else {
                            sessizHarfSayisi++
                        }
                    }
                }
            }
            EkranaYazdir("Satır Sayısı: $satirSayisi")
            EkranaYazdir("Kelime Sayısı: ${kelimeler.size}")
            EkranaYazdir("Sessiz Harf Sayısı: $sessizHarfSayisi")
            EkranaYazdir("Sesli Harf Sayısı: $sesliHarfSayisi")
        }catch (e: Exception) {
            EkranaYazdir("Dosya okuma hatası: ${e.message}")
        }
    }

    fun Soru5() {
        try {
            createNewFile(desktopPath+"dump_rev_1.txt")
            val fileResponse = fileReader(dumpFilePath)
            val kelimeler = fileResponse.split("\\s+")
            val tersKelime = arrayListOf<String>()
            kelimeler.forEach {
                tersKelime.add(it.reversed())
            }
            writeFile(desktopPath+"dump_rev_1.txt", tersKelime)

        }catch (e: Exception) {
            EkranaYazdir("Dosya okuma hatası: ${e.message}")
        }
    }

    fun Soru6() {
        try {
            createNewFile(desktopPath+"dump_rev_2.txt")
            val fileResponse = fileReader(dumpFilePath).split(" ").reversed()
            writeFile(desktopPath+"dump_rev_2.txt", fileResponse)
        }catch (e: Exception) {
            EkranaYazdir("Dosya okuma hatası: ${e.message}")
        }
    }

        fun Soru7() {
            val kelimeler = fileReader(dumpFilePath).split(Regex("\\s+")).filter { it.isNotEmpty() }
            val kelimeTekrari = kelimeler.groupingBy { it }.eachCount()
            val enUzunKelime = kelimeler.maxByOrNull { it.length }
            val enUzunKelimeIndex = kelimeler.indexOf(enUzunKelime)
            val enKisaKelime = kelimeler.minByOrNull { it.length }
            val enKisaKelimeIndex = kelimeler.indexOf(enKisaKelime)
            EkranaYazdir("Her kelimenin tekrar adedi:")
            kelimeTekrari.forEach { (kelime, tekrarAdeti) -> println("$kelime: $tekrarAdeti kez") }
            EkranaYazdir("En uzun kelime: ${kelimeler[enUzunKelimeIndex]} (Toplam ${enUzunKelime?.length} harf)")
            EkranaYazdir("En kısa kelime: ${kelimeler[enKisaKelimeIndex]}  (Toplam ${enKisaKelime?.length} harf)")
        }

    fun Soru8() {
        EkranaYazdir("Klasör yolunu girin: ")
        val klasorYolu = readLine()
        val boyut = Math.pow(2.0, 10.0)
        if (klasorYolu != null) {
            val klasor = File(klasorYolu)
            if (klasor.exists() && klasor.isDirectory) {
                val toplamBoyut = toplamKlasorBoyutunuHesapla(klasor)
                val birim = if (toplamBoyut > boyut) "MB" else "KB"
                val klasorBoyut = if (toplamBoyut > boyut) toplamBoyut / boyut else toplamBoyut
                EkranaYazdir("İlgili Klasörün toplam boyutu: $klasorBoyut $birim")
            } else {
                EkranaYazdir("Geçerli bir klasör yolunu giriniz.")
            }
        }
    }

    private fun toplamKlasorBoyutunuHesapla(klasor: File): Long {
        var toplamBoyut: Long = 0
        val dosyalar = klasor.listFiles()

        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isFile) {
                    toplamBoyut += dosya.length()
                } else if (dosya.isDirectory) {
                    toplamBoyut += toplamKlasorBoyutunuHesapla(dosya)
                }
            }
        }

        return toplamBoyut
    }
    fun Soru9(filePath: String) {
        try {
            EkranaYazdir("Aranacak kelimeyi girin: ")
            val aranacakKelime = readLine() ?: throw Exception("Geçerli bir kelime girmelisiniz.")

            val dizin = File(filePath)
            if (!dizin.exists() || !dizin.isDirectory) {
                throw Exception("Geçerli bir klasör yolu girmelisiniz.")
            }
            val bulunanDosyaSayisi = aramaYap(dizin, aranacakKelime)
            EkranaYazdir("Toplamda $bulunanDosyaSayisi dosya bulundu.")
        } catch (e: Exception) {
            EkranaYazdir("Hata: ${e.message}")
            e.printStackTrace()
        }

    }

    private fun aramaYap(dizin: File, kelime: String): Int {
        var bulunanDosyaSayisi = 0
        var toplamBoyut = 0.0
        val dosyalar = dizin.listFiles()
        if (dosyalar != null) {
            for (dosya in dosyalar) {
                if (dosya.isDirectory) {
                    bulunanDosyaSayisi += aramaYap(dosya, kelime)
                } else if (dosya.isFile) {
                    val icerik = dosya.readText()
                    val kelimeSayisi = icerik.split(Regex(" ")).count { it.contains(kelime, ignoreCase = true) }
                    if (kelimeSayisi > 0) {
                        val klasor = dosya.parent
                        val boyut = dosya.length()
                        toplamBoyut += boyut
                        EkranaYazdir("Dosya Adı: ${dosya.name}, Bulunduğu Klasör: $klasor, Boyutu: $boyut byte, Kelimenin Geçtiği Sayı: $kelimeSayisi")
                        bulunanDosyaSayisi++
                    }
                }
            }
            EkranaYazdir("Toplam Dosya Boyutu $toplamBoyut byte")
        }

        return bulunanDosyaSayisi
    }

    private fun EkranaYazdir(text: String){
        println(text)
    }

    private fun String.isDigitsOnly(): Boolean {
        return all { it.isDigit() }
    }
}