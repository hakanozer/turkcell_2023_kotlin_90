package com.works.turkcellodevler.Odev_2

/*
30- Kullanıcıdan, ad soyad, yaş ve mail istediğiniz 3 değer alınız.
Try catch yapısını kullanarak, mailin doğru yazılılıp yazılmadığını,
ad ve soy adı birleştirip küçükterek kullanıcı adı oluşturmayı ve yaş 18 ve üzeri girildiyse
bilgileri listeleyip kaydı tamamlayınız aksi takdirde kayıt kabul edilmesin. (Muhammed Zeyd Satılmış)
 */

fun main(args: Array<String>) {

    try {
        print("Adınızı giriniz: ")
        val name = readLine() ?: ""
        print("Soyadınızı giriniz: ")
        val surname = readLine() ?: ""
        print("Yaşınızı giriniz: ")
        val age = readLine()?.toIntOrNull() ?: 0
        print("E-posta adresinizi giriniz: ")
        val mail = readLine() ?: ""

        if (!mail.contains("@") || !mail.contains(".")) {
            throw IllegalArgumentException("Geçersiz e-posta adresi formatı!")
        }

        val userName = (name + surname).toLowerCase()
        println(userName)

        if (age >= 18) {
            println("Kullanıcı Adı: $userName")
            println("Ad: $name")
            println("Soyad: $surname")
            println("Yaş: $age")
            println("E-posta: $mail")
            println("Kayıt tamamlandı!")
        } else {
            println("Yaşınız 18'den küçük olduğu için kayıt alınamadı.")
        }
    } catch (ex: Exception) {
        println("Hata: ${ex.message}")
    }
}