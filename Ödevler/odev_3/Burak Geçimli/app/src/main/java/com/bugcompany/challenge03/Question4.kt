package com.bugcompany.challenge03


import java.io.File
import java.io.FileNotFoundException

class Question4() {

    companion object {
        val vowels = setOf('a', 'e', 'i', 'o', 'ü', 'u', 'ö', 'ı')
    }

    fun infoDump(dumpFilePath: String) {
        val file = File(dumpFilePath)
        var vowelCount = 0
        var consonantCount = 0
        var lineCount = 0
        var wordCount = 0


        try {
            file.forEachLine { line ->
                lineCount++

                val words = line.split(Regex("\\s+"))
                wordCount += words.size

                for (char in line) {
                    if (char.isLetter()) {
                        if (char.lowercaseChar() in vowels) {
                            vowelCount++
                        } else {
                            consonantCount++
                        }
                    }
                }
            }

            println("Dosyada $lineCount satır var.")
            println("Dosyada $wordCount kelime var.")
            println("Dosyadaki harflerin $consonantCount tanesi sessiz.")
            println("Dosyadaki harflerin $vowelCount tanesi sesli.")

        } catch (e: FileNotFoundException) {
            println(e.message)
        }
    }


}
