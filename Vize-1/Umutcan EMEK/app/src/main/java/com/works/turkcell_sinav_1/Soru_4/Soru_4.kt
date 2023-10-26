package com.works.turkcell_sinav_1.Soru_4

/*
4.	getSumOfAllPrimes adında bir method olusturun bu methodunuza parametre olarak bir n sayısı gönderin
method, 1'den n'e kadar (n dahil) sayılar arasından, asal sayilari bulup bunların toplamını döndürecek
asal sayi bulmak için boolean isPrime(int number) şeklinde ayri bir method oluşturup,
getSumOfAllPrimes methodunun içinde uygun şekilde kullanın.
 */

fun main(args: Array<String>) {

    val n = 99
    getSumOfAllPrimes(n)

}

fun getSumOfAllPrimes(n: Int): Int{
    var sum = 0
    for (i in 2..n) {
        if (isPrime(i)) {
            sum += i
        }
    }
    println("Sonuç = $sum")
    return sum
}

fun isPrime(num: Int): Boolean {
    if (num <= 3) {
        return true
    }

    if (num <= 1 ||num % 2 == 0 || num % 3 == 0) {
        return false
    }

    var i = 3
    while (i * i <= num) {
        if (num % i == 0) {
            return false
        }
        i += 2
    }

    return true
}
