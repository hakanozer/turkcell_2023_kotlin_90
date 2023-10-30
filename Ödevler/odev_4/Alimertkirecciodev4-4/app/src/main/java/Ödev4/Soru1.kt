fun main(args: Array<String>) {
    val Altısay = 6
    val kucuk = 1
    val Buyuk = 49


    val Rastgelesay = mutableListOf<Int>()

    while (Rastgelesay.size < Altısay) {
        val SayiSec = (kucuk..Buyuk).random()
        if (!Rastgelesay.contains(SayiSec)) {
            Rastgelesay.add(SayiSec)
        }
    }

    println("Rastegele Seçilen Altı Sayı=: $Rastgelesay")
}

