package com.nazlican.turkcellgelecegiyazanlarhomework4

import java.math.BigInteger

fun main() {
    val a = "23456789876543234567890987654567890"
    val b = "99999999999988888888882222222688981"

    val bigIntegerA = BigInteger(a)
    val bigIntegerB = BigInteger(b)

    val sum = bigIntegerA.add(bigIntegerB)
    println("Toplam: $sum")
}