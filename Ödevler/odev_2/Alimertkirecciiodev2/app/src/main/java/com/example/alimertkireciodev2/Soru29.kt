package com.example.alimertkireciodev2
//Bir Quiz uygulaması geliştirin bir soru sorun doğru cevap verince tebrik mesajı , yanlış cevap verince hata mesajı versin. ( Oğuz Baran Şahingil)
fun main(args: Array<String>) {
    try {
        val soru = "Türkiyenin ana dili nedir?"
        val dogruCevap = "Türkçe"

        println(soru)
        val verilenCevap = readLine()

        if (verilenCevap == dogruCevap) {
            println("Tebrikler! Doğru cevap verdiniz.")
        } else {
            println("Üzgünüz, yanlış cevap verdiniz. Doğru cevap: $dogruCevap")
        }
    }catch (ex:Exception){
        println("Hatalı Soru")
    }

}