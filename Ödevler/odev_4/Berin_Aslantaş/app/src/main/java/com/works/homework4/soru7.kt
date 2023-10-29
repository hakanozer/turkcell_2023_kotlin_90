package com.works.homework4


class Soru7 {
    fun groupAgesByRange(ageList: List<Int>): Map<String, List<Int>> {
        return ageList.groupBy { age ->
            when (age) {
                in 0..18 -> "0-18"
                in 19..24 -> "19-24"
                in 25..34 -> "25-34"
                in 35..44 -> "35-44"
                else -> "45+"
            }
        }
    }
}


fun main() {
    val ageList = listOf(12, 19, 21, 24, 27, 28, 36, 44)

    val ageGrouper = Soru7()
    val ageGroups = ageGrouper.groupAgesByRange(ageList)

    val age25_34 = ageGroups["25-34"] ?: emptyList()

    val resultMap = mapOf("25-34" to age25_34)

    println("Yaş Grupları:")
    resultMap.forEach { (group, ages) ->
        println("$group yaş aralığındaki kişiler: $ages")
    }
}
