package com.bugcompany.challenge03

import java.io.File

class Question6 {

    fun reverse(source: File, target: File) {
        target.createNewFile()
        val kaynakMetin = source.readText()
        val tersMetin = kaynakMetin.split(" ").joinToString(" ") { it.reversed() }
        target.writeText(tersMetin)

        // Dosyanın başarıyla kopyalandığını göster
        println("Dosya başarıyla ters çevrilip 'dump_rev_2.txt' adlı dosyaya yazıldı.")
    }

}




