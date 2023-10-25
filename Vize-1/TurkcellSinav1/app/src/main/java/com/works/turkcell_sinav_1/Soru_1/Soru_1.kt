package com.works.turkcell_sinav_1.Soru_1

/*
Not:
•	Aşağıdaki soruları sınıf ve methodlar ile OOP ye uygun olacak şekilde yazınız. Mümkün olan bölümlerde Inheritance, Abstract, Interface, Static anahtar kelimesi kullanınız.
•	Kullanıcıdan veri alımından bahsedilen değişkenler ile değer oluşturmadır.

1.	Kullanıcıdan 4 Haneli Bir Sayı Alıyorsunuz. Bu Sayının Basamaklarının Toplamını Yazdırıyorsunuz

 */

fun main(args: Array<String>) {

    val number = 9531

    sumOfDigits(number)

}

fun sumOfDigits(num: Int): Int {
    var sumNums: Int = 0
    var remainder:Int = 0
    var tempNum: Int = num
    while (tempNum != 0){
        remainder = (tempNum % 10)
        sumNums += remainder
        tempNum /= 10
    }
    println("Girdiğiniz sayısının rakamlarının toplamı: $sumNums")
    return sumNums
}