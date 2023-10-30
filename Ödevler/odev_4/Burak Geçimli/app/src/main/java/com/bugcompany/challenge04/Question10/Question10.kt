package com.bugcompany.challenge04.Question10

class Question10 {

    fun findLongestAndShortestText(textList: List<String>) {
        var longest = textList.first()
        var shortest = textList.first()
        var longestLength = textList.first().length

        textList.forEach { text ->
            if (text.length > longestLength) {
                longest = text
                longestLength = text.length
            } else if (text.length < shortest.length) {
                shortest = text
            }
        }

        println("Longest text: $longest")
        println("Shortest text: $shortest")

    }

}