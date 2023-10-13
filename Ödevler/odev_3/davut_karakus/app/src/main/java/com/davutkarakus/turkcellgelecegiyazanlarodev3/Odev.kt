package com.davutkarakus.turkcellgelecegiyazanlarodev3

import java.io.File
import java.util.Locale
import kotlin.random.Random

fun main(args: Array<String>) {
    //soruBir()
    //soruIki()
    //soruUc()
    //soruDort()
    //soruBes()
    //soruAlti()
    //soruYedi()
    //soruSekiz()
    //soruDokuz()
    //soruOn()
}
fun soruBir() {
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\Odev\\15sayiyaz.txt"
    val file = File(fileName)
    val sayiArray = arrayListOf<Int>()
    file.forEachLine {
        try {
            sayiArray.add(it.toInt())
        }catch (e:Exception){
            println("Lutfen txt dosyasina integer deger giriniz!")
        }
    }
    var pos = 0
    var neg = 0
    var tek = 0
    var cift = 0

    for (i in sayiArray) {
        if (i < 0) {
            neg += 1
        }else if (i > 0) {
            pos += 1
        }
        if(i % 2 == 0){
            cift ++
        }else {
            tek ++
        }
    }
    println("$pos Tanesi Pozitif")
    println("$neg Tanesi Negatif")
    println("$tek Tanesi Tek")
    println("$cift Tanesi Cift")
}
fun soruIki() {
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\Odev\\15sayiyaz.txt"
    val file = File(fileName)
    val myRandomValues = List(500) { Random.nextInt(-1000, 1000) }
    for (i in myRandomValues) {
        file.appendText("$i\n")
    }
}
fun soruUc() {
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\Odev\\15sayiyaz.txt"
    val file = File(fileName)
    val data = file.readText()
    println(data)
    val sayiArray = arrayListOf<Int>()

    val ciftFileName = "C:\\Users\\DavutKarakus\\Desktop\\Odev\\C.txt"
    val fileCift = File(ciftFileName)
    val isNewCiftFileCreated :Boolean = fileCift.createNewFile()
    if(isNewCiftFileCreated){
        println("$ciftFileName is created successfully.")
    } else{
        println("$ciftFileName already exists.")
    }
    val tekFileName = "C:\\Users\\DavutKarakus\\Desktop\\Odev\\T.txt"
    val fileTek = File(tekFileName)
    val isNewTekFileCreated :Boolean = fileTek.createNewFile()
    if(isNewTekFileCreated){
        println("$tekFileName is created successfully.")
    } else{
        println("$tekFileName already exists.")
    }
    val tekArray = arrayListOf<Int>()
    val ciftArray = arrayListOf<Int>()
    file.forEachLine {
            sayiArray.add(it.toInt())
    }
    for (i in sayiArray) {
        if(i % 2 == 0){
            ciftArray.add(i)
        }else {
            tekArray.add(i)
        }
    }
    for (i in ciftArray) {
        fileCift.appendText("$i\n")
    }
    for (i in tekArray) {
        fileTek.appendText("$i\n")
    }
}
fun soruDort() {
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\dump.txt"
    val file = File(fileName)
    var i = 0
    val str = arrayListOf<String>()
    var kelimeSayisi = 0
    var sesliHarf = 0
    var sessizHarf = 0
    var yazi = ""
    file.readLines().forEach {
        i++
    }
    file.forEachLine {
        str.add(it)
    }
    for (i in str) {
        kelimeSayisi += i.split("\\s+".toRegex()).count()
        yazi += i
    }
    yazi = yazi.lowercase(Locale.ROOT)
    for (element in yazi) {
        when (element) {
            'a', 'e', 'i', 'o', 'u' ,'ü' ,'ı' ,'ö'-> ++sesliHarf
            in 'a'..'z' -> ++sessizHarf
        }
    }
    println("Satir Sayisi : $i")
    println("Kelime sayisi : $kelimeSayisi")
    println("Sesli Harf : $sesliHarf")
    println("Sessiz Harf : $sessizHarf")
}
fun soruBes() {
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\dump.txt"
    val file = File(fileName)
    val fileNameRev = "C:\\Users\\DavutKarakus\\Desktop\\dump_rev_1.txt"
    var yazi = ""
    val fileRev = File(fileNameRev)
    val isNewTekFileCreated :Boolean = fileRev.createNewFile()

    if(isNewTekFileCreated){
        println("$fileNameRev is created successfully.")
    } else{
        println("$fileNameRev already exists.")
    }
    file.forEachLine {
        yazi += it
    }
    val yeniYazi = yazi.reversed()
    fileRev.appendText(yeniYazi)
}
fun soruAlti() {
   // #6. 4. Sorudaki dump.txt yi, dump_rev_2.txt Dosyasına, Kelime Sırasını Bozmadan Tersten Yazdırın
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\dump.txt"
    val file = File(fileName)
    val fileNameRev2 = "C:\\Users\\DavutKarakus\\Desktop\\dump_rev_2.txt"
    var yazi = ""
    val fileRev2 = File(fileNameRev2)
    val isNewTekFileCreated :Boolean = fileRev2.createNewFile()
    if(isNewTekFileCreated){
        println("$fileNameRev2 is created successfully.")
    } else{
        println("$fileNameRev2 already exists.")
    }
    file.forEachLine {
        yazi += it
    }
    val words = yazi.split("\\s+".toRegex())
    val reversedWords = words.map { it.reversed() }
    val newYazi = reversedWords.joinToString(" ")
    fileRev2.appendText(newYazi)
}
fun soruYedi() {
    val fileName = "C:\\Users\\DavutKarakus\\Desktop\\dump.txt"
    val file = File(fileName)
    var yazi = ""
    file.forEachLine {
        yazi += it
    }
    val kelimeSayisi = yazi.split("\\s+".toRegex()).count()
    val kelimeGecisSayisi = yazi.split("\\s+".toRegex())
        .groupingBy { it }
        .eachCount()
    val enUzunKelime = yazi.split("\\s+".toRegex()).maxByOrNull { it.length }
    val enKisaKelime = yazi.split("\\s+".toRegex()).minByOrNull { it.length }
    println("Kelimelerin Sayısı: $kelimeSayisi")
    println("Her Kelimenin Geçiş Sayısı: $kelimeGecisSayisi")
    println("En Uzun Kelime: $enUzunKelime (${enUzunKelime?.length} harf)")
    println("En Kısa Kelime: $enKisaKelime (${enKisaKelime?.length} harf)")
}
fun soruSekiz() {
    print("Klasör yolunu girin: ")
    val dosyaYolu = readLine()
    if (dosyaYolu != null) {
        val dosya = File(dosyaYolu)
        if (dosya.exists() && dosya.isDirectory) {
            val totalSize = dosyaBoyutunuAl(dosya)
            println("Toplam Klasör Boyutu: ${totalSize / (1024 * 1024)} MB")
        } else {
            println("Belirtilen klasör bulunamadı veya bir klasör değil.")
        }
    } else {
        println("Geçersiz klasör yolu.")
    }
}
fun dosyaBoyutunuAl(folder: File): Long {
    var size: Long = 0
    if (folder.isDirectory) {
        val files = folder.listFiles()
        if (files != null) {
            for (file in files) {
                size += if (file.isDirectory) {
                    dosyaBoyutunuAl(file)
                } else {
                    file.length()
                }
            }
        }
    } else {
        size += folder.length()
    }
    return size
}
fun soruDokuz() {
    print("Klasör yolunu girin: ")
    val dosyaYolu = readLine()
    print("Aranacak kelimeyi girin: ")
    val kelime = readLine()
    if (dosyaYolu != null && kelime != null) {
        val dosya = File(dosyaYolu)
        if (dosya.exists() && dosya.isDirectory) {
            val resultFiles = dosyaAra(dosya, kelime)

            if (resultFiles.isNotEmpty()) {
                println("Arama Sonucu ${resultFiles.size} Dosya Bulundu:")
                for (file in resultFiles) {
                    println("Dosya Adı: ${file.name}")
                    println("Bulunduğu Klasör: ${file.parent}")
                    println("Boyutu: ${file.length()} bytes")
                }
            } else {
                println("Aranan kelimeyi içeren dosya bulunamadı.")
            }
        } else {
            println("Belirtilen klasör bulunamadı veya bir klasör değil.")
        }
    } else {
        println("Geçersiz klasör yolu veya kelime.")
    }
}
fun dosyaAra(folder: File, keyword: String): List<File> {
    val dosyaSonuclari = mutableListOf<File>()
    if (folder.isDirectory) {
        val files = folder.listFiles()
        if (files != null) {
            for (file in files) {
                if (file.isDirectory) {
                    dosyaSonuclari.addAll(dosyaAra(file, keyword))
                } else {
                    if (file.name.contains(keyword, ignoreCase = true)) {
                        dosyaSonuclari.add(file)
                    }
                }
            }
        }
    } else {
        if (folder.name.contains(keyword, ignoreCase = true)) {
            dosyaSonuclari.add(folder)
        }
    }
    return dosyaSonuclari
}
fun soruOn() {
    print("Klasör yolunu girin: ")
    val dosyaYolu = readLine()
    print("Aranacak kelimeyi girin: ")
    val kelime = readLine()
    if (dosyaYolu != null && kelime != null) {
        val dosya = File(dosyaYolu)
        if (dosya.exists() && dosya.isDirectory) {
            val resultFiles = icerikIleDosyaAra(dosya, kelime)
            if (resultFiles.isNotEmpty()) {
                println("Arama Sonucu ${resultFiles.size} Dosya Bulundu:")
                for (file in resultFiles) {
                    println("Dosya Adı: ${file.name}")
                    println("Bulunduğu Klasör: ${file.parent}")
                    println("Boyutu: ${file.length()} bytes")
                    println()
                }
            } else {
                println("Aranan kelimeyi içeren dosya bulunamadı.")
            }
        } else {
            println("Belirtilen klasör bulunamadı veya bir klasör değil.")
        }
    } else {
        println("Geçersiz klasör yolu veya kelime.")
    }
}
fun icerikIleDosyaAra(folder: File, kelime: String): List<File> {
    val dosyaSonuclari = mutableListOf<File>()
    if (folder.isDirectory) {
        val files = folder.listFiles()
        if (files != null) {
            for (dosya in files) {
                if (dosya.isDirectory) {
                    dosyaSonuclari.addAll(icerikIleDosyaAra(dosya, kelime))
                } else {
                    if (dosyaKelimeyiIceriyorMu(dosya, kelime)) {
                        dosyaSonuclari.add(dosya)
                    }
                }
            }
        }
    } else {
        if (dosyaKelimeyiIceriyorMu(folder, kelime)) {
            dosyaSonuclari.add(folder)
        }
    }
    return dosyaSonuclari
}

fun dosyaKelimeyiIceriyorMu(dosya: File, kelime: String): Boolean {
    return try {
        val icerik = dosya.readText()
        icerik.contains(kelime, ignoreCase = true)
    } catch (e: Exception) {
        false
    }
}