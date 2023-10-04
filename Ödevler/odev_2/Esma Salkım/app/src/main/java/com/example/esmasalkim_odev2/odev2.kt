package com.example.esmasalkim_odev2

import java.util.Scanner


fun main(args: Array<String>) {

    println("====================== Soru-1 =========================")

    val isPrimee = isPrime(11)
    println(isPrimee)

    println("====================== Soru-2 =========================")

    val summ = sum(2, 5)
    println(summ)

    println("====================== Soru-3 =========================")

    val sor3 = numType(6, 4)
    println(sor3)

    println("====================== Soru-4 =========================")

    val long = numLong(125321425412)
    println(long)

    println("====================== Soru-5 =========================")

    val bmi = bodyIndex(60.0, 1.70)
    println(bmi)

    println("====================== Soru-6 =========================")

    println(numReversed(123456789))

    println("====================== Soru-7 =========================")

    println(isPolindrom(13131))

    println("====================== Soru-8 =========================")

    val numArray = intArrayOf(1, 2, 5, 6, 8, 10, -9)
    println(sumMaxMin(numArray))

    println("====================== Soru-9 =========================")

    val arr = intArrayOf(5, 6, 8, 9, 2, 1, 30, 60)
    println(arrayIsSayi(arr, 9))

    println("====================== Soru-10 =========================")

    val scanner = Scanner(System.`in`)
    println("Lütfen 4 tane sayı girin!")
    val sayilar = IntArray(4)
    for (i in 0 until 4) {
        println(" Sayı ${i + 1}:  ")
        sayilar[i] = scanner.nextInt()
    }
    val enBuyuk = numMax(sayilar)
    println(" En büyük sayı : $enBuyuk ")

    println("====================== Soru-11 =========================")

    val array1 = intArrayOf(2,3,6,9,8,4,5,1)
    val array2 = intArrayOf(2,3,6,-2,5,1)
    println(partArr(array1, array2))

    println("====================== Soru-12 =========================")

   println(sifiraBölme(10,0))

    println("====================== Soru-13 =========================")

    println(sayiMi())

    println("====================== Soru-14 =========================")

    println(bolenSifirMi(100, 0))

    println("====================== Soru-15 =========================")

    println(ortalamaHesapla())

    println("====================== Soru-16 =========================")

    println("1.String ifade: ")
    val str1 = scanner.next()
    println("2.String ifade: ")
    val str2 = scanner.next()

    if (str1 != null && str1.isNotBlank() && str2 != null && str2.isNotBlank()) {
        karakterKarsilastir(str1, str2)
    } else {
        println("Lütfen iki string ifade giriniz!")
    }

    println("====================== Soru-17 =========================")
    println("Metin giriniz !")
    val girilenMetin = scanner.nextLine()
    println(metinCevir(girilenMetin))

    println("====================== Soru-18 =========================")

    println("1.Sayı: ")
    val input1 = scanner.nextInt()
    println("2.Sayi: ")
    val input2 = scanner.nextInt()
    println(ikiSayiCarp(input1, input2))

    println("====================== Soru-19 =========================")

        println("4 basamaklı bir sayı girin : ")
        val dortBasamakliSayi = scanner.nextInt()
        println(kalanSifirMi(dortBasamakliSayi))

    println("====================== Soru-20 =========================")

    println(" 0 ile 20 arasında 5 sayı giriniz ! ")
    println(aritmetikOrtalamaHesapla())

    println("====================== Soru-21 =========================")

    println(listeBoyutuVeElemanlar())

    println("====================== Soru-22 =========================")

        val limit: Int = 10000 // Mükemmel sayıları belirli bir sınıra kadar kontrol edebiliriz.

        println("Mükemmel sayılar:")
        for (sayi in 1..limit) {
            if (isMukemmelSayi(sayi)) {
                println(sayi)
            }
        }
    println("====================== Soru-23 =========================")

    println(karekokHesapla())

    println("====================== Soru-24=========================")

    println("3 basamaklı bir sayı giriniz: ")
    val sayi = readLine()?.toInt() ?: throw Exception("Geçerli bir sayı girmelisiniz.")
    println(armstrongSayi(sayi))

    println("====================== Soru-25 =========================")

    println(faktoriyelHesapla())

    println("====================== Soru-26 =========================")

    println(ehliyetAlabilirMi())

    println("====================== Soru-27 =========================")

    println(soruKac())

    println("====================== Soru-28 =========================")

    println(universiteyeYerleşirMi())

    println("====================== Soru-29 =========================")

    println(quiz())

    println("====================== Soru-30 =========================")

    // yarısına kadar geldim devamını yapamadığım için kod çalışmadı eklemedim bu yüzden.

}

// 1-)

fun isPrime (num:Int): Boolean {
    var sonuc = true
    if (num >= 2){
        for ( i in 2..num-1 ){
            if ( num % i == 0){
                sonuc = false
                break
            }
        }
    }else{
        sonuc = false
    }
    return sonuc
}

// 2-)

fun sum (num1 : Int, num2: Int):Int {
    var toplam = 0
    if (num2 >= num1) {
        for (i in num1 + 1..num2) {
            toplam += i
        }
    }else if (num1 >= num2){
        for (i in num2..num1-1){
            toplam += i
        }
    }else{
        println("Lütfen geçerli sayı giriniz!")
    }
    return toplam
}

// 3-)

fun numType (a: Int, b: Int):Double{
    var sonuc = 0.0
    val ilkSayi = a.toDouble()
    val ikinciSayi = b.toDouble()
    try {
        if ( b != 0){
            if ( a % 2 != 0){
                sonuc = ilkSayi / ikinciSayi
            }else{
                sonuc = ilkSayi % ikinciSayi
            }
        }else{
            println(" İkinci sayı 0 olursa sonuç sonsuz olur! ")
        }
    }catch (ex:Exception){
        println(ex.message)
    }
    return sonuc
}

// 4-)

fun numLong ( num : Long ):Int {
    var toplam = 0
    for (char in num.toString()){
        if (char.isDigit()){
            toplam += char.toString().toInt()
        }
    }
    return toplam
}

// 5-)

fun bodyIndex ( kg:Double , boy:Double ):Double{
    val sonuc = kg / (boy*boy)
    return (sonuc * 10.0).toInt() / 10.0  // virgülden sonra 1 rakam göstersin
}

// 6-)

fun numReversed ( num: Int ):Int {
    val sayi = num.toString().reversed()
    var sonuc = 0
    try {
        sonuc = sayi.toInt()
    }catch (ex:Exception){
        println(ex.message)
    }
    return sonuc
}

// 7-)

fun isPolindrom(num: Int):Boolean{
    var sonuc = true
    val sayi = num.toString().reversed()
    try {
        val sayiInt = sayi.toInt()
        if (sayiInt != num)
            sonuc = false
    }catch (ex:Exception){
        println(ex)
    }
    return sonuc
}

// 8-)

fun sumMaxMin (num: IntArray):Int{
    var sum = 0
    var numMax = Int.MIN_VALUE
    var numMin = Int.MAX_VALUE
    for (arr in num){
        if (arr > numMax){
            numMax = arr
        }
        if ( arr < numMin ) {
            numMin = arr
        }
        sum = numMax + numMin
    }
    return sum
}

// 9-)

fun arrayIsSayi ( num1 : IntArray, num2: Int ):Boolean{
    var sonuc=true
    for (i in num1){
        if (i != num2){
            sonuc = false
        }else{
            sonuc = true
            break
        }
    }
    return sonuc
}

// 10-)

fun numMax (sayilar : IntArray) : Int {
    var enBuyuk = sayilar[0]
    try {
        for (i in 1..sayilar.size - 1) {
            if (sayilar[i] > enBuyuk) {
                enBuyuk = sayilar[i]
            }
        }
    }catch (ex:Exception){
        ex.stackTrace
        println(ex.message)
    }
    return enBuyuk
}

// 11-)

fun partArr (num1 : IntArray , num2 : IntArray) :Int{
    var ortak = 0

    try {
        for (arr1 in num1){
            for (arr2 in num2){
                if (arr1 == arr2){
                    ortak ++
                    break
                }
            }
        }
    }catch (ex:Exception){
        println(ex)
    }
    return ortak
}

// 12-)

fun sifiraBölme ( num1: Int, num2: Int ){
    try {
        val  sonuc = (num1 / num2)
        if ( num2 != 0 ) {
            println("Bölme sonucu : $sonuc")
        }
    }catch (ex:Exception){
        println( "Sayı 0'a bölünemez sonuc sozsuz olur!" )
    }
}

// 13-)

fun sayiMi (){
    println("Lütfen bir değer girin")
    val girilenDeger = readLine()
    try {
        val deger = girilenDeger?.toInt()
        if (deger != null){
            println("Girdiğiniz değer : $deger , bu bir sayıdır")
        }else{
            println("Girdiğiniz değer bir sayı değildir.")
        }
    }catch (ex:Exception){
        println("Girdiğiniz format yanlış !!")
        println("Hata mesajı : ${ex.message}")
    }
}

// 14-)

fun bolenSifirMi ( bolunen:Int, bolen:Int ):Int{
    try {
        if (bolen != 0){
            return bolunen / bolen
        }else{
            throw Exception("Bölme işlemi sıfıra bölünemez.")
        }
    }catch (ex:Exception){
        println("Hata mesajı: ${ex.message}")
        return 0
    }
}

// 15-)

fun ortalamaHesapla (){
    val scanner = Scanner(System.`in`)
    var num1:Int
    var num2: Int

    try {
        while (true){
            println ("Lütfen 1. değeri giriniz: ")
            if (scanner.hasNextInt()){
                num1 = scanner.nextInt()
                break
            }else{
                println("Lütfen integer değerler giriniz.")
                scanner.next()
            }
        }
        while (true){
            println ("Lütfen 2. değeri giriniz: ")
            if (scanner.hasNextInt()){
                num2 = scanner.nextInt()
                break
            }else{
                println("Lütfen integer değerler giriniz.")
                scanner.next()
            }
        }
        val ortalama = ( num1.toDouble() + num2.toDouble() ) / 2.0
        println("Ortalama : $ortalama")
    }catch (ex:Exception){
        println(ex.message)
    }
}

// 16-)

fun karakterKarsilastir (str1:String, str2:String){

    if (str1 is String && str2 is String) {
        val karakterSayisi1 = str1.length
        val karakterSayisi2 = str2.length
        try {
            if (karakterSayisi1 == karakterSayisi2) {
                println("$karakterSayisi1 = $karakterSayisi2")
            } else {
                throw Exception("Karakter sayısı uyuşmuyor!")
            }
        } catch (ex: Exception) {
            println(ex.message)
        }
    }else{
        println("String ifade giriniz!")
    }
}

// 17-)

fun metinCevir (metin : String){
    var tamsayiyaDonustur = 0
    try {
        for (char in metin){
            tamsayiyaDonustur++
        }
        println("Metin tamsayısı : $tamsayiyaDonustur")
    }catch (ex:Exception){
        println(ex.message)
    }
}

// 18-)

fun ikiSayiCarp (sayi1:Int, sayi2:Int){
    var carp = 0
    try {
        if (sayi1 is Int && sayi2 is Int ){
            carp = sayi1 * sayi2
            println("Sonuç : $carp")
        }else{
            throw Exception ("Lütfen Int değer girin !")
        }
    }catch (ex:Exception){
        println(ex.message)
    }
}

// 19-)

fun kalanSifirMi ( sayi: Int) {
    if (sayi.toString().length == 4) {
        try {
            val kalan = sayi % 2
            if (kalan == 0) {
                println("Kalan 0")
            } else {
                println("Kalan: $kalan")
            }
        } catch (ex: Exception) {
            throw Exception(ex.message)
        }
    } else {
        println("Lütfen 4 basamaklı sayı girin !")
    }
}

// 20-)

fun aritmetikOrtalamaHesapla (){
    val scanner = Scanner(System.`in`)
    var tek=0
    var cift=0
    var tekSayi =0
    var ciftSayi=0
    var ciftSonuc =0
    var tekSonuc = 0

    for (i in 1..5) {
        println(" $i. sayı :  ")
        val sayi= scanner.nextInt()
        if (sayi in 0..20) {
            try {
                var sonuc = sayi % 2
                if (sonuc == 0) {
                    cift++
                    ciftSayi += sayi
                    ciftSonuc = ciftSayi / cift
                } else {
                    tek++
                    tekSayi += sayi
                    tekSonuc = tekSayi / tek
                }
            } catch (ex: Exception) {
                println(ex.message)
            }
        } else {
            println("Geçerli sayı giriniz!")
        }
    }
    println("Çift sayıların aritmetik ortalaması : $ciftSonuc")
    println("Tek sayıların aritmetik ortalaması : $tekSonuc")
}

// 21-)

fun listeBoyutuVeElemanlar (){
    val scanner = Scanner(System.`in`)
    var boyut = 0
    var tekToplam = 0
    var ciftToplam = 0
    try {
        println("Liste boyutunu girin: ")
        boyut = scanner.nextInt()
        if (boyut <= 0) {
            throw Exception("Geçersiz liste boyutu! Pozitif bir tamsayı girin.")
        }
        val liste = mutableListOf<Int>()
        for (i in 0..boyut-1) {
            println("${i + 1}. elemanı girin: ")
            val eleman = scanner.nextInt()
            liste.add(eleman)
        }
        for (i in 0 until boyut) {
            if (i % 2 == 0) {
                ciftToplam += liste[i]
            } else {
                tekToplam += liste[i]
            }
        }
        println("Çift indekslerdeki tamsayıların toplamı: $ciftToplam")
        println("Tek indekslerdeki tamsayıların toplamı: $tekToplam")

    } catch (ex: Exception) {
        println("Geçersiz giriş! Lütfen tamsayıları doğru formatta girin.")
        println(ex.message)
    }
}

// 22-)

fun isMukemmelSayi(sayi: Int): Boolean {
    var toplam = 0
    for (i in 1..sayi-1) {
        try {
            if (sayi % i == 0) {
                toplam += i
            }
        }catch (ex:Exception){ println(ex.message) }
    }
    return toplam == sayi
}

// 23-)

fun karekokHesapla(){
    val scanner = Scanner(System.`in`)

    try {
        println("Bir pozitif sayı girin: ")
        val sayi = scanner.nextDouble()
        if (sayi < 0) {
            throw Exception("Negatif sayı girişi kabul edilmez.")
        }
        val karekok = sayi*sayi
        println("Girdiğiniz sayının karekökü: $karekok")
    } catch (ex: Exception) {
        println("Geçersiz giriş! Lütfen bir sayı girin.")
        println(ex.message)
    } finally {
        scanner.close()
    }
}

// 24-)

fun armstrongSayi (girilenSayi : Int){
    // 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    try {
        if (girilenSayi < 100 || girilenSayi > 999) {
            throw Exception("3 basamaklı bir sayı girmelisiniz.")
        }
        val yuzler = girilenSayi / 100
        val onlar = (girilenSayi / 10) % 10
        val birler = girilenSayi % 10

        val toplam = (yuzler * yuzler * yuzler) + (onlar * onlar * onlar) + (birler * birler * birler)

        if (toplam == girilenSayi) {
            println("$girilenSayi bir Armstrong sayısıdır.")
        } else {
            println("$girilenSayi bir Armstrong sayısı değildir.")
        }
    } catch (e: Exception) {
        println("Hata: ${e.message}")
    }
}

// 25-)

fun faktoriyelHesapla(){
    val scanner = Scanner(System.`in`)

    try {
        print("Pozitif bir tam sayı girin: ")
        val sayi = scanner.nextInt()
        if (sayi < 0) throw Exception("Negatif sayı girişi kabul edilmez.")
        val faktoriyel = (1..sayi).fold(1L, Long::times)
        println("$sayi! = $faktoriyel")
    } catch (ex: Exception) {
        println("Hata: ${ex.message}")
    } finally {
        scanner.close()
    }
}

// 26-)

fun ehliyetAlabilirMi(){
    val scanner = Scanner(System.`in`)
    try {
        print("Yaşınızı girin: ")
        val yas = scanner.nextInt()
        if (yas >= 18) {
            println("Ehliyet alabilirsiniz.")
        } else if (yas >= 0) {
            val beklenenYas = 18 - yas
            if (beklenenYas == 1) {
                println("Maalesef ehliyet alacak yaşta değilsiniz, 1 yıl sonra ehliyet almaya hak kazanabilirsiniz.")
            } else {
                println("Maalesef ehliyet alacak yaşta değilsiniz, $beklenenYas yıl sonra ehliyet almaya hak kazanabilirsiniz.")
            }
        } else {
            throw Exception("Geçersiz yaş girişi! Pozitif bir sayı giriniz.")
        }
    } catch (ex: Exception) {
        println("Geçersiz giriş! Lütfen bir yaş girin.")
        println(ex.message)
    }
}

// 27-)

fun soruKac(){
    val maxSayi = 50
    var soruNo : Int
    do {
        println("Kaçıncı soruyu yazdığınızı giriniz: ")
        val girilenSayi = readLine()
        try {
            soruNo = girilenSayi?.toInt() ?: throw Exception("Geçersiz birsayı ya da karakter girdiniz!")
            if (soruNo < 1 || soruNo >50){
                throw Exception("Soru numarası 1 ile $maxSayi arasında olmalıdır!")
            }
            println("Girilen soru numarası : $soruNo")
        }catch (ex:Exception){
            println("Hatalı Giriş! " + ex.message)
            soruNo = -1
        }
    }while (soruNo == -1)
}

// 28-)

fun universiteyeYerleşirMi(){
    val scanner = Scanner(System.`in`)
    try {
        print("LYS puanınızı girin: ")
        val puanStr = scanner.nextLine()
        val puan = puanStr.toIntOrNull()

        when {
            puan == null -> throw Exception("Geçersiz giriş! Puan pozitif bir sayı olmalı!")
            puan in 400..430 -> println("Mühendislik Fakültesi'ne yerleşebilirsiniz.")
            else -> println("Üzülme, Vazgeçme! \uD83D\uDE00 ")
        }
    } catch (ex: Exception) {
        println(ex.message)
    } finally {
        println("İşlem Tamamlandı")
    }
}

// 29-)

    fun quiz (){
    val scanner = Scanner(System.`in`)
    val dogruCevap = "1981"
    println("İlk kişisel bilgisayar hangi yıl piyasaya sürüldü?")
    val cevap = scanner.nextLine()
    if (cevap.equals(dogruCevap, ignoreCase = true)) {
        println("Tebrikler, doğru cevap!")
    } else {
        println("Üzgünüz, yanlış cevap! Doğru cevap: $dogruCevap")
    }
    }















