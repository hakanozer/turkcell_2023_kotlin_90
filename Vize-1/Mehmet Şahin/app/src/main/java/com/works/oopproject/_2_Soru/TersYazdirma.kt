package com.works.oopproject._2_Soru

class TersYazdirma {
    fun tersSayi(sayi:Int) : String {
        if(sayi in 10000.. 99999) {
            val sayiStr = sayi.toString()
            val tersStr = sayiStr.reversed()
            println("Ters sayiniz: $tersStr")
            return tersStr
        } else{
            println("Lütfen sadece 5 haneli sayi giriniz!")
            return ""
        }
    }
}