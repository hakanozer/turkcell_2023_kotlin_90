package com.works.turkcell_sinav_1.Soru_3

/*
3.	Seri Toplam Kullanıcıdan Bir N Sayısı Alıyorsunuz. 1'den N'e Kadar Aşağıdaki Seriyi Hesaplayan Bir Uygulama Yapın

1 + 1/1! + 2/2! + 3/3! + 4/4! +	+ n/n!
 */

fun main(args: Array<String>) {

    val n = 2
    result(n)

}

fun result(num: Int): Double {
    var sum = 0.0
    var factorial = 1

    for (i in 1..num) {
        factorial *= i
        sum += i.toDouble() / factorial
    }
    print("1'den girdiğiniz sayıya kadar olan serinin sonucu = $sum")
    return sum

}