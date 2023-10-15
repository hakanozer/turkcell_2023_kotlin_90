package com.works.homeworks._homework

import java.util.Scanner

fun main(args: Array<String>) {


    val scanner = Scanner(System.`in`)

    // 1.soru

    println("1: Sizden bir üçgen oluşturmanız isteniyor")
    println("Lütfen üçgenin birinci kenarını girin!: ")
    val kenar1 = scanner.nextDouble()

    println("Lütfen üçgenin ikinci kenarını girin!: ")
    val kenar2 = scanner.nextDouble()

    println("Lütfen üçgenin üçüncü kenarını girin!: ")
    val kenar3 = scanner.nextDouble()

    val sonuc =
        if (kenar1 + kenar2 > kenar3 && kenar1 + kenar3 > kenar2 && kenar2 + kenar3 > kenar1) {
            "Sonuç: Bu kenarlarla bir üçgen yapılabilir."
        } else {
            "Sonuç: Bu kenarlarla bir üçgen yapılamaz."
        }

    println(sonuc)

    // 2. soru

    while (true) {
        println("2: Bu bir sıcaklık dönüşüm hesabıdır. Lütfen Menüden dönüştürmek istediğiniz birimi seçiniz!")
        println("Menu:")
        println("1 - Fahrenheit'dan Celsius'a dönüşüm")
        println("2 - Celsius'tan Fahrenheit'a dönüşüm")
        print("Seçim: ")

        val secim = scanner.nextInt()

        when (secim) {
            1 -> {
                println("Fahrenheit değerini girin: ")
                val fahrenheit = scanner.nextDouble()
                val celsius = (fahrenheit - 32) * 5 / 9
                println("$fahrenheit F = $celsius C")
                break
            }

            2 -> {
                println("Celsius değerini girin: ")
                val celsius = scanner.nextDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                println("$celsius C = $fahrenheit F")
                break
            }

            else -> {
                println("Hatalı seçim! Lütfen 1 veya 2 seçeneğini girin.")
            }
        }
    }


    // 3. soru

    println("3: Sizden aldığımız iki sayıyı karşılaştırmak istiyoruz!")
    println("Lütfen ilk sayıyı giriniz!")
    val sayi1 = scanner.nextDouble()

    println("Lütfen ikinci sayıyı giriniz!")
    val sayi2 = scanner.nextDouble()

    if (sayi1 > sayi2) {
        println("$sayi1 büyük, $sayi2 küçük")
    } else if (sayi2 > sayi1) {
        println("$sayi2 büyük, $sayi1 küçük")
    } else {
        println("Sayılar eşittir!")
    }



    // 4. soru

    println("4: 1'den N'e kadar olan sayıları toplamak için lütfen bir N sayısı belirleyin!")

    val n = scanner.nextInt()

    var toplam1 = 0

    for (i in 1..n) {
            toplam1 += i
    }

    println("1'den $n'e kadar olan sayıların toplamı: $toplam1")

    // 5. soru

    var sayi3: Int
    var devam = true

    while (devam) {
        print("5: Rakamları toplamını hesaplamak için 3 haneli bir sayı girin: ")
        sayi3 = readLine()?.toIntOrNull()?: 0

        if (sayi3 in 100..999) {
            val birlerBasamagi = sayi3 % 10
            val onlarBasamagi = (sayi3 / 10) % 10
            val yuzlerBasamagi = sayi3 / 100

            val toplam = birlerBasamagi + onlarBasamagi + yuzlerBasamagi

            println("$yuzlerBasamagi + $onlarBasamagi + $birlerBasamagi = $toplam")
            devam = false
        } else {
            println("Hatalı giriş! Lütfen 3 haneli bir sayı girin.")
        }
    }


    // 6. soru

    var tersSayi = 0

    while (true) {
        println("6: Rakamlarının tersten yazılması için 3 haneli bir sayı giriniz!")
        val sayiy = scanner.nextInt()

        if (sayiy in 100..999) {
            val birler = sayiy % 10
            val onlar = (sayiy / 10) % 10
            val yuzler = sayiy / 100

            tersSayi = birler * 100 + onlar * 10 + yuzler
            break
        } else {
            println("Hatalı giriş! Lütfen 3 haneli bir sayı girin.")
        }
    }

    println("Tersten yazılmış hali: $tersSayi")


    // 7. soru

    println("7: X tane pozitif ve/veya negatif sayı girmeniz isteniyor.")
    println("Kaç tane sayı gireceksiniz: ")
    val n1 = scanner.nextInt()

    if (n1 <= 0) {
        println("Geçerli bir sayı girmelisiniz.")
        return
    }

    var pozitifSayiSayisi = 0
    var negatifSayiSayisi = 0
    var enBuyuk = Int.MIN_VALUE
    var enKucuk = Int.MAX_VALUE
    var toplam3 = 0
    var ciftSayiSayisi = 0
    var tekSayiSayisi = 0

    for (i in 1..n1) {
        println("$i. sayıyı girin: ")
        val sayiz = scanner.nextInt()

        if (sayiz > 0) {
            pozitifSayiSayisi++
        } else if (sayiz < 0) {
            negatifSayiSayisi++
        }

        if (sayiz > enBuyuk) {
            enBuyuk = sayiz
        }

        if (sayiz < enKucuk) {
            enKucuk = sayiz
        }

        if (sayiz % 2 == 0) {
            ciftSayiSayisi++
        } else {
            tekSayiSayisi++
        }

        toplam3 += sayiz
    }

    val ortalama = if (n1 > 0) toplam3.toDouble() / n1 else 0.0

    println("""

    Girilen $n1 sayıdan:
    $pozitifSayiSayisi Tanesi Pozitif
    $negatifSayiSayisi Tanesi Negatif
    En büyüğü: $enBuyuk
    En küçüğü: $enKucuk
    $ciftSayiSayisi Tanesi Çift
    $tekSayiSayisi Tanesi Tek
    Toplam: $toplam3
    Ortalama: $ortalama""")



}