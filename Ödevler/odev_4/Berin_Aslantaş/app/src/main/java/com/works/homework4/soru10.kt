package com.works.homework4


class soru10 {
    fun findShortestAndLongestTexts(textList: List<String>): Pair<String?, String?> {
        val sortedTexts = textList.sortedBy { it.length }
        val shortestText = sortedTexts.firstOrNull()
        val longestText = sortedTexts.lastOrNull()
        return Pair(shortestText, longestText)
    }
}


fun main() {
    val metinler = listOf(
        "Cumhuriyetimizin yüzüncü yılı kutlu olsun.",
        "Ne mutlu Türk'üm diyene.",
        "Yaşasın Cumhuriyet.",
    )

    val Text = soru10()
    val (enKisaMetin, enUzunMetin) = Text.findShortestAndLongestTexts(metinler)

    println("En kısa metin: $enKisaMetin")
    println("En uzun metin: $enUzunMetin")
}
