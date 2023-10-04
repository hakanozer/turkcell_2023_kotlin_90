@file:Suppress("UNREACHABLE_CODE")

package com.works.homeworks._homework


import kotlin.math.sqrt

fun main() {


    // 1.Soru

    fun soru1(n: Int): Boolean {
        if (n <= 1) {
            return false
        }

        if (n <= 3) {
            return true
        }

        if (n % 2 == 0 || n % 3 == 0) {
            return false
        }

        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false
            }
            i += 6
        }

        return true
    }

    val sayi = 11
    val sonuc = soru1 (sayi)

    if (sonuc) {
        println("1.Soru: $sayi bir asal sayıdır.")
    } else {
        println("1.Soru: $sayi bir asal sayı değildir.")
    }



    // 2. Soru

    fun soru2(ilkSayi: Int, ikinciSayi: Int): Int {
        var toplam = 0

        for (i in (ilkSayi + 1)..ikinciSayi) {
            toplam += i
        }

        return toplam
    }


    val sayi1 = 3
    val sayi2 = 7

    val sonuc2 = soru2(sayi1, sayi2)
    println("2.Soru: $sayi1 ile $sayi2 arasındaki sayıların toplamı (ilk sayı hariç): $sonuc2")



    // 3. Soru

    fun soru3(a: Int, b: Int): Double {
        return if (a % 2 == 1) {
            a.toDouble() / b
        } else {
            (a % b).toDouble()
        }
    }

        val a = 7
        val b = 3

        val sonuc3 = soru3(a, b)
        println("3.Soru: $sonuc3")



    // 4. Soru

    fun soru4(sayi: Long): Long {
        var toplam1: Long = 0
        var kalan: Long = sayi

        while (kalan != 0L) {
            val rakam: Long = kalan % 10
            toplam1 += rakam
            kalan /= 10
        }

        return toplam1
    }

        val sayi5 = 12345678L
        val sonuc4 = soru4(sayi5)
        println("4.Soru: Sayının rakamları toplamı: $sonuc4")



    // 5. Soru

    fun soru5(kg: Double, boy: Double): Double {
        val bmi = kg / (boy * boy)
        return bmi
    }

        val kilo = 46.0
        val boy = 1.66

        val bmi = soru5(kilo, boy)
        println("5.Soru: Vücut Kitle İndeksi (BMI): $bmi")



    // 6. Soru

    fun soru6(sayi: Int): Int {
        var ters = 0
        var kalan = sayi

        while (kalan != 0) {
            val rakam = kalan % 10
            ters = ters * 10 + rakam
            kalan /= 10
        }

        return ters
    }

        val sayi6 = 1923
        val ters = soru6(sayi6)
        println("6.Soru: Sayının tersi: $ters")



    // 7. Soru

    fun soru7(sayi: Int): Boolean {
        val sayiStr = sayi.toString()
        val tersStr = sayiStr.reversed()

        return sayiStr == tersStr
    }

        val sayi7 = 1881
        val sayi8 = 1357

        val sonuc5 = soru7(sayi7)
        val sonuc6 = soru7(sayi8)

        println("7.Soru: $sayi7 bir palindrome sayı mı? $sonuc5")
        println("7.Soru: $sayi8 bir palindrome sayı mı? $sonuc6")



    // 8. Soru

    fun soru8(dizi: IntArray): Int {
        if (dizi.isEmpty()) {
            throw IllegalArgumentException("Dizi boş olamaz.")
        }

        val enKucuk = dizi.minOrNull() ?: 0
        val enBuyuk = dizi.maxOrNull() ?: 0

        return enKucuk + enBuyuk
    }

        val dizi = intArrayOf(1, 8, 3, 11, 5)

        val sonuc7 = soru8(dizi)
        println("8.Soru: En küçük ve en büyük sayıların toplamı: $sonuc7")



    // 9. Soru

    fun soru9(dizi: IntArray, arananSayi: Int): Boolean {
        for (sayif in dizi) {
            if (sayif == arananSayi) {
                return true
            }
        }
        return false
    }

    val dizi2 = intArrayOf(3, 8, 10, 9, 14)
    val arananSayi = 8

    val sonuc8 = soru9(dizi2, arananSayi)
    if (sonuc8) {
        println("9.Soru: $arananSayi dizi içinde bulunuyor.")
    } else {
        println("9.Soru: $arananSayi dizi içinde bulunmuyor.")
    }



    // 10. Soru

    fun soru10(vararg sayilar: Int): Int {
        var enBuyuk = Int.MIN_VALUE

        for (sayid in sayilar) {
            if (sayid > enBuyuk) {
                enBuyuk = sayid
            }
        }

        return enBuyuk
    }

        val sayi9 = 4
        val sayi10 = 8
        val sayi11 = 21
        val sayi12 = 13

        val enBuyuk = soru10(sayi9, sayi10, sayi11, sayi12)
        println("10.Soru: Dizideki en büyük sayı $enBuyuk")



    // 11. Soru

    fun soru11(dizi1: IntArray, dizi2: IntArray): Int {
        val set1 = dizi1.toSet()
        val set2 = dizi2.toSet()

        val ortakElemanlar = set1.intersect(set2)

        return ortakElemanlar.size
    }
        val dizi3 = intArrayOf(1, 3, 5, 9, 13, 17)
        val dizi4 = intArrayOf(2, 3, 6, 8, 13, 15)

        val ortakSayi = soru11(dizi3, dizi4)
        println("11.Soru: Ortak elemanların sayısı: $ortakSayi")



    // 12. Soru

        val pay = 18
        val payda = 0

        try {
            val sonuc9 = pay / payda
            println("12.Soru: $sonuc9")
        } catch (e: ArithmeticException) {
            println("12.Soru: Hata: Sayı sıfıra bölünemez!")
        }



    // 13. Soru

    try {
        println("13.Soru:")
        println("Bir sayı giriniz: ")
        val soru13 = readLine()

        if (soru13 != null) {
            val sayi13 = soru13.toDoubleOrNull()

            if (sayi13 != null) {
                println("Girilen sayı: $sayi13")
            } else {
                println("Geçersiz giriş (Bir sayı girilmelidir!).")
            }
        } else {
            println("Geçersiz giriş (Null değer).")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz giriş (Bir sayı girilmelidir!).")
    }



    // 14. Soru

    println("14.Soru:")
    fun soru14(sayi: Int, bolen: Int): Int {
        try {
            if (bolen == 0) {
                throw ArithmeticException("Bölme işlemi sıfıra bölünemez.")
            }
            return sayi / bolen
        } catch (e: ArithmeticException) {
            println("14.Soru: Hata!( ${e.message} )")
            return 0
        }
    }


    println("Bölünecek sayıyı giriniz: ")
    val sayi14 = readLine()!!.toInt()
    println("Bölen sayıyı giriniz: ")
    val bolen = readLine()!!.toInt()

    val sonuc14 = soru14(sayi14, bolen)
    println("Sonuç: $sonuc14")



    // 15. Soru


    try {
        println("15.Soru:")
        print("Birinci sayıyı giriniz: ")
        val sayi15 = readLine()!!.toInt()

        print("İkinci sayıyı giriniz: ")
        val sayi16 = readLine()!!.toInt()

        val ortalama = (sayi15 + sayi16) / 2.0

        println("Girilen sayıların ortalaması: $ortalama")
    } catch (e: NumberFormatException) {
        println("Hata,lütfen integer değerler giriniz!")
        main()
    }



    // 16. Soru

    println("16.Soru")
    try {
        print("Birinci metni girin: ")
        val metin1 = readLine()!!

        print("İkinci metni girin: ")
        val metin2 = readLine()!!

        if (metin1.length != metin2.length) {
            throw IllegalArgumentException("Karakter sayıları uyuşmuyor")
        }

        println("Karakter sayıları uyuşuyor.")
    } catch (e: IllegalArgumentException) {
        println("Hata: ${e.message}")
    }



    // 17. Soru

    println("17.Soru:")
    print("Metin giriniz: ")
    val metin3 = readLine()

    try {
        if (metin3 != null) {
            val harfSayisi = metin3.count { it.isLetter() }
            println("Girilen metin $harfSayisi harf içeriyor.")
        } else {
            println("Hata: Null değer girdiniz.")
        }
    } catch (e: Exception) {
        println("Hata: Metin analizi sırasında bir hata oluştu.")
    }



    // 18. Soru

    println("18.Soru:")
    try {
        print("Birinci sayıyı giriniz: ")
        val sayi18 = readLine()!!.toInt()

        print("İkinci sayıyı giriniz: ")
        val sayi19 = readLine()!!.toInt()

        val carpim = sayi18 * sayi19
        println("Çarpım: $carpim")
    } catch (e: NumberFormatException) {
        println("Hata: Lütfen geçerli bir tamsayı giriniz!")
    }



    // 19. Soru

    println("19.Soru")
    try {
        print("Dört basamaklı bir sayı giriniz: ")
        val girilenSayi = readLine()!!.toInt()

        if (girilenSayi in 1000..9999) {
            val kalan = girilenSayi % 2
            if (kalan == 0) {
                println("Girilen sayının 2 ile bölümünden kalan sıfır.")
            } else {
                println("Girilen sayının 2 ile bölümünden kalan sıfır değil.")
            }
        } else {
            println("Hata: Lütfen dört basamaklı bir sayı giriniz.")
        }
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    }



    // 20. Soru

    println("20.Soru:")
    val sayilar = mutableListOf<Int>()

    try {
        for (i in 1..5) {
            print("0 ile 20 arasında bir sayı girin ($i/5): ")
            val sayiz = readLine()!!.toInt()

            if (sayi in 0..20) {
                sayilar.add(sayiz)
            } else {
                println("Hata: 0 ile 20 arasında bir sayı giriniz.")
                return
            }
        }

        val tekSayilar = sayilar.filter { it % 2 != 0 }
        val ciftSayilar = sayilar.filter { it % 2 == 0 }

        val tekOrtalama = tekSayilar.average()
        val ciftOrtalama = ciftSayilar.average()

        println("Girilen tek sayılar: ${tekSayilar.joinToString(", ")}")
        println("Girilen çift sayılar: ${ciftSayilar.joinToString(", ")}")
        println("Tek sayıların aritmetik ortalaması: $tekOrtalama")
        println("Çift sayıların aritmetik ortalaması: $ciftOrtalama")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    }



    // 21.Soru

    println("21.Soru:")
    try {
        println("Liste boyutunu girin: ")
        val boyut = readLine()!!.toInt()

        if (boyut <= 0) {
            println("Hata: Geçersiz liste boyutu")
            return
        }

        val liste = mutableListOf<Int>()

        for (i in 0 until boyut) {
            println("Eleman $i girin: ")
            val eleman = readLine()!!.toInt()
            liste.add(eleman)
        }

        val tekToplam = liste.filterIndexed { index, _ -> index % 2 == 1 }.sum()
        val ciftToplam = liste.filterIndexed { index, _ -> index % 2 == 0 }.sum()

        println("Tek indeksteki tamsayıların toplamı: $tekToplam")
        println("Çift indeksteki tamsayıların toplamı: $ciftToplam")
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir tamsayı girmediniz.")
    }



    // 22.Soru

    println("22.Soru:")
    try {
        println("Üst sınıfı girin: ")
        val ustSinir = readLine()!!.toInt()

        if (ustSinir <= 0) {
            println("Hata: Geçerli bir pozitif üst sınır girin.")
            return
        }

        println("Mükemmel sayılar: ")
        for (sayi22 in 1..ustSinir) {
            if (soru22(sayi22)) {
                println(sayi22)
            }
        }
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir tamsayı girmediniz.")
    }
}

fun soru22(sayi22: Int): Boolean {
    var toplam22 = 0
    for (bolen22 in 1 until sayi22) {
        if (sayi22 % bolen22 == 0) {
            toplam22 += bolen22
        }
    }
    return toplam22 == sayi22


    // 23. Soru

    println("23.Soru:")
    print("Bir sayı girin: ")
    val soru23 = readLine()

    try {
        if (soru23 != null) {
            val sayi = soru23.toDouble()
            if (sayi >= 0) {
                val karekok = sqrt(sayi)
                println("Girilen sayının karekökü: $karekok")
            } else {
                println("Hata: Negatif bir sayı girdiniz. Karekök hesaplanamaz.")
            }
        } else {
            println("Hata: Geçerli bir sayı girmediniz.")
        }
    } catch (e: NumberFormatException) {
        println("Hata: Geçerli bir sayı girmediniz.")
    }

}

    //24. Soru
    fun soru24(){
    val soru24 = mutableListOf<Int>()

    for (i in 1..3) {
        try {
            print("3 basamaklı bir sayı girin ($i/3): ")
            val sayi24 = readLine()!!.toInt()

            if (sayi24 < 100 || sayi24 > 999) {
                println("Hata: 3 basamaklı bir sayı giriniz.")
                return
            }

            soru24.add(sayi24)
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir tamsayı girmediniz.")
            return
        }
    }

    println("Armstrong sayıları: ")
    for (sayi24 in soru24) {
        if (isArmstrongNumber(sayi24)) {
            println(sayi24)
        }
    }
}

fun isArmstrongNumber(sayi24: Int): Boolean {
    var geciciSayi = sayi24
    var toplam24 = 0

    while (geciciSayi != 0) {
        val basamak = geciciSayi % 10
        toplam24 += basamak * basamak * basamak
        geciciSayi /= 10
    }

    return toplam24 == sayi24


    // 25. Soru

    fun soru25() {
        println("25.Soru:")
        try {
            print("Pozitif bir tam sayı girin: ")
            val girilenSayi = readLine()!!.toInt()

            if (girilenSayi < 0) {
                println("Hata: Negatif bir sayı giremezsiniz.")
                return
            }

            var faktoriyel = 1
            for (i in 1..girilenSayi) {
                faktoriyel *= i
            }

            println("$girilenSayi! = $faktoriyel")
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir tamsayı girmediniz.")
        }
    }


    // 26. Soru

    fun soru26() {
        println("26.Soru:")
        try {
            println("Yaşınızı girin: ")
            val yas = readLine()!!.toInt()

            if (yas < 0) {
                println("Hata: Negatif bir yaş giremezsiniz.")
                return
            }

            val ehliyetYasi = 18 // Ehliyet alabilme yaşı
            if (yas >= ehliyetYasi) {
                println("Ehliyet alabilirsiniz!")
            } else {
                val kacYilSonraAlabilir = ehliyetYasi - yas
                println("Maalesef ehliyet alacak yaşta değilsiniz, $kacYilSonraAlabilir yıl sonra ehliyet almaya hak kazanabilirsiniz!")
            }
        } catch (e: NumberFormatException) {
            println("Hata: Geçerli bir yaş girmediniz.")
        }
    }


    // 27. Soru

    println("27. Soru")
    var validInput = false
    var questionNumber = 0

    while (!validInput) {
        println("Buraya kaçıncı soruyu yazdığınızı girin:")
        val input = readLine()?.trim()

        if (input != null && input.isNotEmpty()) {
            try {
                questionNumber = input.toInt()
                if (questionNumber in 1..50) {
                    validInput = true
                } else {
                    println("Hata: Lütfen 1 ile 50 arasında bir sayı girin.")
                }
            } catch (e: NumberFormatException) {
                println("Hata: Geçersiz sayı formatı. Lütfen bir sayı girin.")
            }
        } else {
            println("Hata: Geçersiz giriş. Lütfen bir sayı girin.")
        }
    }

    println("Girilen Soru Numarası: $questionNumber")


    // 28. Soru

    println("28.Soru:")
    var puan: Int? = null

    try {
        while (puan == null || puan !in 400..500) {
            println("LYS puanınızı girin (400-500 arasında):")
            val input = readLine()?.trim()
            if (input.isNullOrEmpty()) {
                println("Hata: Geçersiz giriş. Bir sayı girin.")
            } else {
                puan = input.toIntOrNull()
                if (puan == null) {
                    println("Hata: Geçersiz sayı formatı. Bir sayı girin.")
                } else if (puan !in 400..500) {
                    println("Üzülme, Vazgeçme! 😊")
                }
            }
        }

        println("Mühendislik Fakültesi'ne yerleşebilirsiniz.")
    } catch (e: Exception) {
        println("Bir hata oluştu: ${e.message}")
    } finally {
        println("İşlem Tamamlandı")
    }


    // 29. Soru

    println("29.Soru:")
    val soru29 = "Sıcak su mu soğuk su mu daha erken donar?"
    val dogruCevap = "Sıcak su"

    println(soru29)
    val cevap = readLine()?.trim()

    if (cevap == null) {
        println("Geçersiz giriş. Cevap vermediniz.")
    } else if (cevap.equals(dogruCevap, ignoreCase = true)) {
        println("Tebrikler! Doğru cevap.")
    } else {
        println("Üzgünüm, yanlış cevap. Doğru cevap: $dogruCevap")
    }


    // 30. Soru

    println("30. Soru:")
    try {
        println("Adınızı girin:")
        val ad = readLine()?.trim() ?: ""

        println("Soyadınızı girin:")
        val soyad = readLine()?.trim() ?: ""

        println("Yaşınızı girin:")
        val yasInput = readLine()?.trim()
        val yas2 = yasInput?.toIntOrNull() ?: 0

        println("E-posta adresinizi girin:")
        val email = readLine()?.trim() ?: ""

        if (email.matches(Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}"))) {
            val kullaniciAdi = "${ad.toLowerCase()}_${soyad.toLowerCase()}"

            if (yas2 >= 18) {
                println("Kayıt Tamamlandı:")
                println("Ad Soyad: $ad $soyad")
                println("Yaş: $yas2")
                println("E-posta: $email")
                println("Kullanıcı Adı: $kullaniciAdi")
            } else {
                println("Yaşınız 18'den küçük olduğu için kayıt kabul edilmedi.")
            }
        } else {
            println("Geçersiz e-posta adresi. Lütfen doğru bir e-posta girin.")
        }
    } catch (e: Exception) {
        println("Bir hata oluştu: ${e.message}")
    }
}














