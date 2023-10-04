package com.example.odev_2

import java.lang.ArithmeticException
import kotlin.math.sqrt


fun main() {
    println("Soru 1: ${isPrime(5)}")
    println("Soru 2: ${sum(1, 10)}")
    println("Soru 3: ${hasEven(5, 2)}")
    println("Soru 4: ${longReceive(123)}")
    println("Soru 5: ${BMI(80.0, 1.80)}")
    println("Soru 6: ${reversedNumber(1234)}")
    println("Soru 7: ${palindrome(12321)}")
    println("Soru 8: ${listMinMaxSum(listOf(1, 2, 3, 4, 5))}")
    println("Soru 9: ${containsList(listOf(1, 2, 3, 4, 5), 3)}")
    println("Soru 10: ${hasBigNumber(1, 2, 3, 4)}")
    println("Soru 11: ${commonElements(listOf(1, 2, 3, 4, 5), listOf(1, 2, 3, 4, 5))}")
    println("Soru 12: ${question12(1, 0)}")
    println("Soru 13: ${question13()}")
    println("Soru 14: ${question14(1, 0)}")
    println("Soru 15: ${question15()}")
    println("Soru 16: ${question16("1", "2")}")
    println("Soru 17: ${question17()}")
    println("Soru 18: ${question18()}")
    println("Soru 19: ${question19()}")
    println("Soru 20: ${question20()}")
    println("Soru 21: ${question21()}")
    println("Soru 22: ${question22(6)}")
    println("Soru 23: ${question23()}")
    println("Soru 24: ${question24()}")
    println("Soru 25: ${question25()}")
    println("Soru 26: ${question26()}")
    println("Soru 27: ${question27()}")
    println("Soru 28: ${question28()}")
    println("Soru 29: ${question29()}")
    println("Soru 30: ${question30()}")
}

// SORU 1
fun isPrime(n: Int): Boolean {
    if (n <= 1) {
        return false
    }
    for (i in 2..<n) {
        if (n % i == 0) {
            return false
        }
    }
    return true
}

//SORU 2
fun sum(first: Int, last: Int): Int {
    var totalCount = 0
    for (i in first + 1..last) {
        totalCount += i
    }
    return totalCount
}

//SORU 3
fun hasEven(n1: Int, n2: Int): Double {
    val isEven: Boolean = n1 % 2 == 0
    return if (isEven) n1.toDouble() % n2.toDouble() else n1.toDouble() / n2.toDouble()
}


//SORU 4
fun longReceive(number: Long): Long {
    var stringValue = number.toString().replace(".", "")
    var totalNumber: Long = 0
    for (i in stringValue) {
        var intNumber = i.toString().toInt()
        totalNumber += intNumber
    }
    return totalNumber
}


// SORU 5
fun BMI(kilo: Double, boy: Double): Double {
    return kilo / (boy * boy)
}

// SORU 6
fun reversedNumber(n: Int): Int {
    val newNumber = n.toString().reversed()
    return newNumber.toInt()
}


//SORU 7
fun palindrome(n: Int): Boolean {
    val reverseNumber = n.toString().reversed()
    val number = n.toString()
    return number == reverseNumber
}


//SORU 8
fun listMinMaxSum(list: List<Int>): Int {
    return list.max() + list.min()
}

//SORU 9
fun containsList(myList: List<Int>, n: Int): Boolean {
    return myList.contains(n)
}


//SORU 10
fun hasBigNumber(n1: Int, n2: Int, n3: Int, n4: Int): Int {
    val myList = arrayListOf<Int>(n1, n2, n3, n4)
    return myList.max()
}


//SORU 11
fun commonElements(listOne: List<Int>, listTwo: List<Int>): Int {
    return listOne.count { k -> listTwo.any { j -> k == j } }
}

//SORU 12
fun question12(n1: Int, n2: Int) {
    try {
        println(n1 / n2)
    } catch (e: ArithmeticException) {
        println("Lütfen sayılar içerisinde '0' bulundurmayınız!")
    }
}

//SORU 13
fun question13() {
    val scanValue = readln()
    try {
        val value = scanValue.toInt()
        println("Girilen değer -> $value")
    } catch (e: Exception) {
        println("Lütfen geçerli bir sayı giriniz!")
        question13()
    }
}

//SORU 14
fun question14(n1: Int, n2: Int) {
    if (n2 == 0) {
        throw Exception("Bölme işlemi sıfıra bölünemez.")
    } else {
        println(n1 / n2)
    }
}

//SORU 15
fun question15() {
    val n1 = getNumber("Birinci sayıyı giriniz!")
    val n2 = getNumber("İkinci sayıyı giriniz!")
    println("Ortalama => ${(n1 + n2) / 2}")
}

//SORU 16
fun question16(s1: String, s2: String) {
    try {
        if (s1.length != s2.length) {
            throw Exception("Karakter sayıları uyuşmuyor!")
        }
    } catch (e: Exception) {
        println(e)
    }
}

//SORU 17
fun question17() {
    getNumber("Metin verisi giriniz :)")
}

//SORU 18
fun question18() {
    val n1 = getNumber("Birinci sayıyı giriniz!")
    val n2 = getNumber("İkinci sayıyı giriniz!")
    println("Sonuç => ${n1 * n2}")
}

//SORU 19
fun question19() {
    val n1 = getNumber("4 basamaklı birinci sayıyı giriniz!") {
        it.length == 4
    }
    try {
        if (n1 % 2 != 0) {
            throw Exception("Kalan ${n1 % 2}")
        } else {
            println("${n1 % 2 == 0}")
        }
    } catch (e: Exception) {
        println(e)
    }

}

//SORU 20
fun question20() {
    val list = mutableListOf<Int>()
    for (i in 0..<5) {
        val value = getNumber("${i + 1}.nci sayıyı giriniz") {
            it.toInt() <= 20
        }
        list.add(value)
    }
    var evensList = list.filter { e -> e % 2 == 0 }.sum() / list.filter { e -> e % 2 == 0 }.size
    var oddList = list.filter { e -> e % 2 != 0 }.sum() / list.filter { e -> e % 2 != 0 }.size
    println("Çiftlerin ortalaması:$evensList")
    println("Teklerin ortalaması:$oddList")
}

//SORU 21
fun question21() {
    val list = mutableListOf<Int>()
    var evenTotal = 0
    var oddTotal = 0
    val size = getNumber("Listeye eklemek istediğiniz eleman sayısını giriniz:")

    for (i in 0..<size) {
        val j = getNumber("${i + 1}.nci elemanı giriniz: ")
        list.add(j)
        if (i % 2 == 0) {
            evenTotal += j
        } else {
            oddTotal += j
        }
    }
    println("Liste uzunluğu ${list.size}")
    println("Çift sayıların toplamı: $evenTotal")
    println("Tek sayıların toplamı: $oddTotal")
}

//SORU 22
fun question22(number: Int): Boolean {
    if (number <= 1) {
        return false
    }

    var sum = 1
    val sqrt = Math.sqrt(number.toDouble()).toInt()
    for (i in 2..sqrt) {
        if (number % i == 0) {
            sum += i
            val value = number / i
            if (value != i) {
                sum += value
            }
        }
    }

    return sum == number
}

//SORU 23
fun question23() {
    var value = getNumber("Bir sayı giriniz!")
    try {
        if (value < 0) {
            throw Exception("Lütfen pozitif sayı giriniz!")
        } else {
            sqrt(value.toDouble()).toInt()
        }
    } catch (e: Exception) {
        println(e.toString())
    }
}

//SORU 24
fun question24() {
    var number = getNumber("ÜÇ basamaklı sayı giriniz.")
    val digit1 = number / 100
    val digit2 = (number / 10) % 10
    val digit3 = number % 10

    val firstChar = digit1 * digit1 * digit1
    val twoChar = digit2 * digit2 * digit2
    val threeChar = digit3 * digit3 * digit3
    var armstrongNumber = firstChar + twoChar + threeChar
    println(armstrongNumber)

}

// SORU 25
fun question25() {
    val number = getNumber("Faktöriyelini hesaplamak istediğiniz sayıyı giriniz")
    var fact = 1
    try {
        if (number < 0) {
            throw Exception("Sıfırdan küçük değer girmeyiniz")
        } else {
            for (i in 1..number) {
                fact *= i
            }
            println("--> $fact")
        }
    } catch (e: Exception) {
        println(e.toString())
    }

}

// SORU 26
fun question26() {
    val number = getNumber("Kaç yaşındasınız")
    try {

        if (number < 0) {
            throw Exception(
                "Maalesef ehliyet alacak yaşta değilsiniz,\n" + "2 yıl sonra ehliyet almaya hak kazanabilirsiniz!"
            )
        } else {
            println("Ehliyet alabilirsiniz.")
        }

    } catch (e: Exception) {
        println(e.toString())
    }
}

//SORU 27
fun question27() {
    val number = getNumber("Kaçıncı soruyu yazdınız : ")

    if (number > 50) {
        getNumber("Kaçıncı soruyu yazdınız : ")
    }

}

//SORU 28
fun question28() {
    val number = getNumber("LYS Puanınızı Giriniz : ")
    try {
        if (number in 401..429) {
            throw Exception("Mühendislik Fakültesi’ne yerleşebilirsiniz ")

        } else {
            throw Exception("Üzülme, Vazgeçme ! \uD83D\uDE0A ")
        }
    } catch (e: Exception) {
        println(e.toString())
    } finally {
        println("İşlem tamamlandı")

    }
}

//SORU 29
fun question29() {
    try {
        var answers = arrayListOf<String>("9", "11", "57", "43")
        for (i in answers) {
            println("${answers.indexOf(i) + 1})- $i")
        }
        var question = getNumber("5+6 toplamı kaçtır?")

        if (question == 2) {
            println("Doğru Cevap Tebrikler!!")
        } else {
            throw Exception()
        }
    } catch (e: Exception) {
        println("Hatalı cevap!")
    }

}

//SORU 30
fun question30() {
    val email = readln()
    val name = readln()
    val age = readln()
    try {
        val check =
            email.isNotEmpty() && email.contains("@") && email.contains(".com") && name.trim()
                .isNotEmpty() && age.trim().toInt() >= 18;
        if (check) {
            println("Kaydınız tamamlanmıştır")
        } else {
            throw Exception()
        }
    } catch (e: Exception) {
        println("Lütfen girdiğiniz bilgilerin doğrulugunu kontrol ediniz!")
    }
}

fun getNumber(message: String? = null, condition: ((String) -> Boolean)? = null): Int {
    if (message != null) println(message)
    val scanValue = readln()
    return try {
        val value = scanValue.toInt()
        if (condition != null) {
            if (condition(value.toString())) {
                value
            } else {
                println("Lütfen kurala uygun bir değer giriniz!")
                getNumber(message, condition)
            }
        } else {
            value
        }
    } catch (e: Exception) {
        println("Lütfen geçerli bir sayı giriniz!")
        getNumber(message, condition)
    }
}
