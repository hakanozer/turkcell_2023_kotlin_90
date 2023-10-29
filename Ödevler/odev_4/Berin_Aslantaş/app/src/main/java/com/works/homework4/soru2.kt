package com.works.homework4

import java.math.BigInteger


class Soru2 {
    fun addBigNumbers(a: String, b: String): String {
        val bigA = BigInteger(a)
        val bigB = BigInteger(b)
        val result = bigA.add(bigB)
        return result.toString()
    }
}


fun main() {
    val a = "23456789876543234567890987654567890"
    val b = "99999999999988888888882222222688981"

    val bigNumberAdder = Soru2()
    val sum = bigNumberAdder.addBigNumbers(a, b)

    println("Toplam: $sum")
}
