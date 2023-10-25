package com.bugcompany.vize

import com.bugcompany.vize.Question1.Question1
import com.bugcompany.vize.Question2.Question2
import com.bugcompany.vize.Question3.Question3
import com.bugcompany.vize.Question4.Question4
import com.bugcompany.vize.Question5.Question5
import com.bugcompany.vize.Question6.GeneralManager
import com.bugcompany.vize.Question6.Manager
import com.bugcompany.vize.Question6.Officer
import com.bugcompany.vize.Question6.Personal


fun main(args: Array<String>) {

    val question1 = Question1(1234)
    question1.sumDigit()

    val question2 = Question2()
    println(question2.reverseNumber(1237))


    val question3 = Question3.sum(5)
    question3.sumNumber()


    val question4 = Question4()
    println(question4.getSumOfAllPrimes(10))

    Question5(12)

    val officer: Personal = Officer(1000)
    val manager: Personal = Manager(3000)
    val generalManager: Personal = GeneralManager(5000)

    println(officer.calculateSalary(10))
    println(manager.calculateSalary(10))
    println(generalManager.calculateSalary(10))


}