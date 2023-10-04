package com.bugcompany.challenge02.Question20

import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    sumOddEvenIndex()
    perfectNumbers()
    calculatorSqrt()
    findArmstrongNumber()
    calculatorFact()
    questionNumberInput()
    checkDrivingLicenseStatus()
    lysPuaniKontrol()
    quiz()
    userSave()
}

//Question 21
fun sumOddEvenIndex() {
    try {
        println("Enter array size")
        val size = readLine()?.toIntOrNull()
        if (size != null && size > 0) {

            val numbers = arrayListOf<Int>()
            for (i in 0 until size) {
                println("Enter the $i.th element of the array")
                val index = readLine()?.toIntOrNull()
                if (index != null) {
                    numbers.add(index)
                } else {
                    println("Invalid value")
                }
            }
            var evenIndex = 0
            var oddIndex = 0
            numbers.forEachIndexed { index, number ->
                if (index % 2 == 0) {
                    evenIndex += number
                } else {
                    oddIndex += number
                }
            }
            println("Sum of even indexes: $evenIndex")
            println("Sum of odd indexes: $oddIndex")
        } else {
            println("Invalid array size")
        }
    } catch (e: NumberFormatException) {
        println("Invalid value entered")
    }
}

//Question 22
fun perfectNumbers() {
    try {
        println("Bir üst sınır girin: ")
        val upperBound = readLine()!!.toInt()

        for (i in 1..upperBound) {
            var sum = 0
            for (j in 1 until i) {
                if (i % j == 0) {
                    sum += j
                }
            }

            if (sum == i) {
                println("$i mükemmel bir sayıdır.")
            }
        }
    } catch (e: NumberFormatException) {
        println("Lütfen geçerli bir sayı girin.")
    }
}

//Question 23
fun calculatorSqrt() {
    try {
        println("Enter a number")
        val number = readLine()?.toDouble()
        if (number != null) {
            if (number >= 0) {
                val sqrtNumber = sqrt(number)
                // Karekökü ekrana yazdırın
                println("Square root: $sqrtNumber")
            } else {
                println("Please enter a non-negative number")
            }
        }
    } catch (e: NumberFormatException) {
        println("Please enter a valid number")
    }
}

//Question 24
fun findArmstrongNumber() {

    try {
        println("Enter 3-digit numbers")
        val number = readLine()?.toInt()
        if (number != null && number in 100..999) {

            val secondDigit = (number % 100) / 10
            val firstDigit = number % 10
            val thirdDigit = number / 100

            val armstrongSum = (firstDigit.toDouble().pow(3.0)) + (secondDigit.toDouble()
                .pow(3.0)) + (thirdDigit.toDouble().pow(3.0))

            if (number.toDouble() == armstrongSum) {
                println("Number is not Armstrong")

            } else {
                println("Number is not Armstrong")
            }

        } else {
            println("Enter please 3-digit numbers ")
        }

    } catch (e: Exception) {

    }

}

//Question 25
fun calculatorFact() {
    var factorial = 1
    try {
        println("Enter number")
        val number = readLine()?.toInt()
        if (number != null && number >= 0) {
            for (num in 2..number) {
                factorial *= num
            }
            println(factorial)
        } else {
            println("Enter a non-negative integer")
        }


    } catch (e: NumberFormatException) {
        println("Invalid number")

    }
}

//Question 26
fun checkDrivingLicenseStatus() {
    val drivingLicenseAge = 18
    try {
        println("Enter your age:")
        val input = readLine()

        if (!input.isNullOrEmpty()) {
            val age = input.toInt()

            if (age >= drivingLicenseAge) {
                println("You can get a driver's license.")
            } else {
                val remainingYears = drivingLicenseAge - age
                println("You can get a driver's license in $remainingYears years.")
            }
        } else {
            println("Please enter a valid age.")
        }
    } catch (e: NumberFormatException) {
        println("You entered an invalid age.")
    }
}

//Question 27
fun questionNumberInput() {
    try {
        println("What question number are you writing this on? (1-50): ")
        val questionNumber = readLine()?.toIntOrNull()
        if (questionNumber != null && questionNumber in 1..50) {
            println(questionNumber)
        } else {
            println("Please enter a valid number.")
        }
    } catch (e: NumberFormatException) {
        println("Please enter a valid number.")
        questionNumberInput()
    }
}

//Question 28
fun lysPuaniKontrol() {
    var lysPuani: Int? = null
    while (true) {
        try {
            println("Lys puanınızı giriniz: ")
            lysPuani = readLine()?.toIntOrNull()
            if (lysPuani == null) {
                println("Lütfen geçerli bir Lys puanı giriniz.")

            } else if (lysPuani !in 100..500) {
                throw IllegalArgumentException("Lys puanınız 100-500 aralığında olmalıdır.")
            }
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    if (lysPuani in 400..500) {
        println("Mühendislik Fakültesi'ne yerleşebilirsiniz!")
    } else {
        println("Üzülme, Vazgeçme!")
    }

    println("İşlem Tamamlandı.")
}

//Question 29
fun quiz() {
    val dogruCevap = 1903
    println("Beşiktaş JK hangi yılda kurulmuştur ")

    try {
        val kullaniciCevap = readLine()?.toInt() ?: println("Hatalı değer")

        if (kullaniciCevap == dogruCevap) {
            println("Tebrikler! Doğru cevap verdiniz.")
        } else {
            println("Üzgünüm, yanlış cevap. Doğru cevap: $dogruCevap")
        }
    } catch (e: NumberFormatException) {
        println("Geçersiz giriş! Bir sayı giriniz.")
    }


}

//Question 30
fun userSave() {
    println("Adınızı giriniz: ")
    val ad = readLine() ?: ""
    println("Soyadınızı giriniz: ")
    val soyad = readLine() ?: ""

    val kullaniciAdi = "${ad.toLowerCase()}${soyad.toLowerCase()}"

    println("Yaşınızı giriniz: ")
    val yas = readLine()?.toIntOrNull() ?: -1

    println("E-posta adresinizi giriniz: ")
    val mail = readLine() ?: ""

    try {
        val regex = Regex("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]+$")
        if (!regex.matches(mail)) {
            throw IllegalArgumentException("E-posta adresi geçersiz.")
        }
    } catch (e: IllegalArgumentException) {
        println(e.message)
        return
    }

    if (yas >= 18) {
        println("Kayıt başarılı!")
        println("Adınız: $ad")
        println("Soyadınız: $soyad")
        println("Kullanıcı adınız: $kullaniciAdi")
        println("Yaşınız: $yas")
        println("E-posta adresiniz: $mail")
    } else {
        println("Kayıt kabul edilmedi. Yaşınız 18'den küçük.")
    }
}




