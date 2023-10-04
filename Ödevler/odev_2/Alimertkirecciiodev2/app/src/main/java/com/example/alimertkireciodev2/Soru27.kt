package com.example.alimertkireciodev2
//27- Sizden buraya kaçıncı soruyu yazdığınızı örnek olarak girmeniz isteniyor.
//Geçersiz bir sayı veya karakter girildiğinde hata mesajı bastırınız
//ve kaçıncı soruyu yazdığınızın yeniden girilmesini sağlayınız.
//(soru sayısını 50 olarak alabilirsiniz.) (Berin Aslantaş)
fun main(args: Array<String>) {
    try {
        println("0 ila 50 arasında değer giriniz!")
        var sayi= readLine()!!.toInt()
        if (sayi>0){
            println("var Olan Soru Sayısı Girdiniz:$sayi")
        }else if (sayi<50){
            println("Soru Sayısını Aştınız$sayi")
        }
        println(sayi)
        return
    }catch (ex:Exception){
        println("Hatalı girdi Lütfen Aralıkdaki soru sayısını giriniz!")
    }

}