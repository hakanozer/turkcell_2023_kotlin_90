package com.bugcompany.challenge05.Question3

interface IMcDonalds {
    val location: String

    val superVisorCount: Int

    val fridgeCount: Int

    val employeeCount: Int

    fun calculateIncome(product: Product): Int

    fun info()
}