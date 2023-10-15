package com.bugcompany.challenge03

import java.io.File

class Question7 {

    fun find(file: File) {

        val text = file.readText()
        val words = text.split(" ")
        val wordCount = words.size
        val wordFrequency = mutableMapOf<String, Int>()
        var longestWord = ""
        var shortestWord = words.first()

        for (word in words) {
            // Kelimenin tekrar etme sayısını bulur.
            val cleanWord = word.trimEnd('.', ',', ':', ';', '?', '!')
            wordFrequency[cleanWord] = wordFrequency.getOrDefault(cleanWord, 0) + 1

            // En uzun kelimeyi bulur.
            if (cleanWord.length > longestWord.length) {
                longestWord = cleanWord
            }

            // En kısa kelimeyi bulur.
            if (cleanWord.length < shortestWord.length) {
                shortestWord = cleanWord
            }
        }


        println("There are $wordCount words in the file.")
        println("The number of times each word appears is as follows:")
        for ((word, frequency) in wordFrequency) {
            println("$word: $frequency")
        }
        println("The longest word is $longestWord and has ${longestWord.length} letters.")
        println("The shortest word is $shortestWord and has ${shortestWord.length} letters.")
    }


}






