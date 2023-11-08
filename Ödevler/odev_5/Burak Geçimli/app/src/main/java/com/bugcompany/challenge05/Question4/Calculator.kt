package com.bugcompany.challenge05.Question4

import kotlin.math.log10

class Calculator : IAdder, ISubtractor {
    override fun add(a: Int, b: Int) {
        println("Sum:${a + b}")
    }

    override fun subtract(a: Int, b: Int) {
        println("Subtract:${a - b}")
    }

    fun log(a: Double, b: Double) {
        println("Log:${log10(a / b)}")
    }

    fun printInfo(info: Any, format: String? = null) {
        if (format != null) {
            println(String.format(format, info))
        } else {
            println(info)
        }
    }

}