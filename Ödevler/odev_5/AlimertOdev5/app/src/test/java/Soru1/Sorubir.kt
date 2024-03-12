package Soru1

open class Tasit(val marka: String, val model: String, val yıl: Int) {
    fun bilgileriGöster() {
        println("Marka: $marka, Model: $model, Yıl: $yıl")
    }
}

open class Araba(marka: String, model: String, yıl: Int) : Tasit(marka, model, yıl) {
    fun sür() {
        println("Araba sürülüyor.")
    }
}

open class Motosiklet(marka: String, model: String, yıl: Int) : Tasit(marka, model, yıl) {
    fun sür() {
        println("Motosiklet sürülüyor.")
    }
}