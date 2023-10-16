package com.works.turkcell._15_inheritance

open class Base {

    constructor() {
        println("Base Call")
    }

    var num3:Int = 1

    open fun call() {}

    fun action( num1: Int, num2: Int ) {
        val end = num1 * num2 * num3
        println("Ent : $end")
    }

}