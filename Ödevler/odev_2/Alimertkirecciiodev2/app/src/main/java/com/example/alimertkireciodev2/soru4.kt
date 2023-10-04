package com.example.alimertkireciodev2fun LongSorusu(Sayi1: Long): Int {
    var deger = 0
    val verdiğimizsayi = Sayi1.toString()

    for (i in verdiğimizsayi) {
        if(i.isDigit()){
            deger += i.digitToInt()
        }
    }
    return deger
}
fun main(args: Array<String>) {
   println(LongSorusu(3214564))
}
//4 - parametre olarak verilen long sayisinin
//rakamlarinin toplamını döndüren methodu
//yazin