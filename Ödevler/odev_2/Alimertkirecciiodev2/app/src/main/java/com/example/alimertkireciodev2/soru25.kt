package com.example.alimertkireciodev2
// Kullanıcıdan pozitif bir tam sayı alınız ve bu sayının faktöriyelini hesaplayınız. Kullanıcı metin
// veya negatif bir tam sayı girişi yaptığında try-catch ile hata mesajları görüntüleyiniz. (Mehmet Şahin)
fun main(args: Array<String>) {
    try {
        print("Pozitif bir tam sayı girin: ")
        val sayi = readLine()!!.toInt()
        if (sayi < 0) {
            throw Exception("Negatif bir sayı giremezsiniz.")
        }

        var faktöriyel = 1
        for (i in 1..sayi) {
            faktöriyel *= i
        }

        println("$sayi faktöriyeli: $faktöriyel")
    } catch (ex:  Exception) {
        println("Geçerli bir tamsayı girin.")
    } catch (e: Exception) {
        println(e.message)
    }
}