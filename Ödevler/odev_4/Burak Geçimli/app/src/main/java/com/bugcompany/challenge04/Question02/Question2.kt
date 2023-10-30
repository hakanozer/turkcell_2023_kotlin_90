package com.bugcompany.challenge04.Question02

import java.math.BigInteger

class Question2 {

    fun sumInteger() {
        val a = "23456789876543234567890987654567890"
        val b = "99999999999988888888882222222688981"

        try {
            val aNumber = BigInteger(a)
            val bNumber = BigInteger(b)

            val sum = aNumber + bNumber

            println("Toplam: $sum")
        } catch (e: NumberFormatException) {
            println("Geçersiz sayı: ${e.message}")
        }
    }
}