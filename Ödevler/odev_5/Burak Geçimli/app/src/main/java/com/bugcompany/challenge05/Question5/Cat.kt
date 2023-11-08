package com.bugcompany.challenge05.Question5

/**
 * @author Burak Geçimli
 * @param name
 * @param age
 */
class Cat(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("Cat making sound!")
    }

    override fun info() {
        println("Cat Name:$name Cat Age:$age")
    }
}