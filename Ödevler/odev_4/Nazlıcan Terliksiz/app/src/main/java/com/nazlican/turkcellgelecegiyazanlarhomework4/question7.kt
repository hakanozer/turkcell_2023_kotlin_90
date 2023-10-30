package com.nazlican.turkcellgelecegiyazanlarhomework4

fun main() {
    val ages = listOf(20, 25, 18, 30, 22, 19, 21, 27, 29, 35, 40, 18, 24, 26, 23, 31)

    val ageGroups = ages.groupBy { age ->
        when (age) {
            in 18..24 -> "18-24"
            in 25..34 -> "25-34"
            in 35..44 -> "35-44"
            else -> "45+"
        }
    }

    println("Yaş Grupları:")
    ageGroups.forEach { (ageGroup, people) ->
        println("$ageGroup: $people")
    }
}
