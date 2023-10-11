package com.works.turkcell._14_oop

class Profile (var num: Int, val name: String) {

    init {
        num += 1
        println("num : $num")
        println("init call")
    }

    fun fnc1() {
        println("$num $name")
    }



}