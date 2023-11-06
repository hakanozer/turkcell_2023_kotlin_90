package com.works.odev.Odev5

class Otomobil(marka:String,model:String,yil:Int, val motor:String):Arac(marka,model,yil) {
    fun kullan() {
        println("Araç kullanılıyor")
    }
}