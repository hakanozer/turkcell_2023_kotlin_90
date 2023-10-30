package com.bugcompany.challenge04.Question07

class Question7 {

    fun groupAge(ages: List<Int>) {
        val ageGroups = mapOf(
            "18-24" to ages.count { it in 18..24 },
            "25-34" to ages.count { it in 25..34 },
            "35-44" to ages.count { it in 35..44 },
            "45-54" to ages.count { it in 45..54 },
            "55-64" to ages.count { it in 55..64 }
        )

        ageGroups.forEach {
            println("${it.key} - ${it.value}")
        }
    }





}
