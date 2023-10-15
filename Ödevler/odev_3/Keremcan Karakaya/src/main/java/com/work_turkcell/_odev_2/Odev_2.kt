package com.work_turkcell._odev_2

import kotlin.math.sqrt
import java.util.InputMismatchException
import java.util.Scanner

fun main(args: Array<String>) {
  // println(isPrime(41))
  // println(ikiSayi(9,12))
  // println(bolVeyaMod(10,3))
  // println(longToplam(2343241))
  // println(vucutKitleEndeks(171,62))
  // println(tersten(4359))
  // println(palindrome(121))
  // println(enBuyukEnKucuk(intArrayOf(5,4,2,7,12,21,9)))
  // println(dizikarsilastir(intArrayOf(3,4,6,7,8,2,43,21),8))
  // enBuyuk()
  // println(ortakDiziElemanlari(intArrayOf(), intArrayOf()))
  // soru12()
  // soru13()
  // println(soru14(15,0))
  // soru15()
  // soru16()
  // soru17()
  // soru18()
  // soru19()
  // soru20()
  // soru21()
  // soru22()
  // soru23()
  // soru24()
  // soru25()
  // soru26()
  // soru27()
  // soru28()
  // soru29()
  // soru30()
}

// 1
fun isPrime(sayi: Int): Boolean {
    if (sayi <= 1 ) {
        return false
    }
    if (sayi >= 2) {
        for (i in 2 until sayi) {
            if (sayi % i == 0) {
                return false
                break
            }
        }
    }
    return true
}

// 2
fun ikiSayi(baslangic: Int, bitis: Int): Int {
    if (baslangic >= bitis) {
        return 0
    }
    var toplam = 0
    for (i in baslangic + 1 until bitis) {
        toplam = toplam + i
    }
    return toplam
}

// 3
fun bolVeyaMod(sayi1: Int, sayi2: Int): Double {
    var sonuc: Double =
        if (sayi1 % 2 == 1) {
            sayi1.toDouble() / sayi2.toDouble()
        } else {
            (sayi1 % sayi2).toDouble()
        }
    return sonuc
}

//4
fun longToplam(a: Long): Int {
    var toplam = 0
    val aString = a.toString()
    for (rakam in aString) {
        if (rakam.isDigit()) {
            toplam += rakam.toString().toInt()
        }
    }
    return toplam
}

//5
fun vucutKitleEndeks(kg: Double, boy: Double): Double{
    if (kg <= 0.0 || boy <= 0.0) {
        println("Kg ve boy pozitif olmalıdır.")
        return -1.0
    }
    return kg / (boy * boy)
}

//6
fun tersten(sayi: Int): Int{
    return sayi.toString().reversed().toInt()
}

//7
fun palindrome(sayi: Int): Boolean{
    val sayiReversed = sayi.toString().reversed().toInt()
    return sayi == sayiReversed
}

//8
fun enBuyukEnKucuk(dizi: IntArray): Int{
    var enkucuk = dizi[0]
    var enbuyuk = dizi[0]
    for (sayi in dizi) {
        if (sayi < enkucuk) {
            enkucuk = sayi
        }
        if (sayi > enbuyuk) {
            enbuyuk = sayi
        }
    }
    return enkucuk + enbuyuk
}

//9
fun dizikarsilastir(dizi: IntArray, sayi: Int): Boolean{
    for (n in dizi) {
        if (n == sayi) {
            return true
        }
    }
    return false
}

//10
fun enBuyuk(): Int{
    println("4 sayı giriniz")
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val enbuyuk = maxOf(a, b, c, d)
    println("En büyük sayı: $enbuyuk")
    return enbuyuk
}

//11
fun ortakDiziElemanlari(dizi1: IntArray, dizi2: IntArray): Int{
    println("İlk dizinin elemanlarını girin (örneğin: 1 2 3):")
    val input1 = readLine() ?: ""
    val dizi1 = input1.split(" ").map { it.toInt() }.toIntArray()

    println("İkinci dizinin elemanlarını girin (örneğin: 2 3 4):")
    val input2 = readLine() ?: ""
    val dizi2 = input2.split(" ").map { it.toInt() }.toIntArray()
    val set1 = dizi1.toSet()
    val set2 = dizi2.toSet()
    val commonElements = set1.intersect(set2)

    return commonElements.size

    val ortakElemanlar = ortakDiziElemanlari(dizi1, dizi2)
    println("Ortak eleman sayısı: $ortakElemanlar")
}

//12
fun soru12(){
    val sayi = 10
    val payda = 0
    try {
        val sonuc = sayi / payda
        println("Sonuç: $sonuc")
    } catch (e: ArithmeticException) {
        println("Hata: Sıfıra bölme hatası yakalandı.")
    }
}

//13
fun soru13(){
    println("Bir sayı giriniz: ")
    val a = readLine()!!.toInt()
    try {
        val a = readLine()!!.toInt()
        println("Girilen sayı: $a")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girilmedi.")
    }
}

//14
fun soru14(bolen: Int, bolunen: Int): String{
    try {
        if (bolunen == 0) {
            throw IllegalArgumentException("Bölme işlemi sıfıra bölünemez.")
        }
        val sonuc = bolen / bolunen
        return "Sonuç: $sonuc"
    } catch (e: IllegalArgumentException) {
        return e.message ?: "Bilinmeyen bir hata oluştu."
    }
}

//15
fun soru15(){
    try {
        println("İki tam sayı girin:")
        val sayilar = IntArray(2)
        sayilar[0] = readLine()?.toInt() ?: 0
        sayilar[1] = readLine()?.toInt() ?: 0
        println("Ortalama: ${sayilar.average()}")
    } catch (e: NumberFormatException) {
        println("Hata: Lütfen sadece tam sayı değerleri giriniz.")
        e.printStackTrace()
    }
}

//16
fun soru16(){
    println("İki string ifade giriniz")
    val a = readLine()
    val b = readLine()
    try {
        if (a != null && b != null) {
            if (a.length != b.length) {
                throw IllegalArgumentException("Karakter sayıları eşit değil")
            }
        }
        println("Karakter sayıları eşit.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }
}

//17
fun soru17(){
    println("Bir tamsayı girin:")
    val metin = readLine() ?: ""
    try {
        val tamsayi = metin.toInt()
        println("Girilen tamsayı: $tamsayi")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir tamsayı girilmedi.")
    }
}

//18
fun soru18(){
    var sayi1: Int? = null
    var sayi2: Int? = null
    while (sayi1 == null) {
        try {
            print("Birinci sayıyı girin: ")
            val sayi1 = readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir tam sayı girilmedi.")
        }
    }
    while (sayi2 == null) {
        try {
            print("İkinci sayıyı girin: ")
            val sayi2 = readLine()!!.toInt()
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir tam sayı girilmedi.")
        }
    }
    val carpim = sayi1 * sayi2
    println("Çarpım sonucu: $carpim")
}

//19
fun soru19() {
    var sayi: Int? = null
    while (sayi == null || sayi < 1000 || sayi > 9999) {
        try {
            print("Dört basamaklı bir sayı girin: ")
            sayi = readLine()?.toInt()

            if (sayi == null || sayi < 1000 || sayi > 9999) {
                println("Hata: Geçerli bir dört basamaklı sayı giriniz.")
            }
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir sayı girilmedi.")
        }
    }
    try {
        val kalan = sayi % 2
        if (kalan == 0) {
            println("Girilen sayının 2 ile bölümünden kalan sıfırdır.")
        } else {
            println("Girilen sayının 2 ile bölümünden kalan sıfır değildir.")
        }
    } catch (e: ArithmeticException) {
        println("Hata: Bölme işlemi sıfıra bölünemez.")
    }
}

//20
fun soru20(){
    val sayilar = mutableListOf<Int>()
    var toplamTek = 0
    var toplamCift = 0
    for (i in 1..5) {
        var sayi: Int? = null
        while (sayi == null || sayi < 0 || sayi > 20) {
            try {
                print("0 ile 20 arasında bir sayı girin ($i. sayı): ")
                sayi = readLine()!!.toInt()

                if (sayi == null || sayi < 0 || sayi > 20) {
                    println("Hata: Geçerli bir sayı girilmedi veya sınırlar dışında bir sayı girdiniz.")
                }
            } catch (e: NumberFormatException) {
                println("Hata: Geçerli bir sayı girilmedi.")
            }
        }
        sayilar.add(sayi)
    }
    for (sayi in sayilar) {
        if (sayi % 2 == 0) {
            toplamCift += sayi
        } else {
            toplamTek += sayi
        }
    }
    val ortalamaTek = if (sayilar.count { it % 2 == 1 } > 0) {
        toplamTek.toDouble() / sayilar.count { it % 2 == 1 }
    } else {
        0.0
    }
    val ortalamaCift = if (sayilar.count { it % 2 == 0 } > 0) {
        toplamCift.toDouble() / sayilar.count { it % 2 == 0 }
    } else {
        0.0
    }
    println("Seçilen tek sayıların aritmetik ortalaması: $ortalamaTek")
    println("Seçilen çift sayıların aritmetik ortalaması: $ortalamaCift")
}

//21
fun soru21(){
    val sc = Scanner(System.`in`)
    val liste = mutableListOf<Int>()
    try {
        println("Listenin boyutunu giriniz")
        var eleman = sc.nextInt()
        for (i in 0..eleman-1){
            println("Lütfen $i. indexi giriniz: ")
            var eleman = sc.nextInt()
            liste.add(eleman)
        }
        val ciftIndex = liste.filter { liste.indexOf(it)%2 == 0 }
        val tekIndex = liste.filter { liste.indexOf(it)%2 != 0 }

        println("""
            Girdiğiniz listedeki;
            Çift indexli elemanların toplamı: ${ciftIndex.sum()}
            Tek indexli elemanların toplamı: ${tekIndex.sum()}
        """.trimIndent())
    }catch (ex: InputMismatchException){
        println("Geçersiz giriş yapıldı.Lütfen tamsayı değerler giriniz.")
    }
}

//22
fun soru22(){
    try {
        println("Bir pozitif sayı girin: ")
        val mukemmelSayi = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
        if (mukemmelSayi < 0) {
            throw IllegalArgumentException("Negatif sayı girişi yapılamaz!")
        }
        var bolenToplam =
            (1 until mukemmelSayi)
                .filter { mukemmelSayi % it == 0 }
                .sum()
        val durum = if (bolenToplam == mukemmelSayi) "mükemmel sayıdır" else "mükemmel sayı değil"
        println("$mukemmelSayi sayısı $durum")
    } catch (e: NumberFormatException) {
        println("Hata: Geçersiz bir sayı girdiniz.")
    } catch (e: IllegalArgumentException) {
        println("Hata: Negatif sayı girişi yapılamaz.")
    }
}

//23
fun soru23(){
    try {
        print("Karekökünü hesaplamak istediğiniz pozitif bir sayı girin: ")
        val userInput = readLine()
        val sayi = userInput?.toDoubleOrNull()
        if (sayi == null || sayi < 0) {
            throw IllegalArgumentException("Geçerli bir pozitif sayı girmelisiniz.")
        }
        val karekok = sqrt(sayi)
        println("Girdiğiniz sayının karekökü: $karekok")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

//24
fun soru24(){
    try {
        print("3 basamaklı bir sayı girin: ")
        val userInput = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
        if (userInput !in 100..999) {
            throw IllegalArgumentException("Lütfen 3 basamaklı bir sayı girin.")
        }
        val yuzlerBasamagi = userInput / 100
        val onlarBasamagi = (userInput % 100) / 10
        val birlerBasamagi = userInput % 10

        val armstrong = yuzlerBasamagi * yuzlerBasamagi * yuzlerBasamagi +
                onlarBasamagi * onlarBasamagi * onlarBasamagi +
                birlerBasamagi * birlerBasamagi * birlerBasamagi

        if (userInput == armstrong) {
            println("$userInput bir Armstrong sayısıdır.")
        } else {
            println("$userInput bir Armstrong sayısı değildir.")
        }
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

//25
fun soru25(){
    try {
        print("Pozitif bir tam sayı girin: ")
        val userInput = readLine()?.toInt() ?: throw NumberFormatException("Geçersiz giriş!")
        if (userInput <= 0) {
            throw IllegalArgumentException("Pozitif bir tam sayı girin.")
        }
        var faktoriyel = 1
        for (i in 1..userInput) {
            faktoriyel *= i
        }
        println("$userInput! = $faktoriyel")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}

//26
fun soru26(){
    try {
        print("Yaşınızı girin: ")
        val yas = readLine()!!.toInt()
        if (yas >= 18) {
            println("Ehliyet almaya hak kazandınız.")
        } else if (yas >= 0 && yas < 18) {
            val kalanYil = 18 - yas
            println("Maalesef ehliyet alacak yaşta değilsiniz, $kalanYil yıl sonra ehliyet almaya hak kazanabilirsiniz.")
        } else {
            println("Hata: Geçerli bir yaş değeri girmediniz.")
        }
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    }
}

//27
fun soru27(){
        var soruNumarasi: Int? = null
        while (soruNumarasi !in 1..50) {
            print("Kaçıncı soruyu yazdığınızı (1-50 arası) girin: ")
            try {
                soruNumarasi = readLine()?.toIntOrNull()
            }
            catch (e: NumberFormatException) {
            }
            if (soruNumarasi !in 1..50) {
                println("Hata: Geçerli bir sayı (1-50 arası) girmelisiniz.")
            }
        }
        println("Girdiğiniz soru numarası: $soruNumarasi")
    }

//28
fun soru28(){
    try {
        print("Lys puanınızı girin: ")
        val puan = readLine()

        if (puan.isNullOrEmpty()) {
            throw IllegalArgumentException("Geçerli bir puan girmelisiniz.")
        }
        val lysPuan = puan.toInt()
        val mesaj = if (lysPuan in 400..430) {
            "Mühendislik Fakültesi'ne yerleşebilirsiniz."
        } else {
            "Üzülme, Vazgeçme! 😊"
        }
        println(mesaj)
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    } finally {
        println("İşlem Tamamlandı.")
    }
}

//29
fun soru29(){
    val soru = "Galatasaray hangi ülkenin takımıdır?"
    val dogruCevap = "Türkiye"
    println(soru)
    print("Cevabınız: ")
    try {
        val cevap = readLine() ?: throw NullPointerException("Cevap boş olamaz")
        if (cevap == dogruCevap) {
            println("Tebrikler! Doğru cevap.")
        } else {
            println("Üzgünüz, yanlış cevap.")
        }
    } catch (e: NullPointerException) {
        println("Hata: Cevap girilmedi.")
    }
}

//30
fun soru30(){
        try {
            println("Kullanıcı Kaydı")
            print("Adınız: ")
            val ad = readLine() ?: throw IllegalArgumentException("Hata: Ad boş olamaz")
            print("Soyadınız: ")
            val soyad = readLine() ?: throw IllegalArgumentException("Hata: Soyad boş olamaz")
            print("Yaşınız: ")
            val yas = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("Hata: Geçerli bir yaş girin")
            print("E-posta adresiniz: ")
            val email = readLine() ?: throw IllegalArgumentException("Hata: E-posta boş olamaz")
            if (!isValidEmail(email)) {
                throw IllegalArgumentException("Hata: Geçerli bir e-posta adresi girin")
            }
            if (yas >= 18) {
                val kullaniciAdi = "${ad.toLowerCase()}${soyad.toLowerCase()}"
                println("\nKayıt Tamamlandı:")
                println("Kullanıcı Adı: $kullaniciAdi")
                println("Ad Soyad: $ad $soyad")
                println("Yaş: $yas")
                println("E-posta: $email")
            } else {
                println("Üzgünüz, yaşınız 18 ve üzeri olmalıdır. Kayıt kabul edilmedi.")
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    fun isValidEmail(email: String): Boolean {
        return email.matches(Regex("^[A-Za-z0-9+_.-]+@(.+)\$"))
    }
