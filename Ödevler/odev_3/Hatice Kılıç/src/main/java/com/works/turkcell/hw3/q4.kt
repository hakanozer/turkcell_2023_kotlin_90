package com.works.turkcell.hw3

import java.io.File

fun main(args: Array<String>) {

    val filePath  = "C:\\Users\\CAN OKTAY KILIC\\Desktop\\dump.txt"
    val dumpFile = File(filePath)
    val data = dumpFile.readText()

    if (dumpFile.exists()){

        var lineCount = dumpFile.readLines().size
        var wordCount = data.split(Regex("\\s+")).size
        var sesliCount = 0
        var sessizCount = 0

        for (item in data ){
            var newData = item.lowercase()
            if ( newData in "a, e, ı, i, o, ö, u, ü ") {
                     sesliCount++
            }
            if( newData in "z, y, v, t, ş, s, r, p, n, r, m, l, k, h, j, ğ, g, d, ç, c, b"){
                sessizCount++
            }
        }

        println("Dosyadaki satir sayisi : $lineCount")
        println("Dosyadaki kelime sayisi : $wordCount")
        println("Dosyadaki sesli harf sayisi : $sesliCount")
        println("Dosyadaki sessiz harf sayisi : $sessizCount")

    }else
        println("Lutfen dosya yolunu kontrol ediniz.")



}


