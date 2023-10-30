fun main(args: Array<String>) {
    val ages = listOf(25, 18, 30, 21, 40, 22, 19, 29, 32, 26, 45, 50)
    val ageGroups = groupAges(ages)
    ageGroups.forEach { (ageGroup, ageList) ->
        println("$ageGroup yaş aralığındaki kişiler: $ageList")
    }
}
fun groupAges(ages: List<Int>): Map<String, List<Int>> {
    val ageGroups = mutableMapOf<String, List<Int>>()

    for (age in ages) {
        val ageGroup = yasaralığınıgetir(age)
        if (ageGroups.containsKey(ageGroup)) {
            ageGroups[ageGroup] = ageGroups[ageGroup]!! + age
        } else {
            ageGroups[ageGroup] = listOf(age)
        }
    }

    return ageGroups
}
fun yasaralığınıgetir(age: Int): String {
    return when (age) {
        in 18..24 -> "18-24"
        in 25..34 -> "25-34"
        in 35..44 -> "35-44"
        in 45..54 -> "45-54"
        in 55..64 -> "55-64"
        else -> "65+"
    }
}

