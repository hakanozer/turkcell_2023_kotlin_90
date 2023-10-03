package com.works.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.sqrt
import java.lang.NumberFormatException
fun soru1(n: Int): Boolean {
    if (n <= 1) return false
    if (n <= 3) return true

    // 2 ve 3'e bölünebilirlik kontrolü
    if (n % 2 == 0 || n % 3 == 0) return false

    var i = 5
    while (i * i <= n) {
        // i ile (i+2) değerlerine göre bölünebilirlik kontrolü
        if (n % i == 0 || n % (i + 2) == 0) return false
        i += 6
    }
    return true
}


            fun soru2(num1: Int, num2:Int) : Int {
                var sonuc = 0
                if(num2 > num1 && num2 > 0) {
                    for (i in num1 + 1 until num2) {
                        sonuc += i
                    }
                }else {
                    print("Lütfen 2. sayisi 1. sayidan büyük giriniz!")
                    throw java.lang.NumberFormatException("Lütfen 2. sayisi 1. sayidan büyük giriniz!")
                }
                return sonuc
            }
            fun soru3(a: Int, b: Int): Double {
                return if (a % 2 == 1) {  // a tek ise
                    a.toDouble() / b
                } else {  // a çift ise
                    a.toDouble() % b
                }
            }
            fun soru4(sayi: Long): Int {
                var tempSayi = sayi
                var toplam = 0

                while (tempSayi != 0L) {
                    toplam += (tempSayi % 10).toInt()  // Sayının son rakamını ekliyoruz
                    tempSayi /= 10  // Sayının son rakamını atıyoruz
                }

                return toplam
            }
            fun soru5(kg: Double, boy: Double): Double {
                return kg / (boy * boy)
            }
            fun soru6(sayi: Int): Int {
                var tempSayi = sayi
                var tersSayi = 0

                while (tempSayi != 0) {
                    tersSayi = tersSayi * 10 + tempSayi % 10
                    tempSayi /= 10
                }

                return tersSayi
            }
            fun soru7(sayi: Int): Boolean {
                val strSayi = sayi.toString()
                return strSayi == strSayi.reversed()
            }
            fun soru8(sayilar: IntArray): Int {
                val enBuyuk = sayilar.maxOrNull() ?: 0
                val enKucuk = sayilar.minOrNull() ?: 0
                return enBuyuk + enKucuk
            }
            fun soru9(dizi: IntArray, sayi: Int): Boolean {
                return sayi in dizi
            }
            fun soru10(a: Int, b: Int, c: Int, d: Int): Int {
                return maxOf(a, b, c, d)
            }
            fun soru11(dizi1: IntArray, dizi2: IntArray): Int {
                return dizi1.intersect(dizi2.asIterable()).count()
            }
            fun soru12(bolen: Int): Int {
                try {
                    return 10 / bolen
                } catch (e: ArithmeticException) {
                    println("Bir sayıyı sıfıra bölemezsiniz!")
                    return 0  // Alternatif olarak istediğiniz bir değeri dönebilir veya bir işlem yapabilirsiniz.
                }
            }
            fun soru13(): Int? {
                print("Bir sayı giriniz: ")
                val girilenDeger = readLine()
                return try {
                    girilenDeger?.toInt()
                } catch (e: java.lang.NumberFormatException) {
                    println("Lütfen geçerli bir sayı giriniz!")
                    null
                }
            }
            fun soru14(bolunen: Int, bolen: Int): String {
                return try {
                    (bolunen / bolen).toString()
                } catch (e: ArithmeticException) {
                    "Bölme işlemi sıfıra bölünemez."
                }
            }
            fun soru15() {
                println("İlk sayıyı giriniz:")
                val firstInput = readLine()

                println("İkinci sayıyı giriniz:")
                val secondInput = readLine()

                val firstNumber: Int
                val secondNumber: Int

                try {
                    firstNumber = firstInput!!.toInt()
                    secondNumber = secondInput!!.toInt()

                    val average = (firstNumber + secondNumber) / 2.0
                    println("Girilen sayıların ortalaması: $average")

                } catch (e: java.lang.NumberFormatException) {
                    println("Lütfen integer değerler giriniz.")
                    soru15()
                }
            }

fun soru16() {
    try {
        println("İlk string ifadeyi giriniz:")
        val firstString = readLine() ?: throw IllegalArgumentException("Bir hata oluştu!")

        println("İkinci string ifadeyi giriniz:")
        val secondString = readLine() ?: throw IllegalArgumentException("Bir hata oluştu!")

        if (firstString.length != secondString.length) {
            println("Karakter sayıları uyuşmuyor")
        } else {
            println("Karakter sayıları uyuşuyor")
        }

    } catch (e: Exception) {
        println("Bir hata oluştu: ${e.message}")
    }
}



fun soru17() {
    println("Bir metin giriniz:")
    val userInput = readLine()
// tam olarak anlayamadım bu soruyu !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!(stack overflow cözümü)
    try {
        val number = userInput!!.toInt()
        println("Girilen metin tamsayıya dönüştürüldü: $number")
    } catch (e: NumberFormatException) {
        println("Girdiğiniz metin bir tamsayıya dönüştürülemedi!")
    }
}
fun soru18() {
    println("İlk sayıyı giriniz:")
    val firstInput = readLine()

    println("İkinci sayıyı giriniz:")
    val secondInput = readLine()

    try {
        val firstNumber = firstInput!!.toInt()
        val secondNumber = secondInput!!.toInt()

        val product = firstNumber * secondNumber
        println("Girilen sayıların çarpımı: $product")

    } catch (e: NumberFormatException) {
        println("Girdiğiniz verilerden bir ya da her ikisi integer değil!")
    }
}
fun soru19() {
    println("Dört basamaklı bir sayı giriniz:")
    val userInput = readLine()

    try {
        val number = userInput!!.toInt()

        if (number in 1000..9999) {
            if (number % 2 == 0) {
                println("Girilen sayı 2'ye bölündüğünde kalan 0'dır.")
            } else {
                println("Girilen sayı 2'ye bölündüğünde kalan 0 değildir.")
            }
        } else {
            println("Lütfen dört basamaklı bir sayı giriniz.")
        }

    } catch (e: NumberFormatException) {
        println("Girdiğiniz veri bir tamsayı değil!")
    }
}

fun soru20() {
    val numbers = mutableListOf<Int>()
    var totalEven = 0
    var totalOdd = 0
    var countEven = 0
    var countOdd = 0
    var index = 1
// yardım aldım tam anlamıyla ben çözemedim !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    while (index <= 5) {
        println("$index. sayıyı giriniz (0-20 arası):")
        val input = readLine()

        try {
            val number = input!!.toInt()

            if (number in 0..20) {
                numbers.add(number)

                if (number % 2 == 0) {
                    totalEven += number
                    countEven++
                } else {
                    totalOdd += number
                    countOdd++
                }

                index++ // Only increment index if valid number is added

            } else {
                println("Lütfen 0 ile 20 arasında bir sayı giriniz!")
            }

        } catch (e: NumberFormatException) {
            println("Girdiğiniz değer bir tamsayı değil!")
        }
    }

    val averageEven = if (countEven > 0) totalEven.toDouble() / countEven else 0.0
    val averageOdd = if (countOdd > 0) totalOdd.toDouble() / countOdd else 0.0

    println("Çift sayıların aritmetik ortalaması: $averageEven")
    println("Tek sayıların aritmetik ortalaması: $averageOdd")
}
fun soru21() {
    println("Liste boyutunu giriniz:")
    val sizeInput = readLine()
// yardım aldım tek başıma halledemedim!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    var listSize = 0

    try {
        listSize = sizeInput!!.toInt()
    } catch (e: NumberFormatException) {
        println("Geçerli bir liste boyutu girilmedi!")
        return
    }

    val numberList = mutableListOf<Int>()

    var position = 0
    while (position < listSize) {
        println("${position + 1}. elemanı giriniz:")

        val elementInput = readLine()
        try {
            val element = elementInput!!.toInt()
            numberList.add(element)
            position++  // Only increment position if valid number is added
        } catch (e: NumberFormatException) {
            println("Geçersiz bir eleman girildi!")
        }
    }

    val evenIndexSum = numberList.filterIndexed { index, _ -> index % 2 == 0 }.sum()
    val oddIndexSum = numberList.filterIndexed { index, _ -> index % 2 != 0 }.sum()

    println("Çift indeksli elemanların toplamı: $evenIndexSum")
    println("Tek indeksli elemanların toplamı: $oddIndexSum")
}
fun soru22() {
    fun isPerfectNumber(num: Int): Boolean {
        var sum = 0
        for (i in 1 until num) {
            if (num % i == 0) {
                sum += i
            }
        }
        return sum == num
    }
//youtube dan yardım aldım !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    println("Hangi sayıya kadar olan mükemmel sayıları bulmak istiyorsunuz?")
    val input = readLine()

    try {
        val limit = input!!.toInt()
        for (i in 1..limit) {
            if (isPerfectNumber(i)) {
                println("$i mükemmel bir sayıdır!")
            }
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz bir değer girdiniz!")
    }
}

fun soru23() {
    println("Karekökünü hesaplamak istediğiniz sayıyı giriniz:")

    try {
        val number = readLine()!!.toDouble()

        if (number < 0) {
            println("Negatif bir sayı girdiniz! Lütfen pozitif bir sayı giriniz.")
        } else {
            val result = sqrt(number)
            println("Girdiğiniz sayının karekökü: $result")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz bir değer girdiniz!")
    }
}


fun soru24() {
    fun isArmstrongNumber(number: Int): Boolean {
        val numAsString = number.toString()
        val numOfDigits = numAsString.length

        var sum = 0
        for (char in numAsString) {
            val digit = Character.getNumericValue(char)
            sum += Math.pow(digit.toDouble(), numOfDigits.toDouble()).toInt()
        }

        return sum == number
    }

    println("3 basamaklı bir sayı giriniz:")

    try {
        val number = readLine()!!.toInt()

        if (number in 100..999 && isArmstrongNumber(number)) {
            println("$number bir Armstrong sayısıdır!")
        } else if (number !in 100..999) {
            println("Lütfen 3 basamaklı bir sayı giriniz!")
        } else {
            println("$number bir Armstrong sayısı değildir!")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz bir değer girdiniz!")
    }
}

fun soru25() {
    println("Pozitif bir tam sayı giriniz:")

    try {
        val number = readLine()!!.toInt()

        if (number < 0) {
            println("Lütfen pozitif bir tam sayı giriniz!")
            return
        }

        var factorial: Long = 1
        for (i in 1..number) {
            factorial *= i
        }

        println("$number! (faktöriyel) = $factorial")
    } catch (e: NumberFormatException) {
        println("Geçersiz bir değer girdiniz! Lütfen pozitif bir tam sayı giriniz.")
    }
}

fun soru26() {
    println("Lütfen yaşınızı giriniz:")

    try {
        val age = readLine()!!.toInt()

        if (age < 0) {
            println("Lütfen geçerli bir yaş giriniz!")
            return
        }

        if (age >= 18) {
            println("Tebrikler! Ehliyet alabilirsiniz.")
        } else {
            val remainingYears = 18 - age
            println("Maalesef ehliyet alacak yaşta değilsiniz, $remainingYears yıl sonra ehliyet almaya hak kazanabilirsiniz!")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz bir değer girdiniz! Lütfen yaşınızı tam sayı olarak giriniz.")
    }
}

fun soru27() {
    val totalQuestionCount = 50

    while (true) {
        println("Toplamda kaç soru yazdığımı lütfen giriniz:")

        try {
            val enteredNumber = readLine()!!.toInt()

            if (enteredNumber == totalQuestionCount) {
                println("Doğru! Toplamda $totalQuestionCount soru yazdım.")
                break
            } else {
                println("Yanlış! Lütfen tekrar deneyiniz.")
            }
        } catch (e: NumberFormatException) {
            println("Geçersiz bir değer girdiniz! Lütfen sadece tam sayı giriniz.")
        }
    }
}

fun soru28() {
    println("Lütfen 'Lys' puanınızı giriniz:")
// orjinal soruda bence bir mantık hatası vardı o yüzden  400 den büyük olacak şekilde çözdüm !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
    try {
        val score = readLine()!!.toDouble()

        if (score > 400.0) {
            println("Mühendislik Fakültesi’ne yerleşebilirsiniz.")
        } else {
            println("Üzülme, Vazgeçme! 😊")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz bir değer girdiniz! Lütfen puanınızı doğru formatta giriniz.")
    } finally {
        println("İşlem Tamamlandı")
    }
}

fun soru29() {
    println("Türkiye'nin başkenti nedir?")
    val answer = readLine()!!

    if (answer.toLowerCase() == "ankara") {
        println("Tebrikler! Doğru cevap.")
    } else {
        println("Yanlış cevap. Doğru cevap: Ankara.")
    }
}

fun soru30() {
    println("Lütfen adınızı giriniz:")
    val name = readLine()!!
//yardım aldım !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    println("Lütfen soyadınızı giriniz:")
    val surname = readLine()!!

    println("Lütfen yaşınızı giriniz:")
    val ageString = readLine()!!

    println("Lütfen e-mail adresinizi giriniz:")
    val email = readLine()!!

    try {
        val age = ageString.toInt()

        if (age < 18) {
            throw IllegalArgumentException("Yaşınız 18'den küçük. Kayıt işlemi gerçekleştirilemiyor.")
        }

        val username = (name + surname).toLowerCase()
        if (!email.contains("@") || !email.contains(".")) {
            throw IllegalArgumentException("Geçersiz e-mail adresi.")
        }

        println("Kayıt işleminiz tamamlandı!")
        println("Kullanıcı Adı: $username")
        println("E-mail: $email")
        println("Yaş: $age")

    } catch (e: NumberFormatException) {
        println("Lütfen geçerli bir yaş değeri giriniz.")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}




fun main() {

    println(soru1(17))  // true, çünkü 17 asaldır
    println(soru1(20))  // false, çünkü 20 asal değildir

    println(soru2(3, 6))  // 4 + 5 = 9 olarak çıktı vermelidir
    println(soru3(5, 2))  // 5 tek olduğu için sonuç: 2.5
    println(soru3(4, 3))  // 4 çift olduğu için sonuç: 1.0
    println(soru4(123456789L))
    println(soru5(70.0, 1.75))
    println(soru6(12345))
    val testSayi = 121
    val sonuc = soru7(testSayi)
    println("$testSayi palindrom mu? : $sonuc")
    val dizi = intArrayOf(3, 5, 1, 7, 9, 4)
    val result = soru8(dizi)
    println("En büyük ve en küçük sayının toplamı: $sonuc")
    val ornekDizi = intArrayOf(2, 4, 6, 8, 10)
    val arananSayi = 5
    val sonuc1 = soru9(ornekDizi, arananSayi)

    if (sonuc1) {
        println("$arananSayi dizide bulunmaktadır.")
    } else {
        println("$arananSayi dizide bulunmamaktadır.")
    }
    print("Birinci sayıyı giriniz: ")
    val sayi1 = readLine()!!.toInt()

    print("İkinci sayıyı giriniz: ")
    val sayi2 = readLine()!!.toInt()

    print("Üçüncü sayıyı giriniz: ")
    val sayi3 = readLine()!!.toInt()

    print("Dördüncü sayıyı giriniz: ")
    val sayi4 = readLine()!!.toInt()

    val enBuyuk = soru10(sayi1, sayi2, sayi3, sayi4)
    println("Girilen sayıların en büyüğü: $enBuyuk")
    print("Birinci dizinin eleman sayısını giriniz: ")
    val boyut1 = readLine()!!.toInt()

    val dizi1 = IntArray(boyut1) {
        print("Birinci dizi için ${it + 1}. elemanı giriniz: ")
        readLine()!!.toInt()
    }

    print("İkinci dizinin eleman sayısını giriniz: ")
    val boyut2 = readLine()!!.toInt()

    val dizi2 = IntArray(boyut2) {
        print("İkinci dizi için ${it + 1}. elemanı giriniz: ")
        readLine()!!.toInt()
    }

    val ortakElemanSayisi = soru11(dizi1, dizi2)
    println("İki dizideki ortak eleman sayısı: $ortakElemanSayisi")
    val sonuc2 = soru12(0)
    println("Sonuç: $sonuc2")

    val alinanSayi = soru13()
    alinanSayi?.let { println("Girdiğiniz sayı: $it") } ?: println("Sayı girilmedi.")

    print("Bölünen sayıyı giriniz: ")
    val bolunen = readLine()!!.toInt()

    print("Bölen sayıyı giriniz: ")
    val bolen = readLine()!!.toInt()

    val sonuc3 = soru14(bolunen, bolen)
    println(sonuc3)

    soru15()

    soru16()



    soru17()  // soruyu tam anlayamadım  stack overflow cözümü bu !!!!!!!!!!!

    soru18()

    soru19()

    soru20()  // yardım aldım !!!!!!!!!!!!!

    soru21()  // yardım aldım !!!!!!!!!!!!!!

    soru22() // youtube dan yardım aldım !!!!!!!!!!!

    soru23()



    soru24()

    soru25()

    soru26()

    soru27()

    soru28()  // orjinalde mantık hatası oldugu için 400 den üstte mi altta mı ona baktım?  !!!!!!

    soru29()

    soru30() // yardım aldım !!!!


}










