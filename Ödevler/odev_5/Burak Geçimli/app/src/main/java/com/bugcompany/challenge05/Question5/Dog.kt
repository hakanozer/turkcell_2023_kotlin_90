package com.bugcompany.challenge05.Question5

/**
 * @author Burak Geçimli
 * @param name
 * @param age
 */
class Dog(name: String, age: Int) : Animal(name, age) {

    override fun makeSound() {
        println("Dog making sound")
    }

    override fun info() {
        println("Dog Name:$name Dog Age:$age")
    }
}