package com.works.turkcell._15_inheritance

fun main(args: Array<String>) {

    val nsa: Base = A()
    val nsb: Base = B()
    val nsc: Base = C()

    action(nsa)
    action(nsb)
    action(nsc)
}

fun action( obj: Base ) {
    obj.call()
}