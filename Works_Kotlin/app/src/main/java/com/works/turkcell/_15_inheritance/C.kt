package com.works.turkcell._15_inheritance

class C : Base() {

    init {
        println("C Call")
    }

    override fun call() {
        num3 = 30
        action(30,56)
    }

}