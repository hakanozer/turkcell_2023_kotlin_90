package com.bugcompany.challenge05.Question6

/**
 * @author Burak Geçimli
 * @param brand
 * @param model
 * @param year
 * @param batteryLevel
 */
class Tesla(brand: String, model: String, year: Int, override var batteryLevel: Int) :
    Vehicle(brand, model, year), Electric {
    override fun start() {
        println("$brand $model çalıştırılıyor...")
    }

    override fun stop() {
        println("$brand $model duruyor...")
    }


    override fun charge() {
        println("$brand $model şarj ediliyor...")
        batteryLevel = 100
    }

    override fun honk() {
        println("Tesla korna sesi")
    }

    fun info() {
        println("Marka: $brand")
        println("Model: $model")
        println("Yıl: $year")
        println("Yaş: $age")
        println("Pil seviyesi: $batteryLevel")
        println("Tam şarjlı mı: $isFullyCharged")
    }


}
