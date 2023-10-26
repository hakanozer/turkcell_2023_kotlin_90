package com.bugcompany.vize.Question6

class Manager(salary: Int) : Personal(salary) {
    override fun calculateSalary(additionalHour: Int): Int {
        val sumSalary = (salary + additionalHour * 0.6).toInt()

        return sumSalary
    }
}