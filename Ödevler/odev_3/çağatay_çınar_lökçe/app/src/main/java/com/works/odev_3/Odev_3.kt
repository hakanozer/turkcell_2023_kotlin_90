package com.works.odev_3

import android.system.Os
import java.io.File
import java.io.FileWriter
import java.util.Scanner
import kotlin.random.Random

fun main(args: Array<String>) {
    val filepath = "C:/Users/HP/Documents/GitHub/Turkcell-Kotlin-Mobile-Development-Bootcamp/Odev_3/app/src/main/java/com/works/odev_3/Input/input.txt"
    val dumpPath = "C:/Users/HP/Desktop/"
    val input = File(filepath)

        input.createNewFile()
        input.writeText("")
        for (i in 1..15) {
            input.appendText((-100..100).random().toString()+"\n")
        }

    //readInputText(filepath)
    //fillData(filepath)
    //oddEven(filepath)
    //dumpInfo(dumpPath)
    //reverseDump()
    //reverseDump2()
    //dumpWordInfo()

    /* 8-)
    var dosya = fileSize("C:/Users/HP/Desktop")
    var boyutmb = dosya/1000000
    var boyutgb = dosya/1000000000
    var boyutkb = dosya/1000
    val info = """
        ${String.format("Girdiğiniz dosya yolu:%.2f kilobyte büyüklüğünde.", boyutkb)}
        ${String.format("                      %.2f megabyte büyüklüğünde.", boyutmb)}
        ${String.format("                      %.4f gigabyte büyüklüğünde.", boyutgb)}
    """.trimIndent()
    println(info)
    */

    // fileSearch("C:/Users/HP/Desktop/","lorem")


}

// 1-)
fun readInputText(path: String){
    var pos = 0
    var neg = 0
    var odd = 0
    var even = 0

    val input = File(path)
    if (input.exists()) {
        val numberList = input.readLines()

        for (i in numberList) {
            if (i.toInt() > 0) {
                pos++
            } else {
                neg++
            }
            if (i.toInt() % 2 == 0) {
                even++
            } else {
                odd++
            }
        }
        println(
            """
                Verdiğiniz dosya yolundaki sayıların;
                $pos tanesi pozitif,
                $neg tanesi negatif,
                $odd tanesi tek ve $even tanesi çift sayıdır.
            """.trimIndent()
        )
    }else{
        println("Belirttiğiniz dosya yolu geçersiz.")
    }
}

// 2-)
fun fillData(path: String){

    val input = File(path)
    if (input.exists()){
        input.writeText("")
        for (i in 1..500) {
            input.appendText((-1000..1000).random().toString()+"\n")
        }
    }else{
        println("Girdiğiniz dosya yolu geçersiz.")
    }
}

// 3-)
fun oddEven(path: String){
    val input = File(path)
    val numberList = input.readLines()

    val tek=File("C:/Users/HP/Documents/GitHub/Turkcell-Kotlin-Mobile-Development-Bootcamp/Odev_3/app/src/main/java/com/works/odev_3/Input/T.txt")
    val cift = File("C:/Users/HP/Documents/GitHub/Turkcell-Kotlin-Mobile-Development-Bootcamp/Odev_3/app/src/main/java/com/works/odev_3/Input/C.txt")

    cift.createNewFile()
    cift.writeText("")
    tek.createNewFile()
    tek.writeText("")

    for(i in numberList){
        if ( i.toInt()%2 == 0 ){
            cift.appendText(i+"\n")
        }else{
            tek.appendText(i+"\n")
        }
    }
}

// 4-)
fun dumpInfo(path: String){
    val unluler = mutableListOf<Char>('a','e','ı','i','o','ö','u','ü')
    val dump = File(path)
    if (dump.exists()){
        val satirSayisi = dump.readLines().size
        var unluSayisi = 0
        var unsuzSayisi = 0
        var kelimeler = dump.readText().filter { it.isLetter() || it == ' ' }.split(' ')

        for (i in dump.readText()){
            if (unluler.contains(i)){
                unluSayisi++
            }else if (!unluler.contains(i) && i.isLetter()){
                unsuzSayisi++
            }
        }

        var kelimeSayisi = kelimeler.size
        println("""
        
        Verdiğiniz dosya yolunda,
        $satirSayisi tane satır
        $kelimeSayisi tane kelime
        $unsuzSayisi tane sessiz harf
        $unluSayisi tane sesli harf
        bulunmaktadır.
    """.trimIndent())
    }else{
        println("Girdiğiniz dosya yolu geçersiz.")
    }

}

// 5-)
fun reverseDump(){
    val reverseDump = File("C:/Users/HP/Desktop/dump_rev_1.txt")
    val dump = File("C:/Users/HP/Desktop/dump.txt")
    reverseDump.createNewFile()

    reverseDump.writeText(dump.readText().trimIndent().reversed())
}

// 6-)
fun reverseDump2 (){
    val reverseDump2 = File("C:/Users/HP/Desktop/dump_rev_2.txt")
    val dump = File("C:/Users/HP/Desktop/dump.txt")

    reverseDump2.createNewFile()

    val dumpWords = dump.readText().split(" ")
    val reversedDump2Text = dumpWords.map { it.reversed() }.joinToString().trimIndent()

    reverseDump2.writeText(reversedDump2Text)
}

// 7-)
fun dumpWordInfo(){
    val dump = File("C:/Users/HP/Desktop/dump.txt")
    val words = dump.readText().filter { it.isLetter() || it == ' '}.split(' ').filter { it.length != 0 }.map { it.lowercase().trimIndent() }
    var wordsmap = mutableMapOf<String,Int>()

    for(i in words){
        if (!wordsmap.containsKey(i)){
            wordsmap.put(i,1)
        }else if (wordsmap.containsKey(i)){
            wordsmap[i] = wordsmap[i]!! + 1
        }
    }

    val longestWord = wordsmap.keys.maxBy { it.length }
    val shortestWord = wordsmap.keys.minBy { it.length }

    for(i in wordsmap){
        println("${i.key} kelimesi ${wordsmap[i.key]} kez geçiyor.")
    }
    println("""
        
        En uzun kelime "$longestWord" kelimesi ve ${longestWord.length} tane harf içeriyor.
        En kısa kelime "$shortestWord" kelimesi ve ${shortestWord.length} tane harf içeriyor.
    """.trimIndent())
}

// 8-)
fun fileSize(dirPath: String): Float{
    var totalSize = 0f
    var fileList = File(dirPath).listFiles()

    if (fileList != null){
        for (file in fileList){
            if (file.isFile){
                totalSize += file.length()
            }else if (file.isDirectory){
                totalSize += fileSize(file.path)
            }
        }
    }
    return totalSize
}

// 9-)
fun fileSearch(path: String, word: String): Int{
    var totalSize = 0.0
    var findCount = 0

    try {
        val folder = File(path)
        val pathFiles = folder.listFiles()
        for (file in pathFiles){
            if (file.isDirectory){
                findCount += fileSearch(file.path,word)
            }else if (file.isFile){
                val context = file.readText()
                if (context.contains(word)){
                    findCount++
                    totalSize += file.length()
                    val wordCount = context.split(" ").filter { it.contains(word,true) }.count()
                    println("Aradığınız kelime ${file.name} dosyasında ${wordCount} kere geçmektedir ve ${file.name} dosyası ${file.parent} klasöründe bulunmuştur.Bulunan dosyanın boyutu ${file.length()/1000000} megabyte")
                }
            }
        }
    }catch (ex: Exception){
        println("Girdiğiniz dosya yolu geçersiz.")
    }


    return findCount
}