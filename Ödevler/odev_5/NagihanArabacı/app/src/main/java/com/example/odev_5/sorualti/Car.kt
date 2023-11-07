package com.example.odev_5.sorualti

class Car: CarAbstract(), CarInterface {
    override fun drive() {
        println("Araba sürülüyor")
    }

    override fun stop() {
        println("Araba durduruldu")
    }

    override fun model() {
        println("Araba modeli")
    }

    override fun color() {
        println("Araba rengi")
    }
}

