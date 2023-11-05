package com.davutkarakus.turkcellgelecegiyazanlarodev5

// Soru 5
open class Hayvan(val isim: String) {
    open fun sesCikar() {
        println("$isim ses cikariyor.")
    }
}

// `Hayvan` sınıfından türeyen `Köpek` sınıfı
class Kopek(isim: String) : Hayvan(isim) {
    override fun sesCikar() {
        println("$isim havliyor.")
    }
}

// `Hayvan` sınıfından türeyen `Kedi` sınıfı
class Kedi(isim: String) : Hayvan(isim) {
    override fun sesCikar() {
        println("$isim miyavliyor.")
    }
}