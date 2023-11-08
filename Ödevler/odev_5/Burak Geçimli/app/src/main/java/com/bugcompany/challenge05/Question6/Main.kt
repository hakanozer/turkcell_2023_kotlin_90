package com.bugcompany.challenge05.Question6

/**
 * Tesla sınıfımız özünde bir araçtır.Bunu kullanarak bir Absstract Class tanımladık ve miras aldık.Böylece
 * Tesla bir araçtır.Sonrasında ise Tesla aracına Elektrikli olma yeteneğini kazandırmak için Electric adında
 * interface oluşturup Tesla sınıfına implementasyonunu vererek Tesla ya Elektrikli Araç özelliğini kazandırmış olduk.
 */

fun main() {
    val tesla = Tesla("Tesla", "Model 5", 2022, 80)
    tesla.start()
    tesla.stop()
    tesla.honk()
    tesla.charge()
    tesla.showBatteryLevel()
    println("-------------------------------------------")
    tesla.info()

}