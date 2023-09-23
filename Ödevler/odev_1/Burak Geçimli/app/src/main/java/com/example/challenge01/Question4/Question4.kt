package com.example.challenge01.Question4

/*
4 - Kullanıcıdan Bir N Sayısı Alıyorsunuz
	1'den N'e Kadar Olan Sayıların Toplamını
	Ekrana Bastırıyorsunuz
 */
fun main(args: Array<String>) {
    try {
        println("Enter a number")
        val num = readlnOrNull()?.toInt()
        if (num!=null){
            println("Normal Sum=${sumNumber(num)}")
            println("Gauss Sum =${gaussSum(num)}")
        }

    } catch (e: Exception) {
        println("Empty or Invalid value")
    }

}

//  1.Yol
fun sumNumber(num: Int): Int {
    var sum = 0
    for (i in 1..num) {
        sum += i
    }
    return sum
}


//  2.Yol
fun gaussSum(num: Int): Int {
    return num * (num + 1) / 2
}
