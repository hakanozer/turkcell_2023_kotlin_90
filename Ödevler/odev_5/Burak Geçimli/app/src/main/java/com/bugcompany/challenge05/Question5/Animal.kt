package com.bugcompany.challenge05.Question5

/**
 * @author Burak Geçimli
 * @param name
 * @param age
 */
open class Animal(val name: String, val age: Int) {

    open fun makeSound() {
        println("Animal make sound!")
    }

    open fun info() {
        println("Animal Info")
    }
}
