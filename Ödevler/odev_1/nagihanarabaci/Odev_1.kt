package com.example.days1.odevler

import java.lang.Exception

fun main(args: Array<String>) {

    println("**********BİRİNCNFİİ SORU**********")
    hasTriangle()

    println("**********İKİNCİ SORU**********")
    choiceMenu()

    println("**********ÜÇÜNCÜ SORU**********")
    numbersCompare()

    println("**********DÖRDÜNCÜ SORU**********")
    nNumber()

    println("**********BEŞ VE ALTINCI SORU**********")
    reversedAndSumNumbers()

    println("**********YEDİNCİ SORU**********")
    numbersOfReport()

}

//birinci soru
fun hasTriangle() {
    val edgeOne = getNumber("Kenarların arasına virgül girerek üç sayı giriniz:").toString()
    val loginNumbers = edgeOne.split(",")
    val numbersList = arrayListOf<Int>()
    if (loginNumbers.size == 3) {
        try {
            for (i in loginNumbers) {
                numbersList.add(i.toInt())
            }
        } catch (e: Exception) {
            println("Hata $e")
            hasTriangle()
        }

        for (j in 0..<numbersList.size) {
            if (j < numbersList.size - 1) {
                val birinciSayi = numbersList.elementAt(j)
                val ikinciSayi = numbersList.elementAt(j + 1)
                val sum = birinciSayi + ikinciSayi
                if ((sum < (if (j != 0) numbersList.first() else numbersList.last()))) {
                    println("Üçgen olamaz")
                    return
                }
            }
        }
        println("üçgen olabilir")
    } else {
        println("Fazla sayı girdiniz")
    }
}


//ikinci soru
fun choiceMenu() {
    println("Menu : ")
    println("1 - F -> C")
    println("2 - C -> F")

    val number = getNumber()
    when (number) {
        1 -> convertToCelcius()
        2 -> convertToFahrenheit()
        else -> println("Hatalı Seçim Yaptınız")

    }
}
fun convertToCelcius() {
    val fahrenheit = getNumber("Dönüştürmek istediğiniz değeri giriniz :")
    val celcius = fahrenheit * 1.8 + 32
    println("Girilen $fahrenheit°F değerinin °C karşılığı -> $celcius°C ")
}
fun convertToFahrenheit() {
    val celcius = getNumber("Dönüştürmek istediğiniz değeri giriniz :")
    val fahrenheit = (celcius - 2) / 1.8
    println("Girilen $celcius°C değerinin °F karşılığı -> $fahrenheit°F ")
}


//üçüncü soru
fun numbersCompare() {
    val numberOne = getNumber("Birinci sayıyı giriniz : ")
    val numberTwo = getNumber("İkinci sayıyı giriniz : ")
    val inList = arrayListOf<Int>()
    inList.addAll(listOf(numberOne, numberTwo))
    println("Büyük sayı: ${inList.max()}")
    println("Küçük sayı: ${inList.min()}")
    if (numberOne == numberTwo) {
        println("Sayılar Eşittir")
    }
}


//dördüncü soru
fun nNumber() {
    val number = getNumber("Bir sayı giriniz")
    val formula = number * (number + 1) / 2
    println("1 - $number Arasındaki Sayıların Toplamı : $formula ")
}

//beşinci ve altıncı soru
fun reversedAndSumNumbers() {
    val number = getNumber("Üç basamaklı bir sayı giriniz : ") { value ->
        value.trim().length == 3
    }.toString()
    val numberReversed = arrayListOf<String>()
    val numberSumTotal = arrayListOf<Int>()
    val splitNumber = number.split("")


    for (i in splitNumber) {
        numberReversed.add(i)
    }
    for (j in number) {
        numberSumTotal.add(j.toString().toInt())
    }

    val numberSum = numberSumTotal.sum()
    val numberOfReversed = numberReversed.reversed().joinToString(separator = "")

    println("Girilen sayının rakamları toplamı : $numberSum")
    println("Girilen sayının tersi : $numberOfReversed")



}



//yedinci soru
fun receiveData(): ArrayList<Int> {
    val number = getNumber("Kaç sayı girilecek")
    println("$number tane sayı giriniz")
    val numberList = arrayListOf<Int>()

    while (true) {
            val inputNumbers = getNumber()
            numberList.add(inputNumbers)
        if (numberList.size == number)
            break
    }
    return numberList
}
fun numbersOfReport() {
    val items = receiveData()
    val pozitifNumberList = arrayListOf<Int>()
    val negatifNumberList = arrayListOf<Int>()
    var enBuyukSayi = Int.MIN_VALUE
    var enKucukSayi = Int.MAX_VALUE
    val eleman = items.size
    val ciftList = arrayListOf<Int>()
    val tekList = arrayListOf<Int>()

    var sumtotal = 0
    var countPozitif = 0
    var countNegatif = 0

    for (i in items) {
        sumtotal += i
        if (i > 0) {
            countPozitif++
            pozitifNumberList.add(i)

        } else {
            countNegatif++
            negatifNumberList.add(i)
        }
        if ((i % 2) == 0) {
            ciftList.add(i)
        } else {
            tekList.add(i)

        }
    }
    for (j in pozitifNumberList) {
        if (j > enBuyukSayi) {
            enBuyukSayi = j
        }

    }
    for (j in negatifNumberList) {
        if (j < enKucukSayi) {
            enKucukSayi = j
        }

    }

    try {
        if (items.size != 0) {
            println("Girilen $eleman Sayıdan: ")
            println("$countPozitif Tanesi Pozitif")
            println("$countNegatif Tanesi Negatif")
            println("En büyüğü : $enBuyukSayi")
            println("En küçüğü : $enKucukSayi")
            println("${ciftList.size} Tanesi Çift")
            println("${tekList.size} Tanesi Tek")
            println("Toplamları : $sumtotal")
            if (sumtotal == 0) {
                println("Toplam değeri 0 olduğu için girilen sayıların ortalaması hesaplanamamıştır.")
            } else {
                val avg: Float = (sumtotal.toDouble() / eleman).toFloat()
                println("Ortalamaları : $avg")
            }
        }
    } catch (e: Exception) {
        println("Hata : $e")
    }
}


fun getNumber(message: String? = null, condition: ((String) -> Boolean)? =null): Int {
    if (message != null)
        println(message)
    val scanValue = readln()
        return try {
            val value = scanValue.toInt()
            if(condition != null){
                if(condition(value.toString())){
                    value
                }else{
                    println("Lütfen kurala uygun bir değer giriniz!")
                    getNumber(message,condition)
                }
            }else{
                value
            }
        } catch (e: Exception) {
            println("Lütfen geçerli bir sayı giriniz!")
            getNumber(message,condition)
        }
}