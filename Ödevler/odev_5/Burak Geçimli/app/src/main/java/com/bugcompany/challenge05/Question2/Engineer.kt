package com.bugcompany.challenge05.Question2

/**
 * @author Burak Geçimli
 * @param name
 * @param salary
 * @param project
 */
class Engineer(name: String, salary: Double, val project: String): Employee(name, salary) {
    override fun calculateBonus(): Double {
        /**
         * @author Burak Geçimli
         * @return bonus:Double
         */
        val bonus=salary * 0.05
        return bonus
    }

    override fun printInfo() {
        println("Project: $project")
    }
}