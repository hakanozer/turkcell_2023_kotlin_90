package com.bugcompany.challenge05.Question2

abstract class Employee(val name: String, val salary: Double) {

    abstract fun calculateBonus(): Double

    abstract fun printInfo()
}
