package com.works.kotlinodev

import java.util.Scanner

fun main(args: Array<String>) {

    /// Soru 1
    val scanner = Scanner(System.`in`)

    println("Üçgen oluşturmak için ilk sayı değerini giriniz  :  ")
    val kenar1 = scanner.nextDouble()

    println("Üçgen oluşturmak için ikinci sayı değerini giriniz  :  ")
    val kenar2 = scanner.nextDouble()

    println("Üçgen oluşturmak için üçüncü sayı değerini giriniz  :  ")
    val kenar3 = scanner.nextDouble()

    val ücgen = if (kenar1 + kenar2 >= kenar3 && kenar1 + kenar3 >= kenar2 && kenar2 + kenar3 >= kenar1){
        "Sonuç : Bu kenarla üçgen yapılabilir."
    }
    else{
        "Sonuç : Bu kenarla üçgen yapılamaz."
    }

    println(ücgen)

    /// Soru 2

    while (true) {

        println(" Menü ")
        println("1 - F -> C Dönüşümü")
        println("2 - C -> F Dönüşümü")
        println("Dönüştürmek istediğiniz birimi seçin  :  ")
        val secim = scanner.nextInt()

        when (secim){

            1 -> {
                println("Fahrenheit değerini giriniz  :  ")
                val fah= scanner.nextDouble()
                val cel = (fah-32)*5/9
                println("Fahrenheit : $fah , Celsius : $cel")
                break
            }

            2 -> {
                println("Celsius değerini giriniz  :  ")
                val cel = scanner.nextDouble()
                val fah = (cel*9/5)+32
                println("Celsius : $cel , Fahrenheit : $fah")
                break
            }

            else -> {
                println("Girdiğiniz seçim hatalıdır")
                break
            }
        }
    }

    /// 3. Soru

    println("Lütfen ilk sayınızı girin  :  ")
    var ilksayi = scanner.nextDouble()

    println("Lütfen ikinci sayınızı girin  :  ")
    var ikincisayi = scanner.nextDouble()

    if (ilksayi > ikincisayi){
        println("Büyük Sayı : $ilksayi , Küçük Sayı : $ikincisayi")
    }

    else if (ikincisayi > ilksayi){
        println("Büyük Sayı : $ikincisayi , Küçük Sayı : $ilksayi")
    }

    else {
        println("Sayılarınız birbine eşittir.")
    }

    /// 4. Soru

    println("Lütfen sayı değerinizi girin  :  ")
    var deger = scanner.nextInt()

    var toplam = 0
    for (i in 1..deger){
        toplam+=i

    }
    println("1'den sayınıza kadar olan sayıların toplamı : $toplam")

    /// 5. Soru

    var sum = 0
    while (true){
        println("3 haneli bir sayı giriniz  :  ")
        val sayi3 = scanner.nextInt()

        if (sayi3 in 100..999){
            val birlerb = sayi3 % 10
            val onlarb = (sayi3 / 10 ) % 10
            val yüzlerb = sayi3 / 100

            sum = birlerb + onlarb + yüzlerb
            println("Sayınınız rakamları toplamı : $sum")
            break
        }
        else {
            println("3 haneli sayı girmediğiniz için hatalı giriş yaptınız.")
            break
        }
    }

    /// 6. Soru

    println("3 haneli sayınızı girin  :  ")
    val sayiters = scanner.nextInt()

    val birlerters = sayiters % 10
    val onlarters = (sayiters / 10 ) %10
    val yüzlerters = sayiters /100

    val terssayi = birlerters*100 + onlarters*10 + yüzlerters
    println("Sayınızın tersten yazılmış hali : $terssayi")

    /// 7. Soru

    println("Pozitif ve negatif sayılarınız girilecektir.")
    println("Gireceğiniz sayı miktarını belirtiniz  :  ")
    val sayımiktar = scanner.nextInt()

    if (sayımiktar <= 0){
        println("İşleminiz geçersizdir tekrar yapınız.")
        return
    }

    var pozitifsayi = 0
    var negatifsayi = 0
    var enbüyüksayi = 0
    var enkücüksayi = 0
    var toplamları = 0
    var ciftsayimiktari = 0
    var teksayimiktari = 0
    var ortalamalari = 0

    for (i in 1..sayımiktar){
        println("Sayınızı girin : $i")
        val sayi7 = scanner.nextInt()

        if (sayi7 > 0){
            pozitifsayi+=sayi7
        }
        else if (sayi7 < 0){
            negatifsayi+=sayi7
        }
        if (sayi7 > enbüyüksayi){
            enbüyüksayi=sayi7
        }
        if (sayi7 < enkücüksayi){
            enkücüksayi=sayi7
        }
        if (sayi7%2==0){
            ciftsayimiktari++
        }
        else{
            teksayimiktari++
        }
        toplamları += sayi7
        ortalamalari = toplamları/sayi7
    }
    println("Pozitif Sayı Miktarı : $pozitifsayi")
    println("Negatif Sayı Miktarı : $negatifsayi")
    println("En Büyük Sayı : $enbüyüksayi")
    println("En Küçük Sayı : $enkücüksayi")
    println("Çift Sayı Miktarı : $ciftsayimiktari")
    println("Tek Sayı Miktarı : $teksayimiktari")
    println("Toplamları : $toplamları")
    println("Ortalamaları : $ortalamalari")

}