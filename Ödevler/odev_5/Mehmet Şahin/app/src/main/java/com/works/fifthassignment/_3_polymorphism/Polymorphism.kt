package com.works.fifthassignment._3_polymorphism

open class Polymorphism {
    open fun bilgiVer() {
        println("Arac yolunda")
    }
}

class Tren : Polymorphism() {
    override fun bilgiVer() {
        println("Bu bir demiryolu aracıdır")
    }
}

class Ucak: Polymorphism() {
    override fun bilgiVer() {
        println("Bu bir havayolu aracıdır")
    }
}