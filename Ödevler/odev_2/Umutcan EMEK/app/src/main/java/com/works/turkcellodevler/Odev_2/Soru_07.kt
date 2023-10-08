package com.works.turkcellodevler.Odev_2

/*
7 - parametre olarak verilen int sayinin
palindrome olup olmadığını test eden
sonucu boolean olarak döndüren  bir method
yazın

palindrome : düz ve ters yazılışı aynı
olan şeyler örn :
1441 <--> 1441
ata <--> ata
1223221 <--> 1223221
 */

//121 32223 454 4554
fun main(args: Array<String>) {

    val num1 = 474

    println("$num1 polidrom bir sayı mı?")
    if (isPalindrome(num1)){
        println("Evet.")
    }else{
        println("Hayır.")
    }

}

fun isPalindrome(num: Int): Boolean {
    val numStr = num.toString()
    val reversedStr = numStr.reversed()
    return numStr == reversedStr
}