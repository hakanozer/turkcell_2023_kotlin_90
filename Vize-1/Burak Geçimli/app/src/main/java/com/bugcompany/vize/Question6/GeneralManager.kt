package com.bugcompany.vize.Question6

class GeneralManager(salary: Int) : Personal(salary) {

    override fun calculateSalary(additionalHour: Int): Int {
        val sumSalary = (salary + additionalHour * 0.8).toInt()

        return sumSalary
    }


}


/** Fonksiyon bu şekilde de return yerine yazılabilir.
 * override fun calculateSalary(additionalHour: Int) = (salary + additionalHour * 0.6).toInt()
 */