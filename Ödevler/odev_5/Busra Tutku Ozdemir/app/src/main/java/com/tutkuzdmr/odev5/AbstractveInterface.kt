package com.tutkuzdmr.odev5


// Soyut sınıf
abstract class ElektronikCihaz(val marka: String) {
    abstract fun ac()
    abstract fun kapat()
}

// interface
interface BluetoothUyumlulugu {
    fun bluetoothBaglan()
    fun bluetoothKapat()
}

// ElektronikCihaz sınıfını miras alıp ve BluetoothUyumlulugu interface'ini uyguluyor.
class AkilliTelefon(marka: String) : ElektronikCihaz(marka), BluetoothUyumlulugu {
    override fun ac() {
        println("$marka akıllı telefon açılıyor.")
    }

    override fun kapat() {
        println("$marka akıllı telefon kapanıyor.")
    }

    override fun bluetoothBaglan() {
        println("$marka akıllı telefon Bluetooth ile bağlanıyor.")
    }

    override fun bluetoothKapat() {
        println("$marka akıllı telefon Bluetooth bağlantısını kapatıyor.")
    }
}

fun main() {
    val telefon = AkilliTelefon("Samsung")

    telefon.ac()
    telefon.bluetoothBaglan()
    telefon.bluetoothKapat()
    telefon.kapat()
}