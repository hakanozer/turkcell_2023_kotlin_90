package com.example.alimertkireciodev2
//bir sayıyı sıfıra bölmeye çalışırken karşılaşılan
// bir hata durumunu ele almak için nasıl bir try-catch bloğu oluşturursunuz?
//Hocam burda normal bölme de yapılabilir 0 girilirse hata verecektir.
fun main(args: Array<String>) {

    println("Birinci sayıyı giriniz!")
    var bölüm= readLine()!!.toInt()
    println("Lütfen 2. sayıyı giriniz!")
    var bölen= readLine()!!.toInt()

    var islem:Int=0
        try {
            islem=bölüm/bölen
            println("Sonuc: $islem")
        }catch (ex:Exception){
            println("Hata Sıfıra bölünmez!!")
            ex.printStackTrace()
        }


}