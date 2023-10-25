package Soru2

class Soruiki  {
    val Inheritance = "14531"
    init {
        if (Inheritance.length == 5) {
            val tersSayi = Inheritance.reversed()
            println("Girilen sayının tersi: $tersSayi")
        } else {
            println("5 haneli bir sayı gereklidir.")
        }
    }
}