package com.works.turkcellodevler.Odev_4

/*
7. İçinde çeşitli yaşları bulunduran bir List oluşturun. Bu yaşları gruplayarak yaş gruplarını içeren
bir Map oluşturun. Örneğin, "18-24" yaş aralığındaki kişileri bir grup olarak tutun.
 */

fun main(args: Array<String>) {

    val ages = listOf(18,12,16,24,31,9,55,48,41,65,78,61,28,33,58,81)

    val ageGroups = mutableMapOf<String, List<Int>>()
    ageGroups["18-24"] = ages.filter { it in 18..24 }
    ageGroups["25-40"] = ages.filter { it in 25..40 }
    ageGroups["41-60"] = ages.filter { it in 41..60 }
    ageGroups["61-75"] = ages.filter { it in 61..75 }
    ageGroups["76-90"] = ages.filter { it in 76..90 }

    for ((group, members) in ageGroups) {
        println("$group yaş aralığındaki kişiler: $members")
    }

}