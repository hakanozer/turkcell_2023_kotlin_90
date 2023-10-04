package com.works.odevler

/**14- İki tam sayıyı bölen bir method yazın ve
bölenin sıfır olma durumunu try-catch bloğu ile ele alın.
Eğer bölen sıfır ise "Bölme işlemi sıfıra bölünemez." şeklinde bir hata mesajı döndürsün.
Aksi takdirde sonucu döndürsün. (Eyüp Balcan)
 */
fun main(args: Array<String>) {
    val a = 10
    val b = 0
    val sonuc = div(a,b)
    println(sonuc)

}

fun div(a:Int,b:Int): String {

    try {
        if (b==0){
            throw Exception("0 a bölünemez")
        }
        val bol = a/b
        return "bölüm $bol"
    }catch (ex:Exception){
       return ex.message  ?: " 0 a bölünmez !!!"
    }


}