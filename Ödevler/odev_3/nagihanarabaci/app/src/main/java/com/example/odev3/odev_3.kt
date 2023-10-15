package com.example.odev3

import com.example.odev3.Models.QuestionTeenModel
import java.io.File
import kotlin.random.Random

fun main(args: Array<String>) {
    //val obj = ReadFile.get(File("sayilar.txt"))
//    println("Soru 1")
//    soruBir(obj)

//    println("Soru 2")
//    writeFile(File("sayilar.txt"))

//    println("Soru 3")
//    createFile(obj)


    // dump.txt dosyasıyla ilgili işlemler için kullanılacak nesne.
    val objString = ReadFile.get(File("dump.txt"))
//    val objFile = ReadFile.getData()

//    println("Soru 4")
//    soruDort(objString)

//    println("Soru 5")
//    soruBes(objString)

//    println("Soru 6")
//    soruAlti(objString)

//    println("Soru 7")
//    soruYedi(objString)

//    println("Soru 8")
//    soruSekiz(objFile)

    //println("Soru 9")
//    println("Bir kelime girin")
//    val kelime = readLine()!!
//    soruDokuz(File("/Users/nagihan/Coding/ANDROID"),kelime)

    //println("Soru 10")
    //println("Kelime aranıyor, lütfen bekleyiniz...")
    soruOn()

}


// SORU 1
fun soruBir(list: List<Int>) {

    val evenList = mutableListOf<Int>()
    val oddList = mutableListOf<Int>()
    val positiveList = mutableListOf<Int>()
    val negativeList = mutableListOf<Int>()
    for (i in list) {
        if (i % 2 == 0) {
            evenList.add(i)
        } else {
            oddList.add(i)
        }
        if (i > 0) {
            positiveList.add(i)
        } else {
            negativeList.add(i)
        }
    }

    println("Toplam Pozitif Sayılar: ${positiveList.size}")
    println("Toplam Negatif Sayılar : ${negativeList.size}")
    println("Toplam Çift Sayılar: ${evenList.size}")
    println("Toplam Tek Sayılar: ${oddList.size}")

}


// SORU 2
fun writeFile(path: File): File {
    for (i in 1..500) {
        val randomNumber = Random.nextInt(-1000, 1000)
        path.appendText("$randomNumber\n")
    }
    return path
}


// SORU 3
fun createFile(list: List<Int>) {
    for (i in list) {
        if (i % 2 == 0) {
            File("C.txt").appendText("$i\n")
        } else {
            File("T.txt").appendText("$i\n")
        }
    }

    val readData2 = File("C.txt").bufferedReader().readLines()
    println("*******************************************************")
    println("Çift sayılarrr $readData2")

    val readData3 = File("T.txt").bufferedReader().readLines()
    println("Tek sayılarrr $readData3")

}


// SORU 4
fun soruDort(list: List<Any>) {
    val readData = list.toString()


    //Kaç Satır
    var satirSayisi = 0
    for (i in readData.split("\n")) {
        satirSayisi++
    }
    println("Satır Sayısı: $satirSayisi")


    // Kaç Kelime
    var kelimeSayisi = 0
    for (i in readData) {
        val words = i.toString().split(" ")
        kelimeSayisi += words.size
    }
    println("Kelime Sayısı: $kelimeSayisi")


    // Kaç Sessiz Harf
    var sessizHarfSayisi = 0
    for (i in readData) {
        for (j in i.toString()) {
            if (j == 'a' || j == 'e' || j == 'ı' || j == 'i' || j == 'o' || j == 'ö' || j == 'u' || j == 'ü') {
                sessizHarfSayisi++
            }
        }
    }
    println("Sessiz Harf Sayısı: $sessizHarfSayisi")

    // Kaç Sesli Harf
    var sesliHarfSayisi = 0
    for (i in readData) {
        for (j in i.toString()) {
            if (j == 'b' || j == 'c' || j == 'ç' || j == 'd' || j == 'f' || j == 'g' || j == 'ğ' || j == 'h' || j == 'j' || j == 'k' || j == 'l' || j == 'm' || j == 'n' || j == 'p' || j == 'r' || j == 's' || j == 'ş' || j == 't' || j == 'v' || j == 'y' || j == 'z') {
                sesliHarfSayisi++
            }
        }
    }
    println("Sesli Harf Sayısı: $sesliHarfSayisi")

    // Her bir kelimenin kaç kere geçtiğini bulunuz.
    val wordList = mutableListOf<String>()
    for (i in readData) {
        val words = i.toString().split(" ")
        for (j in words) {
            wordList.add(j)
        }
    }
    val kelimeMap = mutableMapOf<String, Int>()
    for (i in wordList) {
        if (kelimeMap.containsKey(i)) {
            kelimeMap[i] = kelimeMap[i]!! + 1
        } else {
            kelimeMap[i] = 1
        }
    }
    println(kelimeMap)


}


// SORU 5
fun soruBes(list: List<Any>) {
    val readData = list

    // SORU 5
    val reversedList = mutableListOf<String>()
    for (i in readData) {
        val words = i.toString().reversed()
        reversedList.add(words)
    }

    File("dump_rev_1.txt").appendText("${reversedList}")

//    val readData2 = ReadFile.get(File("dump_rev_1.txt"))
//    println("readData2 $readData2")


}


// SORU 6
fun soruAlti(list: List<Any>) {

    val splitSentenceList = mutableListOf<String>()
    val reverseSentenceList = mutableListOf<String>()

    for (i in list) {
        val words = i.toString().split(" ")
        for (j in words) {
            splitSentenceList.add(j)
        }
    }
    for (k in splitSentenceList) {
        val words = k.reversed()
        reverseSentenceList.add(words)
    }

//println("Tersten Yazılmış Cümle: ${reverseSentenceList.joinToString(" ")}")

    File("dump_rev_2.txt").appendText("${reverseSentenceList.joinToString(" ")}")
    val readData = ReadFile.get(File("dump_rev_2.txt"))
    println(readData)

}


// SORU 7
fun soruYedi(list: List<Any>) {
    val wordList = mutableListOf<String>()
    val wordCount = mutableMapOf<String, Int>()


    // HER KELİMENİN KAÇ KERE GEÇTİĞİNİ BULUNUZ
    for (i in list) {
        // Burada string ifadeyi noktalama işaretlerinden temizleriz.
        val cleanString = i.toString().replace(Regex("[-,.:;)('\"]"), "")
        val words = cleanString.split(" ")
        for (j in words) {
            wordList.add(j)
            wordList.removeIf { it.isBlank() }  // Kelime listesinde boşluk olan değerleri temizlemek için kullanıldı.
        }
    }
    for (k in wordList) {
        if (wordCount.containsKey(k)) {
            wordCount[k] = wordCount[k]!! + 1
        } else {
            wordCount[k] = 1
        }
    }
    wordCount.forEach { k, v ->
        println("$k = $v")
    }


    // EN UZUN KELİME ve EN KISA KELİME UZUNLUKLARI
    var wordLength = mutableMapOf<String, Int>()
    for (i in wordList) {
        wordLength.put(i, i.length)
    }

    // KELİME UZUNLUKLARINI YAZDIRMAK İÇİN YORUM SATIRINI KALDIRILABİLİRSİNİZ
    //    wordLength.forEach { k, v ->
    //        println("Kelimelerin Uzunlukları: ")
    //        println("$k = $v")
    //    }

    val maxValue = wordLength.values.maxOrNull()
    val minValue = wordLength.values.minOrNull()
    if (minValue != null || maxValue != null) {
        val maxValueKey = wordLength.entries.firstOrNull { it.value == maxValue }?.key
        println("En uzun Kelime : $maxValueKey ve Harf Sayısı : $maxValue")
        val minValueKey = wordLength.entries.firstOrNull { it.value == minValue }?.key
        println("En Kısa Kelime :  $minValueKey  ve Harf Sayısı : $minValue")
    } else {
        println("Null değer")
    }

}


// SORU 8
fun soruSekiz(path: String): Long {
    val files = File(path).listFiles()
    var totalSize = 0L

    if (files != null) {
        for (file in files) {
            if (file.exists() && file.isDirectory) {
                totalSize += soruSekiz(file.absolutePath)

            } else {
                totalSize += file.length()
            }
        }
    }
    println("Toplam Boyutu: $totalSize")
    return totalSize

}


// SORU 9
fun soruDokuz(dizin: File, kelime: String) {
    var count = 0
    val fileList = mutableListOf<File>()
    val subFile = dizin.listFiles()
    if (dizin.exists() && dizin.isDirectory) {
        for (i in subFile!!) {
            soruDokuz(i, kelime)
            if (i.isDirectory) {
                fileList.add(i)
            }
        }
//        println("Dosya listesi: $fileList")
        for (dosya in fileList) {
            if (dosya.name.equals(kelime)) {
                count++
                break
            }
        }

    } else {
        println("Belirtilen dizin bulunamadı veya bir dizin değil.")
    }
    println("Kelimenin geçtiği dosya sayısı: $count")
    println("Kelimenin bulunduğu klasör: ${dizin.absolutePath}")
    println("Kelimenin bulunduğu klasörün boyutu:  ${dizin.length()}")

}


// SORU 10
fun soruOn() {
    fun questionTeen(dizin: File, kelime: String){
        var searchCountResult: Long = 0
        var resultModelList = mutableListOf<QuestionTeenModel>()
        val files = File(dizin.absolutePath).listFiles()
        files.forEach { e ->
            if (e.isDirectory) {
                questionTeen(e, kelime)
            } else {
                e.forEachLine { f ->
                    f.lowercase().contains(kelime.lowercase()).let {
                        if (it) {
                            searchCountResult++
                            resultModelList.add(QuestionTeenModel(e.name, e.parentFile.name, e.length()))
                        }
                    }
                }
            }
        }
        val starts = "*".repeat(150)
        if (searchCountResult > 0) {
            println("$starts\nKelimenin geçtiği dosya sayısı: $searchCountResult\nDosya listesi: ${resultModelList.toString()}\n$starts")
        }
    }
    println("Bir kelime girin")
    val word = readLine()!!
    println("Kelime aranıyor, lütfen bekleyiniz...")
    questionTeen(File("/Users/nagihan/Coding/Android"), word)
}



