package com.works.turkcell._15_inheritance

class A : Base() {

    init {
        println("A Call")
    }

    fun minus( num1: Int ) {
        println("Min : $num1")
    }

    override fun call() {
        num3 = 10
        action(30,56)
    }

}