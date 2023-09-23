package com.davutkarakus.turkcellgelecegiyazanlarodev

import java.util.Scanner

fun main() {
    ucgenOlurMu()
    sicaklikDonustur()
    ikiSayiAl()
    sayiToplam()
    ucHaneliSayiBasamakToplami()
    ucHaneliSayiTerstenYazdir()
    raporOlustur()
}

fun ucgenOlurMu() {
    println("Birinci Kenar Uzunlugunu Giriniz:")
    val kenarBir = readlnOrNull()
    println("Ikinci Kenar Uzunlugunu Giriniz:")
    val kenarIki = readlnOrNull()
    println("Ucuncu Kenar Uzunlugunu Giriniz:")
    val kenarUc = readlnOrNull()

    if(kenarBir !=null && kenarIki !=null && kenarUc != null){
        try {
            val k1 = kenarBir.toDouble()
            val k2 = kenarIki.toDouble()
            val k3 = kenarUc.toDouble()
            if(k1+k2 >= k3 && k1+k3 >= k2 && k3+k2 >= k1) {
                println("Bu kenar degerleri ile bir ucgen olusturabilir")
            }else {
                println("Bu kenar degerleri ile bir ucgen olusturalamaz")
            }
        }catch (e:Exception) {
            println("Lutfen sadece sayisal degerler giriniz!")
        }
    }
}

fun sicaklikDonustur() {
    println("Menu : ")
    println("1 - F -> C")
    println("2 - C -> F")
    println("Secim : ")
    val secim = readlnOrNull()
    if(secim != null) {
        try {
            val s = secim.toInt()
            if(s == 1 || s == 2) {
                println("Sicaklik Degerini Giriniz:")
                val sicaklikDeger = readlnOrNull()
                if (sicaklikDeger != null) {
                    try {
                        val sD = sicaklikDeger.toDouble()
                        if(s == 1) {
                            val newSd = (sD - 32)/1.8
                            println("$sD F = $newSd C")
                        }else {
                            val newSd = (sD * 1.8) + 32
                            println("$sD C = $newSd F")
                        }
                    }catch (e:Exception){
                        println("Hatali sicaklik girisi!")
                    }
                }
            }else {
                println("Hatali secim!")
            }
        }catch (e:Exception){
            println("Hatali secim!")
        }
    }
}
fun ikiSayiAl() {
    println("Birinci Sayiyi Giriniz:")
    val sayiBir = readlnOrNull()
    println("Ikinci Sayiyi Giriniz:")
    val sayiIki = readlnOrNull()
    if(sayiBir != null && sayiIki != null) {
        try {
            val s1 = sayiBir.toDouble()
            val s2 = sayiIki.toDouble()
            if (s1 == s2) {
                println("Bu iki sayi birbirine esittir")
            }else if (s1 > s2) {
                println("Buyuk Sayi : $s1")
                println("Kucuk Sayi : $s2")
            }else {
                println("Buyuk Sayi : $s2")
                println("Kucuk Sayi : $s1")
            }
        }catch (e:Exception) {
            println("Lutfen sadece sayisal degerler giriniz!")
        }
    }
}

fun sayiToplam() {
    println("Bir Sayi Giriniz:")
    val scanner = Scanner(System.`in`)
    val sayi = scanner.nextInt()
            if(sayi >= 0) {
                val toplam = (sayi * (sayi+1)) / 2
                println("$sayi e kadar olan sayilarin toplami = $toplam")
            }else {
                val toplam = -(sayi * (sayi-1)) / 2
                println("$sayi e kadar olan sayilarin toplami = $toplam")
            }
}
fun ucHaneliSayiBasamakToplami() {
    println("Uc Haneli Bir Sayi Giriniz:")
    val scanner = Scanner(System.`in`)
    var sayi = scanner.nextInt()
            if (sayi in 100..999) {
                var toplam = 0
                while (sayi > 0){
                    toplam += sayi % 10
                    sayi /= 10
                }
                println("Sayinin Basamaklari Toplami : $toplam")
            }else {
                println("Lutfen sadece uc basamakli sayisal degerler giriniz!")
            }
    }
fun ucHaneliSayiTerstenYazdir() {
    println("Uc Haneli Bir Sayi Giriniz:")
    val scanner = Scanner(System.`in`)
    var sayi = scanner.nextInt()
    var reverse = 0
    if (sayi in 100..999) {
        while (sayi != 0) {
            reverse *= 10
            reverse += sayi % 10
            sayi /= 10
        }
        println("Girilen Sayinin Tersten Yazilmis Hali : $reverse")
    }else {
        println("Lutfen sadece uc basamakli sayisal degerler giriniz!")
    }
}
fun raporOlustur() {
    println("Kac Adet Sayi Gireceginizi Yaziniz:")
    val scanner = Scanner(System.`in`)
    val sayi = scanner.nextInt()
    val list = arrayListOf<Int>()
    var toplam = 0
    var pos = 0
    var neg = 0
    var tek = 0
    var cift = 0
    var n = 0
    while (n < sayi) {
        println("${n+1}.Sayiyi Giriniz:")
        list.add(scanner.nextInt())
        n++
    }
    for (i in list) {
        toplam += i
        if (i < 0) {
            neg += 1
        }else if (i > 0) {
            pos += 1
        }
        if(i % 2 == 0){
            cift ++
        }else if (i % 2 == 1) {
            tek ++
        }
    }
    println("Girilen $sayi Sayidan :")
    println("$pos Tanesi Pozitif")
    println("$neg Tanesi Negatif")
    println("En Buyugu : ${list.maxOrNull()}")
    println("En Kucugu : ${list.minOrNull()}")
    println("$tek Tanesi Tek")
    println("$cift Tanesi Cift")
    println("Toplamlari : $toplam")
    println("Ortalamalari : ${(toplam.toDouble()/sayi.toDouble())}")
}