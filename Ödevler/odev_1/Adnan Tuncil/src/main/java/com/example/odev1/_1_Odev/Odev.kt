package com.example.odev1._1_Odev

import java.util.Scanner

fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    // Ödev madde 1
    /*print("Kenar 1 : ")
    val kenar1 = scanner.nextInt()
    print("Kenar 2 : ")
    val kenar2 = scanner.nextInt()
    print("Kenar 3 : ")
    val kenar3 = scanner.nextInt()
    odev1(kenar1,kenar2,kenar3) */

    //Ödev madde 2
    /*print("Menü : \n1 - F -> C \n2 - F -> C \nSeçim : ")
    val secim = scanner.nextInt()
    print("Lütfen Sıcaklık değerini giriniz : ")
    val deger = scanner.nextDouble()
    odev2(secim, deger) */

    // Ödev madde 3
    /*print("Sayı1 Değerini Giriniz :  ")
    val scnum1 = scanner.nextInt()
    print("Sayı2 Değerini Giriniz :  ")
    val scnum2 = scanner.nextInt()
    odev3(scnum1,scnum2) */

    // Ödev madde 4
    /*println("Lütfen bir sayı giriniz..")
    val number = scanner.nextInt()
    odev4(number) */

    // Ödev madde 5
    /*print("Lütfen bir sayı giriniz: ")
    val stNumber = readlnOrNull()
    if (stNumber != null ) {
        odev5(stNumber)
    }  */

    // Ödev madde 6
    /*print("Lütfen 3 basamaklı bir sayı giriniz: ")
    val stSayi = scanner.next()
    odev6(stSayi)  */

    // Ödev madde 7
    /*print("Lütfen gireceğin sayı miktarını yaz: ")
    val ndeger = scanner.nextInt()
    var pozitif = 0
    var negatif = 0
    for (i in 1..ndeger){
        print("$i . değeri giriniz: ")
        var deger = scanner.nextInt()
        if (deger > 0) {
            pozitif ++
        } else if (deger < 0) {
            negatif ++
        }
    }
    println("$pozitif tanesi pozitif.")
    println("$negatif tanesi negatif.") */

}

fun odev1(kenar1: Int, kenar2: Int, kenar3: Int){

    if ( kenar1 + kenar2 >= kenar3 && kenar1 + kenar3 >= kenar2 && kenar2 + kenar3 >= kenar1){
        println("Oluşturulan üçgen : $kenar1 , $kenar2 , $kenar3")
        println("Üçgen oluşturulabir.")
    } else {
        println("Girilen değerlerden üçgen oluşmamaktadır.")
    }
    return
}

fun odev2( secim : Int , deger : Double ){

    if (secim == 1){
        println("Girdiğiniz Fahrenheit değeriniz : $deger")
        val sonuc = (deger-32) / 1.8
        println("$deger F = $sonuc C ")

    } else if ( secim == 2){
        println("Girdiğiniz Celsius değeriniz : $deger")
        val sonuc = (deger * 1.8) + 32
        println("$deger C = $sonuc F ")
    } else {
        println("Lütfen menüde ki 1 veya 2 değerini giriniz!!!")
    }
    return
}

fun odev3(num1: Int, num2: Int) {

    if (num1 > num2){
        println("Sayı1: $num1 ----- Sayı2: $num2")
        println("Sayı1($num1) büyüktür Sayı2($num2) 'den")
    } else if (num2 > num1){
        println("Sayı1: $num1 ----- Sayı2: $num2")
        println("Sayı2($num2) büyüktür Sayı1($num1) 'den")
    } else {
        println("Sayı1: $num1 ----- Sayı2: $num2")
        println("Sayı2($num2) eşittir Sayı1($num1) 'e")
    }
    return
}

fun odev4(number: Int) {
    var total = 0
    for (i in 1..number){
        total += i
    }
    println("Girilen Sayı: $number")
    println("1 'den $number 'a kadar olan sayıların toplamı: $total")
    return
}

fun odev5(stNumber : String){
    var total = 0
    var i = 1
    println("Girilen 3 basamaklı sayı: $stNumber")
    for (item in stNumber){
        var sayi = item.digitToInt()
        if (i == stNumber.length){
            print("$sayi ")
        } else {
            print("$sayi + ")
        }
        total = total + sayi
        i++
    }
    println("= $total")
    return
}

fun odev6(stSayi : String){

    val cSayi1 = stSayi[0]
    val cSayi2 = stSayi[1]
    val cSayi3 = stSayi[2]
    println("$cSayi3$cSayi2$cSayi1")
    return
}

fun odev7( Ndeger: Int){


    return
}