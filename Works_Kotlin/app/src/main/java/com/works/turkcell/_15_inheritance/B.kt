package com.works.turkcell._15_inheritance

class B : Base(){

    init {
        println("B Call")
    }

    override fun call() {
        num3 = 20
        action(30,56)
    }


}