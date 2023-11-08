package com.bugcompany.challenge05.Question2

/**
 * @author Burak Geçimli
 * @param name
 * @param salary
 * @param department
 */
class Manager(name: String, salary: Double, val department: String) : Employee(name, salary) {
    /**
     * @author Burak Geçimli
     * @return bonus:Double
     */
    override fun calculateBonus(): Double {
        val bonus = salary * 0.1
        return bonus
    }

    override fun printInfo() {
        println("Department: $department")
    }
}