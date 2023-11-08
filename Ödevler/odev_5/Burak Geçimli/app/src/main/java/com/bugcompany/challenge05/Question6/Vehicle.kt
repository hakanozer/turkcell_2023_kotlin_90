package com.bugcompany.challenge05.Question6

abstract class Vehicle(val brand: String, val model: String, val year: Int) {
    abstract fun start()
    abstract fun stop()
    abstract fun honk()

    val age: Int get() = 2023 - year
}
