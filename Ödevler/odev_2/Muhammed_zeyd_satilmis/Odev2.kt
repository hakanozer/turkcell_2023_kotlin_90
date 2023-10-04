package com.example.kotlin_day1._odevler_

fun main(args: Array<String>) {
//Soru 1:
    isPrime(5)
//Soru 2:
    toplamHesapla(45, 565)
//Soru 3:
    modHesaplamaBolme(12, 43)
//Soru 4:
    longSum(31214345)
//Soru 5:
    bmiCalculator(71.5, 180.4)
//Soru 6:
    reverseNumber(71539412)
//Soru 7:
    isPalindrome(444)
//Soru 8:
    val intArrayNum = intArrayOf(38, 44, 1, 8, 54)
    sumMinMax(intArrayNum)
//Soru 9:
    val intArrayList = intArrayOf(14, 1, 5, 9, 2)
    containsNumber(intArrayList, 14)
//Soru 10:
    findMaxValue(5, 11, 44, 3)
//Soru 11:
    val n1Array = intArrayOf(14, 6, 84, 215, 654, 212)
    val n2Array = intArrayOf(212, 514, 8, 6, 14, 96)
    findNums(n1Array, n2Array)
//Soru 12:
    divideTry(100, 0)
//Soru 13:
    numControl()
//Soru 14:
    bol(120, 0)
//Soru 15:
    ortalama("300", "50")
//Soru 16:
    karakterKarsilastir()
//Soru 17:
    tointMethod()
//Soru 18:
    carpim()
//Soru 19:
    dortBasamakli()
//Soru 20:
    tekCiftAritmetik()
//Soru 21:
    listeBoyutu()
//Soru 22:
    mukemmelSayilar()
//Soru 23:
    karekokHesapla()
//Soru 24:
//Soru 25:
    faktoriyelHesap()
//Soru 26:
    ehliyet()
//Soru 27:
    sorular()
//Soru 28:
    lysPuan()
//Soru 29:
    quizApp()
//Soru 30:
    kullaniciKayit()


}

//Soru 1:
fun isPrime(number: Int): Boolean {
    if (number <= 1) {
        println("Asal değil 2 den küçük")
        return false

    }

    for (i in 2 until number) {
        if (number % i == 0) {
            println("Asal değil")
            return false

        }
    }
    println("Asal sayı")
    return true
}

//Soru 2:

fun toplamHesapla(sayi1: Int, sayi2: Int): Int {
    var toplam = 0

    for (i in sayi1 + 1..sayi2) {
        toplam += i
    }
    println(toplam)
    return toplam
}

//Soru 3:
fun modHesaplamaBolme(a: Int, b: Int): Any {
    return if (a % 2 == 1) {
        val value = a / b
        println(value)
    } else {
        val modValue = (a % b).toDouble()
        println(modValue)
    }
}

//Soru 4:
fun longSum(sayi: Long): Int {
    var toplam = 0
    var kalanSayi = sayi

    while (kalanSayi > 0) {
        val rakam = (kalanSayi % 10).toInt()
        toplam += rakam
        kalanSayi /= 10
    }
    println(toplam)
    return toplam
}

//Soru 5:
fun bmiCalculator(kilo: Double, boy: Double): Double {
    val bmi = kilo / (boy * boy)
    println(bmi)
    return bmi
}

//Soru 6:
fun reverseNumber(number: Int): Int {
    var reversedNumber = 0
    var temp = number

    while (temp > 0) {
        reversedNumber = reversedNumber * 10 + temp % 10
        temp /= 10
    }
    println(reversedNumber)
    return reversedNumber
}

//Soru 7:
fun isPalindrome(number: Int): Boolean {
    val numberString = number.toString()
    if (numberString == numberString.reversed()) {
        println("palindrome")
        return true
    } else {
        println("palindrome değil")
        return false
    }
}

//Soru 8:
fun sumMinMax(numbers: IntArray): Int {
    if (numbers.isEmpty()) {
        println("Boş değer")
    }

    var min = numbers[0]
    var max = numbers[0]

    for (number in numbers) {
        if (number < min) {
            min = number
        }
        if (number > max) {
            max = number
        }
    }
    println(min + max)
    return min + max
}

//Soru 9:
fun containsNumber(numList: IntArray, number: Int): Boolean {
    if (numList.contains(number)) {
        println("Sayı liste içinde var")
        return true
    }
    println("Sayı liste içinde yok")
    return false
}

//Soru 10:
fun findMaxValue(a: Int, b: Int, c: Int, d: Int): Int {
    println(maxOf(a, b, c, d).toString())
    return maxOf(a, b, c, d)
}

//Soru 11:
fun findNums(array1: IntArray, array2: IntArray): Int {
    var count = 0
    for (item in array1) {
        if (array2.contains(item)) {
            count++
        }
    }
    println("Aynı eleman sayısı: $count")
    return count
}

//Soru 12:
fun divideTry(value1: Int, value2: Int) {

    try {
        val divided = value1 / value2;
        println(divided)
    } catch (e: Exception) {
        println(e)
    }

}

//Soru 13:
fun numControl() {
    val sayi = readLine()?.toIntOrNull()
    try {
        println(sayi)
    } catch (e: NumberFormatException) {

        println("Girdiğiniz değer sayı değil")
    }
}

//Soru 14:
fun bol(a: Int, b: Int): Int {
    if (b == 0 || a == 0) {
        throw Exception("Bölme işlemi sıfıra bölünemez.")
    }
    return a / b
}

//Soru 15:
fun ortalama(sayi1: String, sayi2: String): Double {
    val num1 = readlnOrNull()
    val num2 = readlnOrNull()
    try {
        if (num1 != null && num2 != null) {
            val numint1 = num1.toInt()
            val numint2 = num2.toInt()
            return (numint1 + numint2) / 2.0
        }
    } catch (e: Exception) {
        println("Lütfen integer değerler giriniz.")
        return 0.0
    }
    return 0.0
}

//Soru 16:
fun karakterKarsilastir() {
    val ifade1 = readLine() ?: ""
    val ifade2 = readLine() ?: ""


    try {
        val karakterSayisi1 = ifade1.length
        val karakterSayisi2 = ifade2.length

        if (karakterSayisi1 != karakterSayisi2) {

            println("Karakter sayıları uyuşmuyor")
        } else {

            println("Karakter sayıları uyuşuyor")
        }
    } catch (e: Exception) {

        println(e.message)
    }
}

//Soru 17:
fun tointMethod() {
    val metin = readLine() ?: ""
    try {
        val sayi = metin.toInt()
        println("Metin: $metin, Sayı: $sayi")
    } catch (e: Exception) {
        println("Geçersiz sayı")
    }
}

//Soru 18:
fun carpim() {
    val sayi1 = readLine() ?: ""
    val sayi2 = readLine() ?: ""
    try {
        val sayi1Int = sayi1.toInt()
        val sayi2Int = sayi2.toInt()

        val carpim = sayi1Int * sayi2Int
        println("Çarpım: $carpim")
    } catch (e: NumberFormatException) {
        println("Geçersiz sayı")
    }
}

//Soru 19:
fun dortBasamakli() {
    println("Dört basamaklı bir sayı girin:")
    val sayi = readLine() ?: ""

    try {
        val sayiInt = sayi.toInt()
        val kalan = sayiInt % 2
        if (kalan == 0) {
            println("Sayı 2 ile bölündüğünde kalanı 0'dır.")
        } else {
            println("Sayı 2 ile bölündüğünde kalanı 0 değildir.")
        }
    } catch (e: Exception) {

        println("Geçersiz sayı")
    }
}
//Soru 20:

fun tekCiftAritmetik() {
    println("0 ile 20 arasından 5 sayı girin:")
    val sayilar = Array(5) { readLine() ?: "" }


    val tekSayilar = mutableListOf<Int>()
    val ciftSayilar = mutableListOf<Int>()
    for (sayi in sayilar) {
        try {
            val sayiInt = sayi.toInt()
            if (sayiInt % 2 == 0) {
                ciftSayilar.add(sayiInt)
            } else {
                tekSayilar.add(sayiInt)
            }
        } catch (e: Exception) {
            println("Geçersiz sayı")
        }
    }

    if (tekSayilar.isNotEmpty()) {
        val tekSayiAritmetikOrtalamasi = tekSayilar.sum() / tekSayilar.size
        println("Tek sayıların aritmetik ortalaması: $tekSayiAritmetikOrtalamasi")
    } else {
        println("Tek sayı yok")
    }

    if (ciftSayilar.isNotEmpty()) {
        val ciftSayiAritmetikOrtalamasi = ciftSayilar.sum() / ciftSayilar.size
        println("Çift sayıların aritmetik ortalaması: $ciftSayiAritmetikOrtalamasi")
    } else {
        println("Çift sayı yok")
    }
}

//Soru 21:
fun listeBoyutu() {
    println("Listenin boyutunu girin:")
    val boyut = readLine()?.toInt() ?: -1

    if (boyut < 0) {
        println("Geçersiz boyut")
        return
    }

    val list = mutableListOf<Int>()
    for (i in 0 until boyut) {
        println("$i. elemanı girin:")
        val sayi = readLine()?.toInt() ?: -1

        if (sayi < 0) {
            println("Geçersiz eleman")
            return
        }

        list.add(sayi)
    }

    var ciftIndeksiTamsayilarToplami = 0
    for (i in 0 until boyut) {
        if (i % 2 == 0) {
            ciftIndeksiTamsayilarToplami += list[i]
        }
    }

    var tekIndeksiTamsayilarToplami = 0
    for (i in 0 until boyut) {
        if (i % 2 != 0) {
            tekIndeksiTamsayilarToplami += list[i]
        }
    }

    println("Çift indeksteki tamsayıların toplamı: $ciftIndeksiTamsayilarToplami")
    println("Tek indeksteki tamsayıların toplamı: $tekIndeksiTamsayilarToplami")
    println("Tek indeksteki tamsayıların toplamı: $tekIndeksiTamsayilarToplami")
}

//Soru 22:
fun mukemmelSayilar() {

    println("Bir sayı girin:")
    val sayi = readLine()?.toInt() ?: -1

    if (sayi < 1) {
        println("Geçersiz sayı")
        return
    }
    val mukemmelSayilar = mutableListOf<Int>()
    for (i in 1 until sayi) {
        var toplam = 0
        for (j in 1 until i) {
            if (i % j == 0) {
                toplam += j
            }
        }
        if (toplam == i) {
            mukemmelSayilar.add(i)
        }
    }
    println("Mükemmel sayılar: $mukemmelSayilar")
}

//Soru 23:
fun karekokHesapla() {
    println("Bir sayı girin:")
    val sayi = readLine()?.toInt() ?: -1

    try {
        if (sayi < 0) {
            throw IllegalArgumentException("Negatif sayı giremezsiniz")
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }
    val kkok = Math.sqrt(sayi.toDouble())

    println("Sayının karekökü: $kkok")
}

//Soru 24:
//Soru 25:
fun faktoriyelHesap() {
    println("Bir sayı girin:")
    val sayi = readLine()?.toInt() ?: -1

    try {
        if (sayi < 0) {
            throw Exception("Negatif sayı giremezsiniz")
        } else if (false) {
            throw Exception("Lütfen bir tam sayı giriniz.")
        }
    } catch (e: Exception) {
        println(e.message)
        return
    }
    var faktoriyel = 1
    for (i in 1..sayi) {
        faktoriyel *= i
    }
    println("Faktöriyel: $faktoriyel")
}

//Soru 26:
fun ehliyet() {
    println("Yaşınızı girin:")
    val yas = readLine()?.toInt() ?: -1

    try {
        if (false) {
            throw Exception("Yaş sayı olmalıdır.")
        }
    } catch (e: Exception) {
        println(e.message)
        return
    }


    val ehliyetAlabilmeYasi = 18
    if (yas < ehliyetAlabilmeYasi) {

        val kalanYil = ehliyetAlabilmeYasi - yas
        println("Maalesef ehliyet alacak yaşta değilsiniz, $kalanYil yıl sonra ehliyet almaya hak kazanabilirsiniz!")
    } else {

        println("Ehliyet almaya hak kazandınız!")
    }
}

//Soru 27:
fun sorular() {

    println("Kaçıncı soruyu yazıyorsunuz? (1-50):")
    val soruNumarasi = readLine()?.toInt() ?: -1

    try {
        if (soruNumarasi !is Int || soruNumarasi < 1 || soruNumarasi > 50) {
            throw IllegalArgumentException("Soru numarası 1 ile 50 arasında olmalıdır.")
        }
    } catch (e: Exception) {
        println(e.message)
        println("Lütfen geçerli bir soru numarası giriniz.")
        return
    }

    println("Sorunun doğru numarası $soruNumarasi'dır.")
}

//Soru 28:
fun lysPuan() {
    println("Lys puanınızı girin:")
    val puan = readLine()?.toIntOrNull() ?: -1

    try {
        if (puan !is Int || puan < 0) {
            throw Exception("Puan sayı olmalıdır.")
        }
    } catch (e: Exception) {
        println(e.message)
        return
    } finally {
        println("İşlem Tamamlandı.")
        val mühendislikFakultesiPuaniMin = 400
        val mühendislikFakultesiPuaniMax = 430
        if (puan in mühendislikFakultesiPuaniMin..mühendislikFakultesiPuaniMax) {
            println("Mühendislik Fakültesi'ne yerleşebilirsiniz.")
        } else {
            println("Üzülme, vazgeçme")
        }
    }
}

//Soru 29:
fun quizApp() {
    val soru = "Malatya'nın nesi meşhurdur?"
    val cevap = "Kayısı"

    println("Soruyu cevaplayınız:")
    val kullaniciCevap = readLine() ?: ""

    if (kullaniciCevap == cevap) {
        println("Tebrikler! Doğru cevabı bildiniz.")
    } else {
        println("Üzgünüm, yanlış cevap bildiniz.")
        println("Doğru cevap: $cevap")
    }
}

//Soru 30:
fun kullaniciKayit() {
    println("Adınızı girin:")
    val ad = readLine() ?: ""

    println("Soyadınızı girin:")
    val soyad = readLine() ?: ""

    println("Yaşınızı girin:")
    val yas = readLine()?.toInt() ?: -1

    println("E-posta adresinizi girin:")
    val mail = readLine() ?: ""

    try {
        if (!mail.contains("@")) {
            throw Exception("E-posta adresi geçersizdir.")
        }
    } catch (e: Exception) {
        println(e.message)
        return
    }

    val kullaniciAdi = "${ad.toLowerCase()}${soyad.toLowerCase()}"

    if (yas < 18) {
        println("Yaşınız 18'den küçüktür. Kayıt kabul edilmedi.")
        return
    }

    println("**Kayıt bilgileri:**")
    println("Ad: $ad")
    println("Soyad: $soyad")
    println("Yaş: $yas")
    println("Mail: $mail")
    println("Kullanıcı adı: $kullaniciAdi")

    println("Kayıt başarıyla tamamlandı.")
}