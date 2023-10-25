package com.bugcompany.vize.Question6

class Officer(salary: Int) : Personal(salary) {
    override fun calculateSalary(additionalHour: Int): Int {
        val sumSalary = (salary + additionalHour * 0.3).toInt()
        return sumSalary
    }
}