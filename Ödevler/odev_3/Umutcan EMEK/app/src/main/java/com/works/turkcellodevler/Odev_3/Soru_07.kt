package com.works.turkcellodevler.Odev_3

import java.io.File

/*
#7. 4. Sorudaki dump.txt'de Her Kelimeden Kaç Kez Geçtiğini,
En Uzun Kelimenin Hangisi Olduğunu, Kaç Harf Olduğunu
En Kısa Kelimenin Hangisi Olduğunu ve Kaç Harf Olduğunu Ekrana Bastırın
 */

fun main(args: Array<String>) {

    val dump = File("C:\\Users\\umutc\\Desktop\\dump.txt")

    val scope = dump.readText()
    val words = scope.split(Regex("\\s+"))

    val wordRepetition = mutableMapOf<String, Int>()
    var longestWord: String? = null
    var shortestWord: String? = words.firstOrNull()

    for (word in words) {
        if (word.isNotBlank()) {
            wordRepetition[word] = wordRepetition.getOrDefault(word, 0) + 1
            if (longestWord == null || word.length > longestWord.length) {
                longestWord = word
            }
            if (shortestWord == null || word.length < shortestWord.length) {
                shortestWord = word
            }
        }
    }
    println("Kelimeler kaç kere geçiyor: ")
    for ((word, repetition) in wordRepetition) {
        println("$word: $repetition")
    }
    println("--------------------------------------")
    println("En uzun kelime: $longestWord \nKelimenin uzunluğu: ${longestWord?.length}")
    println("En kısa kelime: $shortestWord \nKelimenin uzunluğu: ${shortestWord?.length}")

}

