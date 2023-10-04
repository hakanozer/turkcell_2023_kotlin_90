package com.works.odevler

import java.lang.RuntimeException
import java.util.Scanner

/**
 *30- Kullanıcıdan, ad soyad, yaş ve mail istediğiniz 3 değer alınız.
 * Try catch yapısını kullanarak, mailin doğru yazılılıp yazılmadığını,
 * ad ve soy adı birleştirip küçükterek kullanıcı adı oluşturmayı ve yaş 18 ve üzeri girildiyse
 * bilgileri listeleyip kaydı tamamlayınız aksi takdirde kayıt kabul edilmesin. (Muhammed Zeyd Satılmış)
 */
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

     try {
         println("Mail adresinizi giriniz!")
         val mail = scanner.nextLine()
        println("Adınızı ve soyadınızı giriniz!")
        val adSoyad:String = scanner.nextLine()
        println("Yaşınızı giriniz!")
        val yas = scanner.nextInt()

        val kullanciAdi= adSoyad.lowercase()
        val liste = mutableListOf<Any>()
        val kabulYası = 18 - yas

        if (emailKontrol(mail) && yas > 18) {
            liste.add(kullanciAdi)
            liste.add(yas)
            liste.add(mail)
            println(liste)
        }else if(yas < 18){
            throw RuntimeException("Listeleme kabul edilemiyor $kabulYası yıl sonra tekrar deneyiniz")
        }else{
            throw RuntimeException("Geçerli bi mail adresi giriniz")
        }


    }catch (ex:Exception){
        println(ex.message)
    }
}
fun emailKontrol(email: String): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return email.matches(emailRegex.toRegex())
}


