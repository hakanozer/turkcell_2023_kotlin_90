package com.works.turkcell._14_oop

class Action {

    var name = "Ali"
    var surname = ""

    init {
        println("init call $name")
    }

    constructor() {
        name = "Erkan"
        println("constructor Empty Call $name")
    }

    constructor(name: String) {
        println("nameee $name")
        this.name = name
    }

    constructor( name: String, surname: String ) {
        this.name = name
        this.surname = surname
    }

    fun fnc1() {
        val surname = "Bilmem"
        println("fnc1 $name - $surname")
    }

    fun fnc2() {
        println(name)
    }

}