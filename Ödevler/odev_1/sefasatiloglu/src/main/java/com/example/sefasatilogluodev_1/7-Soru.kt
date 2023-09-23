package com.example.sefasatilogluodev_1

import java.util.Scanner

/*
Kullanıcıdan Kac Sayi Girecegini Ogren (N)
    Kullanıcıdan N Tane Sayı Al

    Sayı Girişi Bittikten Sonra Aşağıdakine Benzer Bir Rapor Olustur
    Girilen 17 Sayıdan :
    8 Tanesi Pozitif
    6 Tanesi Negatif
    En Büyüğü : 67
    En Küçüğü : -9
    10 Tanesi Çift
    7 Tanesi Tek
    Toplamları : 567
    Ortalamaları : 33,345
 */

fun main() {



    val girdi = Scanner(System.`in`)
    println("Kaç Sayi Gireceksiniz:")
    var pozitifSayi = 0
    var negatifSayi = 0
    var toplam = 0
    var ciftSayi = 0
    var tekSayi = 0
    val sayiAl = girdi.nextInt()
    val arr = arrayOfNulls<Int>(sayiAl)
    for (i in 0 until sayiAl) {
        println("${i+1}.sayiyi giriniz:")
        arr[i] = girdi.nextInt()

    }
    println("Girdiğimiz Sayilar:")
    var enBuyuk = arr[0]
    var enKucuk = arr[0]
    for (num in arr) {
        if (num != null) {
            if (num > 0) {
                //println("$num pozitiftir.")
                pozitifSayi++
            }else {
                //println("$num negatiftir.")
                negatifSayi++
            }
            if (num > enBuyuk!!) {
                enBuyuk = num

            }
            if (num < enKucuk!!) {
                enKucuk = num
            }
            if (num % 2 == 0) {
                //println("$num çifttir")
                ciftSayi++
            }else {
                //println("$num tektir")
                tekSayi++
            }
        toplam+=num
        }
    }
    val ortalama = (toplam.toDouble() / sayiAl)
    println("**************************************************************************")

    println("""
        
       Girilen $sayiAl Sayıdan:
       
       $pozitifSayi tane pozitif
       $negatifSayi tane negatif
       En buyuk sayi: $enBuyuk
       En kucuk sayi: $enKucuk
       $ciftSayi tane cift
       $tekSayi tane tek
       Toplam : $toplam
       Ortalamalari : $ortalama
        
        
        
    """)




}