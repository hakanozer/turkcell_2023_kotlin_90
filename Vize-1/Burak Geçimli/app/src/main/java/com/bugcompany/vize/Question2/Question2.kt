package com.bugcompany.vize.Question2

class Question2 {

    fun reverseNumber(number: Int): Int {
    val strNumber = number.toString()
    if (strNumber.length != 5) {
        throw IllegalArgumentException("Girilen sayı 5 haneli olmalıdır.")
    }
    val reversedStr = strNumber.reversed()
    return reversedStr.toInt()
    }


    /* Fonksiyon bu şekilde de tek satırda yazılabilir.

    fun reverseNumber(number: Int): Int = number.toString().reversed().toInt()

     */

}
