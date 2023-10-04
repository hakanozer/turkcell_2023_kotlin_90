package com.example.alimertkireciodev2

fun main(args: Array<String>) {
    try {
        print("Yaşınızı girin: ")
        val yas = readLine()!!.toIntOrNull()

        if (yas == null || yas < 0) {
            println("Geçerli bir yaş giriniz.")
            return
        }
        val ehliyetYasi = 18
        if (yas < ehliyetYasi) {
            val kacSeneSonraAlabilir = ehliyetYasi - yas
            println("Maalesef ehliyet alacak yaşta değilsiniz, $kacSeneSonraAlabilir yıl sonra ehliyet almaya hak kazanabilirsiniz!")
        } else if (yas == ehliyetYasi) {
            println("Tebrikler! Ehliyet alabilirsiniz.")
        } else {
            println("Ehliyet alabilirsiniz.")
        }
    } catch (ex: Exception) {
        println("Geçerli bir yaş girin.")
    }
}





