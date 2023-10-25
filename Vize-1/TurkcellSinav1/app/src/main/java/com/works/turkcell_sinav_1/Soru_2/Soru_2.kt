package com.works.turkcell_sinav_1.Soru_2

/*
2.	Kullanıcıdan 5 Haneli Bir Sayı Alıyorsunuz. Bu Sayının Rakamlarını Tersten Yazdırıyorsunuz Örnek :
Sayı: 14532
 23541
 */

fun main(args: Array<String>) {

    reverse(541)

}

fun reverse(num: Int): Int {
    var reversed = 0
    var tempNum = num
    print("$tempNum sayının tersten yazılmış hali: ")
    while (tempNum > 0){
        reversed = tempNum % 10
        tempNum = tempNum / 10
        print(reversed)
    }

    return reversed
}