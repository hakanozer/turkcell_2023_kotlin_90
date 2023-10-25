package com.bugcompany.vize.Question2

class Question2 {

    fun reverseNumber(number: Int): Int {
        val strNumber = number.toString().reversed()
        return strNumber.toInt()
    }


    /* Fonksiyon bu şekilde de tek satırda yazılabilir.

    fun reverseNumber(number: Int): Int = number.toString().reversed().toInt()

     */

}